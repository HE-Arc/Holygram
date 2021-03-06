package ch.hearc.holygram.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import ch.hearc.holygram.repositories.CantonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CantonTest {

	@Autowired
	private CantonRepository cr;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void givenAcronymAndName_WhenCantonCreated_ThenCantonIsValid() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton(acronym, name);

		assertTrue(c.getAcronym() == acronym);
		assertTrue(c.getName() == name);
	}

	@Test
	public void tryGetCanton_WhenNotPersisted_ThenIsOk() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton();
		c.setAcronym(acronym);
		c.setName(name);

		Optional<Canton> cantonRecherche = cr.findById(0l);

		assertFalse(cantonRecherche.isPresent());
	}

	@Test
	public void tryInsertCanton_ThenReadIt() {
		final String acronym = "NE";
		final String name = "Neuchâtel";

		Canton c = new Canton();
		c.setAcronym(acronym);
		c.setName(name);

		entityManager.persist(c);
		entityManager.flush();

		Optional<Canton> cantonRecherche = cr.findById(c.getId());

		assertTrue(cantonRecherche.isPresent());
		assertTrue(cantonRecherche.get().getId().equals(c.getId()));
		assertThat(cantonRecherche.get()).isNotNull();
	}
}
