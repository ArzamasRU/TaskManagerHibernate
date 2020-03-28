package ru.lavrov.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IComparableEntity;
import ru.lavrov.tm.api.IEntity;
import ru.lavrov.tm.enumerate.Status;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "task")
public final class Task implements IEntity, IComparableEntity {

    @NotNull
    public static final String ID = "id";
    @NotNull
    public static final String USER_ID = "user_id";
    @NotNull
    public static final String PROJECT_ID = "project_id";
    @NotNull
    public static final String NAME = "name";
    @NotNull
    public static final String DESCRIPTION = "description";
    @NotNull
    public static final String START_DATE = "dateBegin";
    @NotNull
    public static final String FINISH_DATE = "dateEnd";

    @Nullable
    private String name;
    @Nullable
    private String id = UUID.randomUUID().toString();
    @Nullable
    private String description;
    @Nullable
    private Date startDate = new Date();
    @Nullable
    private Date finishDate = null;
    @Nullable
    private String userId;
    @Nullable
    private String projectId = null;
    @Nullable
    private Status status = Status.PLANNED;

    public Task(@Nullable final String name, @Nullable final String projectId, @Nullable final String userId) {
        this.name = name;
        this.projectId = projectId;
        this.userId = userId;
    }

    @Nullable
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description=" + description +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'';
    }
}
