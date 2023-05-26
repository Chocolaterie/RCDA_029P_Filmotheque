package fr.eni.movielibrary.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.eni.movielibrary.bo.Member;

@Controller
@SessionAttributes({"loggedUser"})
public class UserController {

	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("user", new Member());
		
		return "user/login-form";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute("formUser") Member member, Model model) {
		
		// Ajouter en session
		model.addAttribute("loggedUser", member);
		
		// Redirection sur l'accueil
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		
		// Vide la session
		sessionStatus.setComplete();
		
		// Redirection sur l'accueil
		return "redirect:/";
	}
}
