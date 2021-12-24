package example.sixth.appspringboot.repository;

import example.sixth.appspringboot.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
