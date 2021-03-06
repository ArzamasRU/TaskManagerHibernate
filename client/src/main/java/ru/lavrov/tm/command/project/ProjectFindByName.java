package ru.lavrov.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.Project;
import ru.lavrov.tm.endpoint.ProjectDTO;
import ru.lavrov.tm.endpoint.ProjectEndpointService;
import ru.lavrov.tm.util.InputUtil;

import java.util.Collection;

public final class ProjectFindByName extends AbstractCommand {
    private static final boolean SAFE = false;

    @NotNull
    private static final String COMMAND = "project-find-by-name";
    @NotNull
    private static final String DESCRIPTION = "Show project by name.";

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
        System.out.println("[PROJECT LIST]");
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final ProjectEndpointService projectEndpointService = bootstrap.getProjectEndpointService();
        System.out.println("enter name:");
        @Nullable final String name = InputUtil.INPUT.nextLine();
        @Nullable final Collection<ProjectDTO> projectList =
                projectEndpointService.getProjectEndpointPort().findAllByNamePart(token, name);
        if (projectList == null)
            return;
        int index = 1;
        for (@Nullable final ProjectDTO project : projectList) {
            if (project == null)
                continue;
            System.out.println(index++ + ". " + project);
        }
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
