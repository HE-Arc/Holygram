package ch.hearc.holygram.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.holygram.data.SearchResultDataWrapper;
import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ServiceRepository;

@Controller
public class SearchController {

    // https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/controllers/SearchController.java
    // https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/model/dto/SearchResult.java
    // https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/service/SearchService.java

    // https://spring.io/guides/tutorials/bookmarks/

    @Autowired
    private DemonRepository dr;

    @Autowired
    private ServiceRepository sr;

    @Autowired
    private CantonRepository cr;

    private static final int PAGE_SIZE = 15;

    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String search(Map<String, Object> model) {
        model.put("demons", dr.findAll());
        model.put("cantons", cr.findAll());
        return "search";
    }

    @RequestMapping(value = "/search/process", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    public String process(Map<String, Object> model, @RequestParam("input_demon") Long demon_id,
                          @RequestParam("input_renown") Optional<Integer> renown,
                          @RequestParam("input_canton") Optional<Long> canton_id,
                          @RequestParam("input_price") Optional<Integer> price, @RequestParam("page") Optional<Integer> page) {

        List<SearchResultDataWrapper> datas = new ArrayList<SearchResultDataWrapper>();

        // Data
        Demon demon = dr.findById(demon_id).get();

        for (Service s : sr.findAllServiceByDemon(demon)) {
            Exorcist e = s.getExorcist();
            if (canton_id.isPresent() && e.getCanton().getId() != canton_id.get())
                continue;
            if (price.isPresent() && s.getPrice() > price.get())
                continue;
            if (renown.isPresent() && e.getRenown() < renown.get())
                continue;

            // Exorcist is corresponding
            SearchResultDataWrapper w = new SearchResultDataWrapper(e, e.getUser(), s.getPrice());
            datas.add(w);
        }

        // Pagination
        int currentPage;
        int lastPage = (int)Math.ceil((double)datas.size() / (double)PAGE_SIZE);

        if(page.isPresent())
        {
            int p = page.get();
            if (p > lastPage)
                currentPage = lastPage;
            else if(p < 1)
                currentPage = 1;
            else
                currentPage = p;
        }
        else
        {
            currentPage = 1;
        }

        List<SearchResultDataWrapper> pageData = new ArrayList<SearchResultDataWrapper>();
        for(int i = (currentPage - 1) * PAGE_SIZE; i < currentPage * PAGE_SIZE && i < datas.size(); i++)
        {
            pageData.add(datas.get(i));
        }

        String currentUrl = "/search/process?input_demon=" + demon_id;
        currentUrl += renown.isPresent() ? "&input_renown=" + renown.get() : "";
        currentUrl += canton_id.isPresent() ? "&input_canton=" + canton_id.get() : "";
        currentUrl += price.isPresent() ? "&input_price=" + price.get() : "";

        model.put("currentUrl", currentUrl);
        model.put("results", pageData);
        model.put("currentPage", currentPage);
        model.put("lastPage", lastPage);

        // return list of exorcists
        return "results";
    }
}