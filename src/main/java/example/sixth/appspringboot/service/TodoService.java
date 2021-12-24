package example.sixth.appspringboot.service;

import example.sixth.appspringboot.entity.TodoEntity;
import example.sixth.appspringboot.entity.UserEntity;
import example.sixth.appspringboot.model.Todo;
import example.sixth.appspringboot.repository.TodoRepo;
import example.sixth.appspringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Autowired
    private UserRepo userRepo;

    public Todo create(TodoEntity todoEntity, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        todoEntity.setUserEntity(userEntity); // userEntity является владельцем todoEntity
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    public Todo complete(Long id) {
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.isCompleted()); // например, был false у todoEntity, а стало true
        return Todo.toModel(todoRepo.save(todoEntity));
    }
}
