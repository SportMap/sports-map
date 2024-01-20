package pl.edu.pja.sportsmap.persistence.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }
}
