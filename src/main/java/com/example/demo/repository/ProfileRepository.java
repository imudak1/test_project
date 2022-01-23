package com.example.demo.repository;

import com.example.demo.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

    Optional<Profile> findById(Long id);
}
