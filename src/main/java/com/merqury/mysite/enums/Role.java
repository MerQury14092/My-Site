package com.merqury.mysite.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority
{
    ROLE_USER, ROLE_ADMIN, ROLE_MODER;

    @Override
    public String getAuthority() {
        return name();
    }
}
