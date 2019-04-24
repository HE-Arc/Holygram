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

import ch.hearc.holygram.repositories.ServiceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTest {

	@Autowired
	private ServiceRepository sr;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void givenData_WhenCreateService_ThenServiceIsValid() {
		final String demon = "Ghost";
		final String religion = "Christianism";
		final String role = "EXORCIST";

		final String username = "Unittester";
		final String password = "Password";
		final String email = "unittester@cookie.ch";

		final String description = "foo bar baz";
		final String phone = "+41 23 456 789";

		final String canton = "Neuchâtel";
		final String acronym = "NE";

		final float price = 10.0f;

		Canton c = new Canton(acronym, canton);
		Religion r = new Religion(religion);
		Demon d = new Demon(demon, r);
		Role ro = new Role(role);
		User u = null;
		try {
			u = new User(username, password, email, ro);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Exorcist e = new Exorcist(u, description, phone, c);

		Service s = new Service(e, d, price);

		Assert.isTrue(s.getDemon() == d, "Service's demon is invalid");
		Assert.isTrue(s.getExorcist() == e, "Service's exorcist is invalid");
		Assert.isTrue(s.getPrice() == price, "Service's price is invalid");
	}
	
	@Test
	public void tryGetService_WhenNotPersisted_ThenIsOk() {
		final String demon = "Ghost";
		final String religion = "Christianism";
		final String role = "EXORCIST";

		final String username = "Unittester";
		final String password = "Password";
		final String email = "unittester@cookie.ch";

		final String description = "foo bar baz";
		final String phone = "+41 23 456 789";

		final String canton = "Neuchâtel";
		final String acronym = "NE";

		final float price = 10.0f;

		Canton c = new Canton(acronym, canton);
		Religion r = new Religion(religion);
		Demon d = new Demon(demon, r);
		Role ro = new Role(role);
		User u = null;
		try {
			u = new User(username, password, email, ro);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Exorcist e = new Exorcist(u, description, phone, c);

		Service s = new Service(e, d, price);

		Assert.isTrue(s.getDemon() == d, "Service's demon is invalid");
		Assert.isTrue(s.getExorcist() == e, "Service's exorcist is invalid");
		Assert.isTrue(s.getPrice() == price, "Service's price is invalid");
		
		Optional<Service> serviceRecherche = sr.findById(r.getId());

		assertFalse(serviceRecherche.isPresent());
	}

	@Test
	public void tryInsertService_ThenReadIt() {
		final String demon = "Ghost";
		final String religion = "Christianism";
		final String role = "EXORCIST";

		final String username = "Unittester";
		final String password = "Password";
		final String email = "unittester@cookie.ch";

		final String description = "foo bar baz";
		final String phone = "+41 23 456 789";

		final String canton = "Neuchâtel";
		final String acronym = "NE";

		final float price = 10.0f;

		Canton c = new Canton(acronym, canton);

		entityManager.persist(c);
		entityManager.flush();

		Religion r = new Religion(religion);

		entityManager.persist(r);
		entityManager.flush();

		Demon d = new Demon(demon, r);

		entityManager.persist(d);
		entityManager.flush();

		Role ro = new Role(role);

		entityManager.persist(ro);
		entityManager.flush();

		User u;
		try {
			u = new User(username, password, email, ro);

			entityManager.persist(u);
			entityManager.flush();

			Exorcist e = new Exorcist(u, description, phone, c);

			entityManager.persist(e);
			entityManager.flush();

			Service s = new Service(e, d, price);

			entityManager.persist(s);
			entityManager.flush();

			Optional<Service> serviceRecherche = sr.findById(s.getId());

			assertTrue(serviceRecherche.isPresent());
			assertThat(serviceRecherche.get()).isNotNull();
			assertTrue(serviceRecherche.get().getId().equals(s.getId()));
			assertTrue(serviceRecherche.get().getExorcist().equals(e));
			assertTrue(serviceRecherche.get().getDemon().equals(d));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
