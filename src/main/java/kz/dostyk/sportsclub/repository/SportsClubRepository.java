package kz.dostyk.sportsclub.repository;

import kz.dostyk.sportsclub.entity.SportsClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsClubRepository extends JpaRepository<SportsClub, Long> {
}
