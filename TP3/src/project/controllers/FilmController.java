package project.controllers;
import project.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class FilmController implements Initializable {

	public void setLoc(String loc) {
		locationPrice = loc;
	}

	public void setName(String article) {
		articleName = article;
	}
	
	private InterfaceTransactionProcessor transactionInterface;
	
	public void setInterface(InterfaceTransactionProcessor transactionInterface)
	{
		this.transactionInterface = transactionInterface;
	}
	
	private static String locationPrice, articleName;
	@FXML
	private TextField actorName;

	@FXML
	private Label label;

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();

	}

	@FXML
	public void addPushed(ActionEvent event) throws IOException {
		if (transactionInterface.AddStockItem(Double.parseDouble(locationPrice), articleName, false, "-", actorName.getText()))
			label.setText("Item added successfully.");
		else
			label.setText("Operation failed.");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
