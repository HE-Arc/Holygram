package ch.hearc.holygram.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import ch.hearc.holygram.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

	@Autowired
	private UserRepository ur;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void givenUsernameEmailPassword_WhenCreateUser_ThenUserIsValid() {

		final String username = "Unittester";
		final String password = "Password";
		final String email = "unittester@cookie.ch";

		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);

		entityManager.persist(u);
		entityManager.flush();

		Assert.isTrue(u.getUsername() == username, "User's username is invalid");
		Assert.isTrue(u.getPassword() == password, "Role's password is invalid");
		Assert.isTrue(u.getEmail() == email, "Role's email is invalid");
	}

	@Test
	public void tryInsertUser_ThenReadIt() {
		final String role = "UNITTEST_USER";
		final String username = "Unittester";
		final String password = "Password";
		final String email = "unittester@cookie.ch";

		Role r = new Role(role);

		entityManager.persist(r);
		entityManager.flush();

		User u;
		try {
			u = new User(username, password, email, r);

			entityManager.persist(u);
			entityManager.flush();

			Optional<User> userRecherche = ur.findById(u.getId());

			assertTrue(userRecherche.isPresent());
			assertThat(userRecherche.get()).isNotNull();
			assertTrue(userRecherche.get().getId().equals(u.getId()));

		} catch (Exception e) {
			assertTrue(false); // Fail
		}
	}
}
