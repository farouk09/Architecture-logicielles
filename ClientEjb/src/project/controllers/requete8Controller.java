package project.controllers;
import javafx.event.ActionEvent;
import session.TransactionProcessorRemote;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete8Controller  {
	
	private TransactionProcessorRemote ITP;
	
	public void setInterface(TransactionProcessorRemote ITP) {
		
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
