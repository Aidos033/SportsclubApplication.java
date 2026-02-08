package kz.dostyk.sportsclub.repository;

import kz.dostyk.sportsclub.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
