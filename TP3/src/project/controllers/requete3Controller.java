package project.controllers;
import project.*;
import model.*;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class requete3Controller  {
	
	
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
	    void requete(ActionEvent event) {
	    	
	    	String client = textfield1.getText();
			String filmString = "";
			List <RentedItem> films_loués = IQP.RentedFilms(client);
			for(RentedItem film : films_loués) {
				
				
			       filmString += "Titre : "+ film.getItem().getTitle()+" Date : "+film.getDueDate().toString() + "\n" ;	}
			if (films_loués.isEmpty()) {
				affichage.setText("Aucun film loué par ce client");
			} else {
				affichage.setText(filmString);
			}
	    	
	    
	    	
	    }



}
