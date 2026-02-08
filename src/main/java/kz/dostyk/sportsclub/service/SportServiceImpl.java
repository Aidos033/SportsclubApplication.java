package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.Sport;
import kz.dostyk.sportsclub.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    private final SportRepository repository;

    public SportServiceImpl(SportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sport> findAll() {
        return repository.findAll();
    }

    @Override
    public Sport save(Sport sport) {
        return repository.save(sport);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
