package project;

import java.util.ArrayList;
import java.util.List;
import model.*;

public interface InterfaceQueryProcessor {
	
	public boolean FindByTitle(String title);
	
	public List<Film> NdByActor(String acteur);
	
	//public boolean IsCheckedOut(int articleID);
	
	public double Solde(String name);
	
	public ArrayList<RentedItem> RentedFilms(String name);
	
	public ArrayList<RentedItem> OverdueItems();

}
