package ru.lavrov.tm.command.project;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.ProjectEndpointService;
import ru.lavrov.tm.util.InputUtil;

@NoArgsConstructor
public final class ProjectRenameCommand extends AbstractCommand {
    private static final boolean SAFE = false;
    @NotNull
    private static final String COMMAND = "project-rename";
    @NotNull
    private static final String DESCRIPTION = "Rename project.";

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
        System.out.println("[project remove]");
        System.out.println("enter name:");
        @Nullable final String oldName = InputUtil.INPUT.nextLine();
        System.out.println("enter new name:");
        @Nullable final String newName = InputUtil.INPUT.nextLine();
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final ProjectEndpointService projectEndpointService = bootstrap.getProjectEndpointService();
        projectEndpointService.getProjectEndpointPort().renameProject(token, oldName, newName);
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
