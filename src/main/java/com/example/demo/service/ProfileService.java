package com.example.demo.service;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.Profile;

import java.util.List;

public interface ProfileService {

    List<ProfileDTO> loadProfileByEmail(String email);
    Profile save(ProfileDTO profileDTO);
    List<Profile> getAll();
    Profile update(ProfileDTO profileDTO);
}
