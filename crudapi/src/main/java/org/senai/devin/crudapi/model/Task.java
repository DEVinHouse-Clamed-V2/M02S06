package org.senai.devin.crudapi.model;

import org.senai.devin.crudapi.model.enums.PriorityEnum;
import org.senai.devin.crudapi.model.enums.StatusEnum;
import org.senai.devin.crudapi.model.transport.TaskDTO;

import java.time.LocalDate;

// Classe que representa um objeto de persistência

public class Task {

    private Integer id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private StatusEnum status;
    private PriorityEnum priority;
    private Assignee assignee;

    public Task() {

    }

    public Task(TaskDTO taskDTO) {
        this.id = taskDTO.id();
        this.description = taskDTO.description();
        this.startDate = taskDTO.startDate();
        this.endDate = taskDTO.endDate();
        this.status = taskDTO.status();
        this.priority = taskDTO.priority();
        this.assignee = taskDTO.assignee();
    }

    public Task(Integer id, String description, LocalDate startDate, LocalDate endDate, StatusEnum status, PriorityEnum priority, Assignee assignee) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }
}
