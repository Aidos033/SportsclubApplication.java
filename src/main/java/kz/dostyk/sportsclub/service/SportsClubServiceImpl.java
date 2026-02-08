package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.SportsClub;
import kz.dostyk.sportsclub.repository.SportsClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsClubServiceImpl implements SportsClubService {

    private final SportsClubRepository repository;

    public SportsClubServiceImpl(SportsClubRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SportsClub> findAll() {
        return repository.findAll();
    }

    @Override
    public SportsClub save(SportsClub club) {
        return repository.save(club);
    }
}
