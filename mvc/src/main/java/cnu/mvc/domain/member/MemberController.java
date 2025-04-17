package cnu.mvc.domain.member;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostConstruct
    public void init() {
        memberService.save(new Member("kim", "kim@gmail.com", "010-1234-5678", "1234"));
    }
    // 회원등록 화면
    @GetMapping("/join")
    public String joinForm() {
        return "member/joinMemberForm";
    }
    //회원등록
    /*@PostMapping("/join")
    public String join(Member member, Model model) {
        memberService.save(member);
        return "member/member";
    }*/
    // 회원등록 처리
    @PostMapping("/join")
    public String join(Member member, Model model) {
        try {
            memberService.join(member); // 이메일 중복 검사 포함
            return "member/member";     // 성공 시
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "member/joinMemberForm";  // 실패 시 다시 폼으로
        }
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("pwd") String pwd,
                        HttpSession session,
                        Model model) {
        try {
            memberService.validateMember(email, pwd); // 이메일/비밀번호 확인
            Member member = memberService.findByEmail(email).get();
            session.setAttribute("currentMember", member);
            model.addAttribute("memberName", member.getName());
            return "loginHome";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index"; // 로그인 폼으로 다시 이동
        }
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}