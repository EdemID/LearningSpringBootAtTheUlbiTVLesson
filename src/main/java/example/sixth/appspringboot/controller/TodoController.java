package example.sixth.appspringboot.controller;

import example.sixth.appspringboot.entity.TodoEntity;
import example.sixth.appspringboot.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.create(todoEntity, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошбика");
        }
    }

    /**
     * при отправке запроса с айди задачи, если задача была выполнена, то
     * становится невыполненной, а если невыполнена - выполненной
     * имитация чекбокса
     * @return
     */
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошбика");
        }
    }
}
