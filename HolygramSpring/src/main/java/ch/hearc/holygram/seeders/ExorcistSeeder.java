package ch.hearc.holygram.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Component
/**
 * Seeder for cantons
 */
public class ExorcistSeeder {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	public void run() {

		try {

			// Drop data
			exorcistRepository.deleteAll();

			// Get user
			Optional<User> user = userRepository.findByUsername("exorcist");

			// Insert data
			String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
			exorcistRepository.save(new Exorcist(user.get(), description, "+41 XX XXX XX XX"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
