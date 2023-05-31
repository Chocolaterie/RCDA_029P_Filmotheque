package fr.eni.movielibrary.ihm;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"loggedUser"})
public class EniController {
	
	public boolean isLogged(Model model) {
		return model.getAttribute("loggedUser") != null;
	}
}
