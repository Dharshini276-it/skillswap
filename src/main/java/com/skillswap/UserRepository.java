package com.skillswap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findBySkill(String skill);

    List<User> findByWantToLearn(String skill);

    List<User> findBySkillAndWantToLearn(String skill, String wantToLearn);

}
