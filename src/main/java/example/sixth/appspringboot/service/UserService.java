package example.sixth.appspringboot.service;

import example.sixth.appspringboot.exception.UserAlreadyExistExceprion;
import example.sixth.appspringboot.exception.UserNotFoundExceprion;
import example.sixth.appspringboot.entity.UserEntity;
import example.sixth.appspringboot.model.User;
import example.sixth.appspringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registration(UserEntity userEntity) throws UserAlreadyExistExceprion {
        if (userRepo.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistExceprion("Пользователь с таким именем уже существует");
        }
        return User.toModel(userRepo.save(userEntity));
    }

    public User getUser(Long id) throws UserNotFoundExceprion {
        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null) {
            throw new UserNotFoundExceprion("Пользователя с таким именем не существует");
        }
        return User.toModel(userEntity);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
