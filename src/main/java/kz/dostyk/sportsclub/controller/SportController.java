package kz.dostyk.sportsclub.controller;

import kz.dostyk.sportsclub.entity.Sport;
import kz.dostyk.sportsclub.service.SportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {

    private final SportService service;

    public SportController(SportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sport> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Sport create(@RequestBody Sport sport) {
        return service.save(sport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
