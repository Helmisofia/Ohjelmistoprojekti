package sportslist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sportslist.domain.ActionRepository;
import sportslist.domain.Sport;
import sportslist.domain.SportslistRepository;

@Controller
public class SportslistController {

	@Autowired 
	private SportslistRepository repository;
	
	@Autowired
	private ActionRepository arepository; 

	@RequestMapping(value = "/index", method=RequestMethod.GET)	
	public String home(Model model) {
		return null;
				
	}

	// Login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value = {"/", "/sportslist"})	
	public String getSportsList(Model model) {

		List<Sport> sports = (List<Sport>) repository.findAll();
		
		model.addAttribute("sports", sports);

		return "sportslist";
				
	}
	
    @RequestMapping(value="/sports", method = RequestMethod.GET)
    public @ResponseBody List<Sport> sportListRest() {	
        return (List<Sport>) repository.findAll();
    }    

    @RequestMapping(value="/sport/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Sport> findSportRest(@PathVariable("id") Long sportId) {	
    	return repository.findById(sportId);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchSport(@RequestParam(value="searchCriteria") String searchCriteria, Model model){
        List<Sport> sports = repository.findByPlaceContainingOrExerciseContainingAllIgnoreCase(searchCriteria, searchCriteria);
		model.addAttribute("sports", sports);

		return "sportslist";
    }     
    
	
    @RequestMapping(value = "/addsport")
    public String addSport(Model model){
    	model.addAttribute("sport", new Sport());
    	model.addAttribute("actions", arepository.findAll());
        return "addsport";	
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Sport sport){
        repository.save(sport);
        return "redirect:/sportslist";	
    }
    
    @RequestMapping(value = "/editsport/{id}")
	public String editSport(@PathVariable("id") Long sportId, Model model) {
	
    	model.addAttribute("sport", repository.findById(sportId));
    	model.addAttribute("actions", arepository.findAll());
    	repository.deleteById(sportId);
    	return "editsport";
    }

    @RequestMapping(value = "editsport/save", method = RequestMethod.POST)
    public String saveEdit(Sport sport){
        repository.save(sport);
        return "redirect:../sportslist";
    }    
    
	@RequestMapping(value = "/delete/{id}")	
	public String deleteSport(@PathVariable("id") Long sportId) {

		repository.deleteById(sportId);
		
		return "redirect:../sportslist";

	}
	
}