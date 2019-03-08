package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
/**
 * Class representing a swiss canton
 * @author Seg
 *
 */
public class Canton {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String acronym;

	/**
	 * Constructor of class "Canton"
	 * @param acronym
	 * @param name
	 */
	public Canton(String acronym, String name) {
		this.acronym = acronym;
		this.name = name;
	}
	
	public Canton() {
		
	}

	public String getAcronym()
	{
		return this.acronym;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString() {
		return "TODO";
	}

}
