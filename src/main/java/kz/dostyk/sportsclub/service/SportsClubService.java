package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.SportsClub;
import java.util.List;

public interface SportsClubService {

    List<SportsClub> findAll();
    SportsClub save(SportsClub club);
}
