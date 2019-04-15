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
		evaluationRepository.deleteAll();

		Evaluation evaluation = new Evaluation();
		evaluation.setText(
				"Very good service, so cheap and so fast, incredible. I still can't believe my eyes how he masters his wand");
		evaluation.setPositive(true);
		evaluation.setCustomer(customerRepository.findById(1l).get());
		evaluation.setExorcist(exorcistRepository.findById(1l).get() );

		evaluationRepository.save(evaluation);
	}
}
