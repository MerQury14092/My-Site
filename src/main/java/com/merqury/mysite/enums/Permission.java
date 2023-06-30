package com.merqury.mysite.enums;

public enum Permission {
    POST_ADD("post:add"),
    POST_REMOVE("post:rm"),
    POST_READ("post:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
