package com.qtech.orderoengine.mapper;

import com.qtech.orderoengine.model.entity.AppUser;
import com.qtech.orderoengine.model.request.AppUserRequest;
import org.springframework.beans.BeanUtils;

public final class AppUserMapper {


    public static AppUserRequest toDto(AppUser appUser) {
        if (appUser != null) {
            AppUserRequest appUserRequest = new AppUserRequest();
            BeanUtils.copyProperties(appUser, appUserRequest);
            return appUserRequest;
        }
        return null;
    }

    public static AppUser fromDto(AppUserRequest appUserRequest) {
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserRequest, appUser);
        return appUser;
    }

}
