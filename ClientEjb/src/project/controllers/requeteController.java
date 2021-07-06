package project.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import session.TransactionProcessorRemote;


public class requeteController  {
	
	

	private TransactionProcessorRemote IQP;

	public void setInterface(TransactionProcessorRemote IQP) {
		
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
		ArrayList<String> films = (ArrayList<String>) IQP.NdByActor(acteur);
		for(String film : films) {
			
	       filmString += "Titre : "+ film + "\n" ;	
	     
		
		}
		
		if (films.isEmpty()) {
			affichage.setText("Aucun film disponible pour cet acteur");
		} 
		
		else {
			affichage.setText(filmString);
		}
    	
    	
    	
    	
    	
    	
    	
    }



}
