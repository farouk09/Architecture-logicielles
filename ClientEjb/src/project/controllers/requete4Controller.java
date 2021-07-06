package project.controllers;
import session.DaoDatabaseRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import session.TransactionProcessorRemote;
import model.*;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete4Controller  {
	
	
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
    void requete(ActionEvent event) throws NamingException {
    	
		String client2 = textfield1.getText();

		String sld = Double.toString(IQP.Solde(client2));
    	
    	
    	String filmString ;
    	List<Renteditem> overdueItems = IQP.OverdueItems() ;
		filmString = " solde du client : "+sld+"\n" + " --------------------------- \n" + "Les articles en retard : \n";
		
		Context ctx;
		ctx = new InitialContext();
		DaoDatabaseRemote b = (DaoDatabaseRemote) ctx.lookup("session.DaoDatabaseRemote#session.DaoDatabaseRemote");

		for(Renteditem item : overdueItems) {
			
	       filmString += "Titre : "+ b.getItemID(item.getItemID()).getTitle()+" Date : "+item.getDueDate().toString() + "\n" ;	
		
		}
		
		if (overdueItems.isEmpty()) {
			affichage.setText(filmString + " Aucun article en retard");
		} else {
			affichage.setText(filmString);
		}
    	
    
    	
    	
    	
    	
    }



}
