package project;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Gui extends Application  {
	
	private static InterfaceTransactionProcessor ITP;
	private static InterfaceQueryProcessor IQP;

	
    public void setInterface (InterfaceTransactionProcessor ITP ,InterfaceQueryProcessor IQP ) {
    	Gui.ITP = ITP;
    	Gui.IQP = IQP;
    }
    
    public void start(Stage stage) throws Exception{
    	
    	
		try {
			FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = (Parent) fxmloader.load();
			
			Scene scene = new Scene(root,680,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SampleController control = fxmloader.<SampleController>getController() ;
			
			control.setInterface(ITP,IQP);
			
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
 
	
					
		
		
		
	}


