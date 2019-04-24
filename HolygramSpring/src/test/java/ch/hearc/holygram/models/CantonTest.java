package ch.hearc.holygram.models;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import ch.hearc.holygram.repositories.CantonRepository;

@DataJpaTest
public class CantonTest {

	@MockBean
	private CantonRepository cr;

	@Test
	public void givenAcronymAndName_WhenCantonCreated_ThenCantonIsValid() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton(acronym, name);
		Assert.isTrue(c.getAcronym() == acronym, "Canton's acronym is invalid");
		Assert.isTrue(c.getName() == name, "Canton's name is invalid");
	}

	@Test
	public void tryInsertCanton_ThenReadIt() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton(acronym, name);
		cr.save(c);

		Assert.isTrue(c.equals(cr.findByAcronym(acronym)), "Canton not found when just saved");
	}

}
