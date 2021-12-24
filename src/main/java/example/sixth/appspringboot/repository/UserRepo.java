package example.sixth.appspringboot.repository;

import example.sixth.appspringboot.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    // расширяем возможности
    UserEntity findByUsername(String username);
}
