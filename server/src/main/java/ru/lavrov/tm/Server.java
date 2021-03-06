package ru.lavrov.tm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.bootstrap.Bootstrap;

public final class Server {
    public static void main(@Nullable String[] args) throws IllegalAccessException, InstantiationException {
        @NotNull final Bootstrap serviceLocator = new Bootstrap();
        serviceLocator.init();
    }
}