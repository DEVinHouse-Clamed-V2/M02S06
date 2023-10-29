package org.senai.devin.crudapi.controller;

import jakarta.validation.Valid;
import org.senai.devin.crudapi.exceptions.NotFoundException;
import org.senai.devin.crudapi.model.enums.StatusEnum;
import org.senai.devin.crudapi.model.transport.TaskDTO;
import org.senai.devin.crudapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Define que a classe será um controlador que intercepta requisições (Parecido com @WebServlet)
@RequestMapping("/task") // Define o path para onde as requisições serão mapeadas.
public class TaskController {

    private final TaskService taskService;


    // Injeta o serviço de tarefas via construtor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping // Mapeia requisições de tipo POST
    public ResponseEntity<TaskDTO> create(@Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO response = this.taskService.create(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping // Mapeia requisições de tipo GET
    public ResponseEntity<List<TaskDTO>> list(@RequestParam(name = "status", required = false) StatusEnum status, @RequestParam(name = "assignee", required = false) String name) {
        List<TaskDTO> response = this.taskService.listAll(status, name);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}") // Mapeia requisições de tipo PUT, recebendo o ID do recurso a ser alterado
    public ResponseEntity<TaskDTO> update(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) throws NotFoundException {
        TaskDTO response = this.taskService.update(id, taskDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}") // Mapeia requisições de tipo DELETE, recebendo o ID do recurso a ser removido
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}