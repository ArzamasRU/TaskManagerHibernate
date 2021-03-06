package ru.lavrov.tm.command.general;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.Role;

import java.util.Collection;

@NoArgsConstructor
public final class ExitCommand extends AbstractCommand {
    private static final boolean SAFE = true;
    @NotNull
    private static final String COMMAND = "exit";
    @NotNull
    private static final String DESCRIPTION = "exit.";

    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute() {
        System.out.println("[You left this wonderful program]");
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
