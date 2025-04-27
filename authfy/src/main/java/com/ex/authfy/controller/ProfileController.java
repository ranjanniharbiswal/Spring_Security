package com.ex.authfy.controller;

import com.ex.authfy.io.ProfileRequest;
import com.ex.authfy.io.ProfileResponse;
import com.ex.authfy.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/v1.0")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping ("/register")
    @ResponseStatus (HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request) {
        ProfileResponse profileResponse = profileService.createProfile(request);
        //TODO: Send a welcome Email
        return profileResponse;
    }
}
