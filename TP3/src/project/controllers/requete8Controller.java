package project.controllers;
import javafx.event.ActionEvent;
import project.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete8Controller  {
	
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

    	ITP.AddCustomer(textfield1.getText(),Double.parseDouble(textfield2.getText()));

    	affichage.setText("Client ajouté avec succes");
    	
    }



}
