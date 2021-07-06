package project.controllers;
import session.TransactionProcessorRemote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.format.DateTimeFormatter;


public class requete5Controller  {
	
	private TransactionProcessorRemote ITP;
	
	public void setInterface(TransactionProcessorRemote ITP) {
		
		this.ITP = ITP;
	}
	
	
    @FXML
    private DatePicker datepicker;
    
    @FXML
    private TextField textfield1;

    @FXML
    private Button lancer;

    @FXML
    private TextField textfield2;

    @FXML
    private TextArea affichage;

    @FXML
    private TextArea affichage2;

    @FXML
    private Button lancer2;

    @FXML
    void requete(ActionEvent event) {
    	boolean retour;
    	String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	retour=ITP.CheckOut(textfield2.getText(),textfield1.getText(),date.toString());
    	
		if (retour)
			affichage.setText("Item rented successfully.");
		else
			affichage.setText("Operation failed.");
    	
    }

    @FXML
    void requete2(ActionEvent event) {
    	boolean retour;
    	retour = ITP.CheckIn(textfield2.getText(),textfield1.getText());
    	
		if (retour)
			affichage2.setText("Item returned successfully.");
		else
			affichage2.setText("Operation failed.");
    	
    }



}
