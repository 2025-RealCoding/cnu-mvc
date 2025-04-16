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
        try {
            memberService.join(new Member("kim", "kim@gmail.com", "010-1234-5678", "1234"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원등록 화면
    @GetMapping("/join")
    public String joinForm() {
        return "member/joinMemberForm";
    }

    //회원등록
    @PostMapping("/join")
    public String join(Member member, Model model) {

        try {
            memberService.join(member);
            model.addAttribute(member);
            return "member/member";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "member/joinMemberForm";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("pwd") String pwd, HttpSession session, Model model){

        try {
            Member member = memberService.validateMember(email, pwd);
            session.setAttribute("currentMember", member);      // session 추가
            model.addAttribute("memberName", member.getName());
            return "loginHome";

        } catch (Exception e) {
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
