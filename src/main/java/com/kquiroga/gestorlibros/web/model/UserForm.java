package com.kquiroga.gestorlibros.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.kquiroga.gestorlibros.web.validation.ConfirmacionPassword;

@ConfirmacionPassword
public class UserForm {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String confirmacionPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirmacionPassword() {
        return confirmacionPassword;
    }

    public void setConfirmacionPassword(final String confirmacionPassword) {
        this.confirmacionPassword = confirmacionPassword;
    }
}
