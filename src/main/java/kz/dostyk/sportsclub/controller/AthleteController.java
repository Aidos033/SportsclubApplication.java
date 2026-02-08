package kz.dostyk.sportsclub.controller;

import kz.dostyk.sportsclub.entity.Athlete;
import kz.dostyk.sportsclub.service.AthleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<Athlete> getAll() {
        return athleteService.getAllAthletes();
    }

    @GetMapping("/{id}")
    public Athlete getById(@PathVariable Long id) {
        return athleteService.getAthleteById(id);
    }

    @PostMapping
    public Athlete create(@RequestBody Athlete athlete) {
        return athleteService.saveAthlete(athlete);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
    }
}
