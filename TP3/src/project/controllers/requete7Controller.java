package project.controllers;
import project.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class requete7Controller {
	
	
	private InterfaceTransactionProcessor ITP;
	
	public void setInterface(InterfaceTransactionProcessor ITP) {
		
		this.ITP = ITP;
	}
	
	
	@FXML
    private TextField textfield1;

    @FXML
    private Button lancer;

    @FXML
    private TextField textfield2;

    @FXML
    private RadioButton bool;
    
    @FXML
    private TextArea affichage;

    @FXML
    private TextField textfield3;

    @FXML
    private TextField textfield4;

    @FXML
    void requete(ActionEvent event) {
    	boolean s;
    	if (bool.isSelected()==true) {
    		s=false;
    	}
    	else {
    		s=true;
    	}
    	
    	
    	ITP.AddStockItem(Double.parseDouble(textfield2.getText()),textfield1.getText(),s,textfield3.getText(),textfield4.getText());
    	affichage.setText("Article ajouté avec succés");
    	
    	    	
    	
    }



}
