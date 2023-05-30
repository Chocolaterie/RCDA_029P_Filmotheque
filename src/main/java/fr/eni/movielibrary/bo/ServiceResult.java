package fr.eni.movielibrary.bo;

import java.util.ArrayList;
import java.util.List;

public class ServiceResult {

	List<String> errors = new ArrayList<String>();
	
	public ServiceResult(){
		
	}
	
	/**
	 * Ajouter une erreur
	 * @param error
	 */
	public void addError(String error) {
		errors.add(error);
	}
	
	/**
	 * Retourne les erreurs
	 * @return
	 */
	public List<String> getErrors(){
		return errors;
	}
	
	/**
	 * Est-ce que c'est valide
	 * @return
	 */
	public boolean isValid() {
		return errors.size() == 0;
	}
}
