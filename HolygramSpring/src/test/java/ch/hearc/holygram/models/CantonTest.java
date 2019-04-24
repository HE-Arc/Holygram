package ch.hearc.holygram.models;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.seeders.CantonSeeder;

@DataJpaTest
public class CantonTest {

	@Autowired
	private CantonRepository cr;

	
	@Before
	public void setUp() {
	}

	@Test
	public void givenAcronymAndName_WhenCantonCreated_ThenCantonIsValid() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton(acronym, name);
		Assert.isTrue(c.getAcronym() == acronym, "Canton's acronym is invalid");
		Assert.isTrue(c.getName() == name, "Canton's name is invalid");
	}

}
