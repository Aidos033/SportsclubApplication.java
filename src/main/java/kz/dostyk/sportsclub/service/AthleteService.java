package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.Athlete;
import java.util.List;

public interface AthleteService {

    List<Athlete> getAllAthletes();

    Athlete getAthleteById(Long id);

    Athlete saveAthlete(Athlete athlete);

    void deleteAthlete(Long id);
}
