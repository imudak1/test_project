package com.example.demo.controller;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ResponseEntity<?> createProfile(@RequestBody ProfileDTO profileDTO){
        return ResponseEntity.ok(profileService.save(profileDTO));
    }

    @RequestMapping(value = "/profile/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> readProfileByEmail(@PathVariable(name = "email") String email){
        return profileService.loadProfileByEmail(email).isEmpty()
                ? ResponseEntity.badRequest().body("Users with email \"" + email + "\" not found")
                : ResponseEntity.ok(profileService.loadProfileByEmail(email));
    }

    @RequestMapping(value = "profile/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProfileById(@RequestBody ProfileDTO profileDTO){
        return profileService.update(profileDTO) != null ? ResponseEntity.ok("Data was updated.")
                : ResponseEntity.badRequest().body("User with id \"" + profileDTO.getId() + "\" not updated!");
    }

    @RequestMapping(value = "/profile/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(profileService.getAll());
    }

}
