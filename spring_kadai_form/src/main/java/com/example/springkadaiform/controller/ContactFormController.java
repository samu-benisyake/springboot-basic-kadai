package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;



////フォーム・確認画面への各リクエストに応じて、適切なビューを表示。
//バリデーション結果に応じて、表示内容を切り替える必要がある。
//
//バリデーションOK：確認画面を表示
//バリデーションNG：元のフォームへリダイレクト

@Controller
public class ContactFormController { 

	@GetMapping("/form")
	public String showForm(Model model) {

		if (!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm",new ContactForm());

		}
		return "contactFormView";
	}


	@PostMapping("/form")
	public String confirmForm(Model model, RedirectAttributes redirectAttributes,
			@Validated ContactForm contactForm,BindingResult result) {

		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			redirectAttributes.addFlashAttribute(
					BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(contactForm), result);

			// フォーム画面にリダイレクト
			return "redirect:/form";
		}

		model.addAttribute("contactForm", contactForm);
		return "confirmView";

	}






}
