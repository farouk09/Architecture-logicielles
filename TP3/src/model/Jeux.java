package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("1")
public class Jeux extends StockItem {
	private static final long serialVersionUID = 1L;

    private String plateforme;
    
    public Jeux() {
        super();
    }
    
    public String getPlateforme() {
        return plateforme;
    }
    
    public void setPlateforme(String plateforme) {
        this.plateforme = plateforme;
    }
}