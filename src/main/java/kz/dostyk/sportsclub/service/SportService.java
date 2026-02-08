package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.Sport;
import java.util.List;

public interface SportService {

    List<Sport> findAll();
    Sport save(Sport sport);
    void delete(Long id);
}
