package ch.hearc.holygram.models;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
/**
 * Class representing a religion
 * @author Seg
 *
 */
public class Religion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;

	@OneToMany
	private Set<Demon> demons;

	public Religion(String name, Demon... demons) {
		this.name = name;
		this.demons = Stream.of(demons).collect(Collectors.toSet());
	}
	
	public Religion()
	{
		
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
