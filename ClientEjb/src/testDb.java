import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import session.DaoDatabaseRemote;

public class testDb {

	public static void main(String[] args) throws NamingException  {
		// TODO Auto-generated method stub
		
		Context ctx;
		ctx = new InitialContext();
		

		NamingEnumeration<NameClassPair> list = ctx.list("");
		while ( list.hasMore()) {
			System.out.println(list.next().getName()+"");
		}
		
		DaoDatabaseRemote a = (DaoDatabaseRemote) ctx.lookup("session.DaoDatabaseRemote#session.DaoDatabaseRemote");
		a.addClient(70, "sami");
		System.out.println("done");
 	}

}
