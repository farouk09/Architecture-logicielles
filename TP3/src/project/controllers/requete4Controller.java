package project.controllers;
import project.*;
import model.*;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete4Controller  {
	
	
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
    	
		String client2 = textfield1.getText();

		String sld = Double.toString(IQP.Solde(client2));
    	
    	
    	String filmString ;
    	List<RentedItem> overdueItems = IQP.OverdueItems() ;
		filmString = " solde du client : "+sld+"\n" + " --------------------------- \n" + "Les articles en retard : \n";

		for(RentedItem item : overdueItems) {
			
	       filmString += "Titre : "+ item.getItem().getTitle()+" Date : "+item.getDueDate().toString() + "\n" ;	
		
		}
		
		if (overdueItems.isEmpty()) {
			affichage.setText(filmString + " Aucun article en retard");
		} else {
			affichage.setText(filmString);
		}
    	
    
    	
    	
    	
    	
    }



}
