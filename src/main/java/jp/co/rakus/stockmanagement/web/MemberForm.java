package jp.co.rakus.stockmanagement.web;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * @author igamasayuki
 *
 */
public class MemberForm {
	/** 名前 */
	@NotEmpty(message = "値を入力してください")
	private String name;
	/** メールアドレス */
	@NotEmpty(message = "値を入力してください")
	private String mailAddress;
	/** パスワード */
	@NotEmpty(message = "値を入力してください")
	private String password;
	@NotEmpty(message = "値を入力してください")
	private String password2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
