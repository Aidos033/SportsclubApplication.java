package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    // 🔐 ВОТ ЭТОГО НЕ ХВАТАЛО
    User register(String username, String password);
}
