package ch.hearc.holygram.seeders;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Evaluation;
import ch.hearc.holygram.models.Religion;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.EvaluationRepository;
import ch.hearc.holygram.repositories.ReligionRepository;
import ch.hearc.holygram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
/**
 * Seeder for demons
 */
public class EvaluationSeeder {
	@Autowired
	private EvaluationRepository evaluationRepository;

	@Autowired
	private UserRepository userRepository;

	public void run() {
		evaluationRepository.deleteAll();

		Evaluation evaluation = new Evaluation();
		evaluation.setText("Very godd service, so cheap and so fast, incredible. I still can't believe my eyes how he masters his wand");
		evaluation.setPositive(true);
		evaluation.setCustomer(userRepository.findById(1l).get().getCustomer());
		evaluation.setExorcist(userRepository.findById(2l).get().getExorcist());

		evaluationRepository.save(evaluation);
	}
}
