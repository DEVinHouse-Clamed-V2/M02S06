package org.senai.devin.crudapi.model.transport;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.senai.devin.crudapi.model.Assignee;
import org.senai.devin.crudapi.model.Task;
import org.senai.devin.crudapi.model.enums.PriorityEnum;
import org.senai.devin.crudapi.model.enums.StatusEnum;

import java.time.LocalDate;

// Objeto que transporta a tarefa, além de conter as anotações de validação do objeto
public record TaskDTO(@NotNull Integer id, @NotBlank String description,
                      LocalDate startDate, LocalDate endDate,
                      @NotNull StatusEnum status, @NotNull PriorityEnum priority,
                      @Valid @NotNull Assignee assignee) {

    public TaskDTO(Task task) {
        this(task.getId(), task.getDescription(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getPriority(), task.getAssignee());
    }
}
