package run;


import javafx.application.Application;
import session.TransactionProcessorRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args) throws NamingException {
		Context ctx;
		ctx = new InitialContext();
		TransactionProcessorRemote tp = (TransactionProcessorRemote) ctx.lookup("session.TransactionProcessorRemote#session.TransactionProcessorRemote");

		Gui gui = new Gui();
		gui.setInterface(tp);

		new Thread() {
			@Override
			public void run() {
				Application.launch(Gui.class, args);
			}
		}.start();
		
	}
}