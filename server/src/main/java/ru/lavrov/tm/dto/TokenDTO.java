package ru.lavrov.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.entity.Session;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public final class TokenDTO {

    @NotNull
    protected String id = UUID.randomUUID().toString();
    @Nullable
    private Session session;
    @Nullable
    private String sign;
}