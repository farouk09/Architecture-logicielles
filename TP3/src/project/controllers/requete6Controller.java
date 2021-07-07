package project.controllers;
import project.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete6Controller  {
	
	//ajouter penalite

	
	private InterfaceTransactionProcessor ITP;
	
	public void setInterface(InterfaceTransactionProcessor ITP) {
		
		this.ITP = ITP;
	}
	
	@FXML
    private TextField textfield1;

    @FXML
    private Button lancer;
    
    @FXML
    private TextArea affichage;


    @FXML
    private TextField textfield2;

    @FXML
    void requete(ActionEvent event) {
    	boolean retour;
    	retour = ITP.AddPenality(textfield1.getText(),Double.parseDouble(textfield2.getText()));
    	
		if (retour)
	    	affichage.setText("Solde client débité ");

		else
			affichage.setText("Solde client insuffisant");
		
    	
    	
    }



}
