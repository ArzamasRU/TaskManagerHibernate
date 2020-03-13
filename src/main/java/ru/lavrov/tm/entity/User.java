package ru.lavrov.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IEntity;
import ru.lavrov.tm.enumerate.Role;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name = "user")
public final class User implements IEntity {
    @Nullable
    private String id = UUID.randomUUID().toString();
    @Nullable
    private String login;
    @Nullable
    private String password;
    @Nullable
    private Role role;

    public User(@Nullable final String login, @Nullable final String password, @Nullable final Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @JsonIgnore
    @Nullable
    @Override
    public String getUserId() {
        return getId();
//        return null;
    }

    @JsonIgnore
    @Override
    public void setUserId(final String id) {
        setId(id);
    }

    @JsonIgnore
    @Nullable
    @Override
    public String getName() {
        return getLogin();
//        return null;
    }

    @JsonIgnore
    @Override
    public void setName(final String login) {
        setLogin(login);
    }

    @Nullable
    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", role=" + role;
    }
}
