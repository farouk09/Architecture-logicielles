

import java.text.ParseException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import session.DaoDatabaseRemote;
import session.TransactionProcessorRemote;

public class testDb {

	public static void main(String[] args) throws NamingException, ParseException  {
		// TODO Auto-generated method stub
		
		Context ctx;
		ctx = new InitialContext();
		

		NamingEnumeration<NameClassPair> list = ctx.list("");
		while ( list.hasMore()) {
			System.out.println(list.next().getName()+"");
		}
		
		TransactionProcessorRemote a = (TransactionProcessorRemote) ctx.lookup("session.TransactionProcessorRemote#session.TransactionProcessorRemote");
		DaoDatabaseRemote b = (DaoDatabaseRemote) ctx.lookup("session.DaoDatabaseRemote#session.DaoDatabaseRemote");

		
		//Date dd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");
		//b.addRentedItem(5, 5, dd);
		/*String filmString = "";
		
		List <Renteditem> films_loués = b.getRentedItems();
		System.out.println(films_loués.size());
		for(Renteditem film : films_loués) {
			
			
		       filmString += "Titre : "+ b.getClientID(film.getCustomerID()).getName()+"\n" ;	}
		
		System.out.println(filmString);*/
		
		System.out.println(  b.getItemID(5).getTitle()   );
		
		
 	}

}
