package com.qtech.orderoengine.model.request;

import com.qtech.orderoengine.model.AppUserRole;
import com.sun.istack.NotNull;

public class AppUserRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private AppUserRole appUserRole;

    public AppUserRequest() {
    }

    public AppUserRequest(String username, String password, AppUserRole appUserRole) {
        this.username = username;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }
}