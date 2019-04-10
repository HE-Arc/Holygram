package ch.hearc.holygram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ReligionRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Service
public class SearchService {

	@Autowired
	private CantonRepository cr;

	@Autowired
	private DemonRepository dr;

	@Autowired
	private ExorcistRepository er;

	@Autowired
	private ReligionRepository rr;

	@Autowired
	private ServiceRepository sr;

	@Autowired
	private UserRepository ur;
	
	/* TODO/FIXME
	public Page<SearchResult> search(String text, int pageNumber) {
		PageRequest request = new PageRequest(pageNumber-1, pageSize);
		Page<Profile> results = profileDao.findByInterestsNameContainingIgnoreCase(text, request);
		
		Converter<Profile, SearchResult> converter = new Converter<Profile, SearchResult>() {
			public SearchResult convert(Profile profile) {
				return new SearchResult(profile);
			}
			
		};
		
		return results.map(converter);
	}
	*/

}
