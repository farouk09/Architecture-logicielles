package project.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import project.*;
import model.*;


public class requeteController  {
	
	

	private InterfaceQueryProcessor IQP;

	public void setInterface(InterfaceQueryProcessor IQP) {
		
		this.IQP = IQP;
	}
	
	@FXML
    private TextField textfield1;

    @FXML
    private Button lancer;

    @FXML
    private TextArea affichage;

    @FXML
    void requete1(ActionEvent event) {

    	
    	
    	String filmString = "";
		String acteur = textfield1.getText();
		ArrayList<Film> films = (ArrayList<Film>) IQP.NdByActor(acteur);
		for(Film film : films) {
			
	       filmString += "Titre : "+ film.getTitle() + "\n" ;	
	     
		
		}
		
		if (films.isEmpty()) {
			affichage.setText("Aucun film disponible pour cet acteur");
		} 
		
		else {
			affichage.setText(filmString);
		}
    	
    	
    	
    	
    	
    	
    	
    }



}
