package kz.dostyk.sportsclub.controller;

import kz.dostyk.sportsclub.entity.SportsClub;
import kz.dostyk.sportsclub.service.SportsClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class SportsClubController {

    private final SportsClubService service;

    public SportsClubController(SportsClubService service) {
        this.service = service;
    }

    @GetMapping
    public List<SportsClub> getAll() {
        return service.findAll();
    }

    @PostMapping
    public SportsClub create(@RequestBody SportsClub club) {
        return service.save(club);
    }
}
