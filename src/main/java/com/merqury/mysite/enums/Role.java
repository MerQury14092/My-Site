package com.merqury.mysite.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority
{
    ROLE_USER(Set.of(Permission.POST_READ)),
    ROLE_ADMIN(Set.of(Permission.POST_READ, Permission.POST_REMOVE, Permission.POST_ADD));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    Role(Role other, Set<Permission> permissions){
        this(permissions);
        other.getPermissions().forEach(el -> this.getPermissions().add(el));

    }

    @Override
    public String getAuthority() {
        return name();
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
