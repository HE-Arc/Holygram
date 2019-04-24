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

import ch.hearc.holygram.repositories.ReligionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReligionTest {

	@Autowired
	private ReligionRepository rr;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void givenName_WhenReligionCreated_ThenReligionIsValid() {
		final String religion = "Christianism";

		Religion r = new Religion(religion);

		Assert.isTrue(r.getName() == religion, "Religion's name is invalid");
	}

	@Test
	public void tryInsertReligion_ThenReadIt() {
		final String religion = "Christianism";

		Religion r = new Religion(religion);

		entityManager.persist(r);
		entityManager.flush();

		Optional<Religion> religionRecherche = rr.findById(r.getId());

		assertTrue(religionRecherche.isPresent());
		assertThat(religionRecherche.get()).isNotNull();
		assertTrue(religionRecherche.get().getId().equals(r.getId()));

	}

	@Test
	public void tryInsertDemon_WhenReligionExist_ThenReadIt() {
		final String religion = "Christianism";
		final String demon = "Ghost";

		Religion r = new Religion(religion);

		entityManager.persist(r);
		entityManager.flush();

		Demon d = new Demon(demon, r);

		entityManager.persist(d);
		entityManager.flush();

		Optional<Religion> religionRecherche = rr.findById(r.getId());

		assertTrue(religionRecherche.isPresent());
		assertThat(religionRecherche.get()).isNotNull();
		assertTrue(religionRecherche.get().getDemons().size() == 1);
		assertTrue(religionRecherche.get().getDemons().contains(d));

	}

	@Test
	public void tryGetReligion_WhenNotPersisted_ThenIsOk() {
		final String religion = "Christianism";

		Religion r = new Religion(religion);
		Optional<Religion> religionRecherche = rr.findById(0l);

		assertFalse(religionRecherche.isPresent());
	}

}
