package project.controllers;
import session.TransactionProcessorRemote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class requete2Controller  {
	
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
    void requete(ActionEvent event) {

		String titre = textfield1.getText();
		if ( IQP.FindByTitle(titre))
		{
			affichage.setText("Article disponible pour la location");
		}
	
		else affichage.setText("Article non disponible pour la location ");
    	
    	

    }
	
	
   

}
	

