package com.ex.authfy.service;

import com.ex.authfy.io.ProfileRequest;
import com.ex.authfy.io.ProfileResponse;

public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest profileRequest);
}
