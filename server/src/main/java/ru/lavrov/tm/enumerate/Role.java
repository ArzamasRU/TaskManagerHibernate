package ru.lavrov.tm.enumerate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Role {
    ADMIN("admin"),
    USER("user");

    @NotNull
    private final String role;

    Role(final String role) {
        this.role = role;
    }

    @NotNull
    public String getRole() {
        return role;
    }

    @NotNull
    public String displayName() {
        return name();
    }

    @Nullable
    public static Role getByRole(@NotNull final String role) {
        if (role == null || role.isEmpty())
            return null;
        Role[] list = Role.values();
        for (@Nullable final Role currentRole: list) {
            if (role.equals(currentRole.getRole()))
                return currentRole;
        }
        try {
            return Role.valueOf(role);
        } catch(IllegalArgumentException e) {
            return null;
        }
    }
}
