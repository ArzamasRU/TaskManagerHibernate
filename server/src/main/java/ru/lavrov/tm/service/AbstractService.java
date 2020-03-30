package ru.lavrov.tm.service;

import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IService;
import ru.lavrov.tm.util.ConnectionUtil;

import java.sql.Connection;

public abstract class AbstractService implements IService {

    @Nullable
    public Connection getConnection() {
        return ConnectionUtil.getConnection();
    }
}
