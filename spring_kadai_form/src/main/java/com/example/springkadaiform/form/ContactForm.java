package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//フォームクラスを定義し、お問い合わせフォームの各入力項目を管理。
//バリデーション条件（後述）も設定する。

@Data
public class ContactForm {

	@NotBlank(message = "お名前を入力してください。")	
	private String name;

	@NotBlank(message ="メールアドレスを入力してください。")
	@Email(message = "メールアドレスの入力形式が正しくありません。")
	private String email;

	@NotBlank(message = "お問い合わせ内容を入力してください。")
	private String message;
}



