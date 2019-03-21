package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.CantonRepository;
import ch.hearc.holygram.models.Canton;

@Component
/**
 * Seeder for cantons
 * 
 * @author Seg
 *
 */
public class CantonSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

	@Autowired
	private CantonRepository cantonRepository;

	public void run() {

		// Drop data
		cantonRepository.deleteAll();

		// Insert data
		cantonRepository.save(new Canton("AG", "Aargau"));
		cantonRepository.save(new Canton("AI", "Appenzell Innerrhoden"));
		cantonRepository.save(new Canton("AR", "Appenzell Ausserrhoden"));
		cantonRepository.save(new Canton("BE", "Bern"));
		cantonRepository.save(new Canton("BL", "Basel-Landschaft"));
		cantonRepository.save(new Canton("BS", "Basel-Stadt"));
		cantonRepository.save(new Canton("FR", "Fribourg"));
		cantonRepository.save(new Canton("GE", "Geneva"));
		cantonRepository.save(new Canton("GL", "Glarus"));
		cantonRepository.save(new Canton("GR", "Grisons"));
		cantonRepository.save(new Canton("JU", "Jura"));
		cantonRepository.save(new Canton("LU", "Luzern"));
		cantonRepository.save(new Canton("NE", "Neuchâtel"));
		cantonRepository.save(new Canton("NW", "Nidwalden"));
		cantonRepository.save(new Canton("OW", "Obwalden"));
		cantonRepository.save(new Canton("SG", "St. Gallen"));
		cantonRepository.save(new Canton("SH", "Schaffhausen"));
		cantonRepository.save(new Canton("SO", "Solothurn"));
		cantonRepository.save(new Canton("SZ", "Schwyz"));
		cantonRepository.save(new Canton("TG", "Thurgau"));
		cantonRepository.save(new Canton("TI", "Ticino"));
		cantonRepository.save(new Canton("UR", "Uri"));
		cantonRepository.save(new Canton("VD", "Vaud"));
		cantonRepository.save(new Canton("VS", "Valais"));
		cantonRepository.save(new Canton("ZG", "Zug"));
		cantonRepository.save(new Canton("ZH", "Zürich"));

	}
}
