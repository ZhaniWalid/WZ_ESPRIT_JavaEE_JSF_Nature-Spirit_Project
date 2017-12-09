package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Journalist
 *
 */
@Entity
@XmlRootElement
public class Journalist extends Member implements Serializable {

	
	private String Num_Journalist_Card;
	private static final long serialVersionUID = 1L;

	public Journalist() {
		super();
	}

	

	public String getNum_Journalist_Card() {
		return this.Num_Journalist_Card;
	}

	public void setNum_Journalist_Card(String Num_Journalist_Card) {
		this.Num_Journalist_Card = Num_Journalist_Card;
	}

}
