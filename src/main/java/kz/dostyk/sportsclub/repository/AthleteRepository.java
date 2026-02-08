package kz.dostyk.sportsclub.repository;

import kz.dostyk.sportsclub.entity.Athlete;
import kz.dostyk.sportsclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    Optional<Athlete> findByUser(User user);
}
