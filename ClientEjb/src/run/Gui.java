package run;


import javafx.application.Application;
import javafx.stage.Stage;
import session.TransactionProcessorRemote;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Gui extends Application  {
	
	private static TransactionProcessorRemote ITP;

	
    public void setInterface (TransactionProcessorRemote ITP ) {
    	Gui.ITP = ITP;
    }
    
    public void start(Stage stage) throws Exception{
    	
    	
		try {
			FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = (Parent) fxmloader.load();
			
			Scene scene = new Scene(root,680,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SampleController control = fxmloader.<SampleController>getController() ;
			
			control.setInterface(ITP);
			
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
 
	
					
		
		
		
	}


