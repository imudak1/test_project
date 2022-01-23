package com.example.demo.service.impl;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;
import com.example.demo.util.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public List<ProfileDTO> loadProfileByEmail(String email) {
        List<Profile> profiles = getAll();
        List<ProfileDTO> _profiles = new ArrayList<>();
        profiles.stream().filter(profile -> profile.getEmail().equals(email))
                .forEach(profile -> _profiles.add(convert(profile)));
        return _profiles;
    }

    @Override
    public Profile save(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setFirstName(profileDTO.getFirstName());
        profile.setSecondName(profileDTO.getSecondName());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        profileRepository.save(profile);
        return profile;
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile update(ProfileDTO profileDTO) {
        if (profileRepository.findById(profileDTO.getId()).isPresent()){
            Profile profile = profileRepository.findById(profileDTO.getId()).get();
            profileMapper.updateCustomerFromDto(profileDTO, profile);
            profileRepository.save(profile);
            return profile;
        }
        return null;
    }

    public ProfileDTO convert(Profile profile){
        return new ProfileDTO(profile.getId(), profile.getFirstName(), profile.getSecondName(), profile.getEmail(),
                profile.getPhoneNumber(), profile.getAddress());
    }
}
