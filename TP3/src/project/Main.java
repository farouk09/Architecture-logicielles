package project;

import javafx.application.Application;

public class Main {
	public static void main(String[] args) {

		InterfaceDao db_dao = new Dao();
		InterfaceQueryProcessor qp = new QueryProcessor(db_dao);
		InterfaceTransactionProcessor tp = new TransactionProcessor(db_dao);

		Gui gui = new Gui();
		gui.setInterface(tp, qp);

		new Thread() {
			@Override
			public void run() {
				Application.launch(Gui.class, args);
			}
		}.start();
		
	}
}