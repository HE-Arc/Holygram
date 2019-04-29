package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Evaluation;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.EvaluationRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;

@Component
/**
 * Seeder for demons
 */
public class EvaluationSeeder {
	@Autowired
	private EvaluationRepository evaluationRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	public void run() {

	}
}
