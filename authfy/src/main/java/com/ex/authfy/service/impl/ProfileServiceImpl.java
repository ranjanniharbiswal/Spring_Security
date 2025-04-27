package com.ex.authfy.service.impl;

import com.ex.authfy.entity.UserEntity;
import com.ex.authfy.io.ProfileRequest;
import com.ex.authfy.io.ProfileResponse;
import com.ex.authfy.repo.UserRepo;
import com.ex.authfy.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        UserEntity newProfile = convertToUserEntity(profileRequest);
        if (!userRepo.existsByEmail(profileRequest.getEmail())) {
            newProfile = userRepo.save(newProfile);
            return convertToProfileResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .userId(newProfile.getUserId())
                .iAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest profileRequest) {
        return UserEntity.builder()
                .email(profileRequest.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(profileRequest.getName())
                .password(passwordEncoder.encode(profileRequest.getPassword()))
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }
}
