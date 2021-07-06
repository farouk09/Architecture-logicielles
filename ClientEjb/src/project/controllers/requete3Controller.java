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

public class requete3Controller  {
	
	
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
	    	
	    	String client = textfield1.getText();
			String filmString = "";
			List <Renteditem> films_loués = IQP.RentedFilms(client);
			
			Context ctx;
			ctx = new InitialContext();
			DaoDatabaseRemote b = (DaoDatabaseRemote) ctx.lookup("session.DaoDatabaseRemote#session.DaoDatabaseRemote");

			for(Renteditem film : films_loués) {
				
				
			     filmString += "Titre : "+ b.getItemID(film.getItemID()).getTitle()+" Date : "+film.getDueDate().toString() + "\n" ;	}
			if (films_loués.isEmpty()) {
				affichage.setText("Aucun film loué par ce client");
			} else {
				affichage.setText(filmString);
			}
	    	
	    
	    	
	    }



}
