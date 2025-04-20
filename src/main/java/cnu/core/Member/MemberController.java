package cnu.core.Member;
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

    // 회원등록 화면
    @GetMapping("/join")
    public String joinForm() {
        return "member/joinMemberForm";
    }

    //회원등록
    @PostMapping("/join")
    public String join(Member member, Model model) {
        memberService.join(member);
        return "member/member";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("pwd") String pwd, HttpSession session, Model model) {
        try {
            Member member = memberService.validateMember(email, pwd);
            session.setAttribute("currentMember", member);
            model.addAttribute("memberName", member.getName());
            return "member/loginHome";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}