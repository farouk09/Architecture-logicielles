package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("2")
public class Film extends Stockitem {
	private static final long serialVersionUID = 1L;

    private String acteur;
    
    public Film() {
        super();
    }
    
    public String getActeur() {
        return acteur;
    }
    
    public void setActeur(String acteur) {
        this.acteur = acteur;
    }
}