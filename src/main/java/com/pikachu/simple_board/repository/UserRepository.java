package com.pikachu.simple_board.repository;

import com.pikachu.simple_board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    //반드시 User 값이 나오는게 아니기 때문에 Optional (ex. 아이디를 틀리는 경우)
}
