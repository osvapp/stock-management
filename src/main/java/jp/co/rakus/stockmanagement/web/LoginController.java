package jp.co.rakus.stockmanagement.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.service.MemberService;

/**
 * ログイン関連処理を行うコントローラー.
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private HttpSession session;
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	/**
	 * ログイン画面を表示します.
	 * @return ログイン画面
	 * @throws Exception 
	 */
	@RequestMapping("/")
	public String index(){
		logger.debug("ログインページを表示");
		return "loginForm";
	}
	
	/**
	 * ログイン処理を行います.
	 * @param form　フォーム
	 * @param result　リザルト
	 * @param model　モデル
	 * @return　ログイン成功時：書籍リスト画面
	 */
	@RequestMapping(value = "/login")
	public String login(@Validated LoginForm form,
			BindingResult result, Model model,RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()){
			logger.debug("ログインに失敗しました");
			return index();
		}
		
		String mailAddress = form.getMailAddress();
		Member member = memberService.findOneByMailAddress(mailAddress);
		
//		System.out.println(member);
		
		if (member == null) {
			logger.debug("該当するメールアドレスが見つかりません");
			ObjectError error = new ObjectError("loginerror", "メールアドレスまたはパスワードが違います。");
            result.addError(error);
			return index();
		}
		
		if (!passwordEncoder.matches(form.getPassword(),member.getPassword())) {
			logger.debug("パスワードが一致しません");
			ObjectError error = new ObjectError("loginerror", "メールアドレスまたはパスワードが違います。");
            result.addError(error);
			return index();
		}
//		model.addAttribute("member", member);
//		redirectAttributes.addFlashAttribute("member", member);
		session.setAttribute("member", member);
		logger.debug("ログインに成功しました");
		return "redirect:/book/list";
	}
}
