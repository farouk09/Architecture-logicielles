package project;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import project.controllers.*;

public class SampleController  {
	
	
	private InterfaceTransactionProcessor ITP;
	private InterfaceQueryProcessor IQP;

	
    public void setInterface (InterfaceTransactionProcessor ITP ,InterfaceQueryProcessor IQP ) {
    	this.ITP = ITP;
    	this.IQP = IQP;
    }
    
  
    
	
	
	@FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn7;

    @FXML
    void requete1(ActionEvent event) {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	
		requeteController control = fxmlLoader.<requeteController>getController() ;

		control.setInterface(IQP);
    	
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	}catch(Exception e ) {
    		System.out.println("cannot load ");
    	}


    }

    @FXML
    void requete2(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete2.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete2Controller control = fxmlLoader.<requete2Controller>getController() ;

			control.setInterface(IQP);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete3(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete3.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete3Controller control = fxmlLoader.<requete3Controller>getController() ;

			control.setInterface(IQP);
        	
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete4(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete4.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete4Controller control = fxmlLoader.<requete4Controller>getController() ;

			control.setInterface(IQP);

        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete5(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete5.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete5Controller control = fxmlLoader.<requete5Controller>getController() ;

			control.setInterface(ITP);

        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete6(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete6.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete6Controller control = fxmlLoader.<requete6Controller>getController() ;

			control.setInterface(ITP);

        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete7(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete7.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete7Controller control = fxmlLoader.<requete7Controller>getController() ;

			control.setInterface(ITP);

        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete8(ActionEvent event) throws IOException {
    	
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/requete8.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete8Controller control = fxmlLoader.<requete8Controller>getController() ;

			control.setInterface(ITP);

        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	
        	
        	
     
        	

    }


	
}
