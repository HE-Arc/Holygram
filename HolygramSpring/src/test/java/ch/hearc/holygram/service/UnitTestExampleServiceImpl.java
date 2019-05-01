package ch.hearc.holygram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.repositories.CantonRepository;

@Service
public class UnitTestExampleServiceImpl implements UnitTestExampleService {
	@Autowired
	CantonRepository cantonRepository;

	@Override
	public String homePage() {
		return "Ceci est la home page.";
	}
}
