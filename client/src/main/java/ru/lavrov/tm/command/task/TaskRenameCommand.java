package ru.lavrov.tm.command.task;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.TaskEndpointService;
import ru.lavrov.tm.util.InputUtil;

@NoArgsConstructor
public final class TaskRenameCommand extends AbstractCommand {
    private static final boolean SAFE = false;

    @NotNull
    private static final String COMMAND = "task-rename";
    @NotNull
    private static final String DESCRIPTION = "Rename task.";

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
        System.out.println("[task rename]");
        System.out.println("enter project name:");
        @Nullable final String projectName = InputUtil.INPUT.nextLine();
        System.out.println("enter task name:");
        @Nullable final String oldName = InputUtil.INPUT.nextLine();
        System.out.println("enter new task name:");
        @Nullable final String newName = InputUtil.INPUT.nextLine();
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final TaskEndpointService taskEndpointService = bootstrap.getTaskEndpointService();
        taskEndpointService.getTaskEndpointPort().renameTask(token, projectName, oldName, newName);
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
