package example.sixth.appspringboot.controller;

import example.sixth.appspringboot.entity.UserEntity;
import example.sixth.appspringboot.exception.UserAlreadyExistExceprion;
import example.sixth.appspringboot.exception.UserNotFoundExceprion;
import example.sixth.appspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * декомпазиция логики - контроллер должен работать с запросами и ответам, никакой логики
 */
@RestController // для рест-сервера. @Controller - отправляет html файлы.
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * сохранить и получить из бд
     */
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }
        catch (UserAlreadyExistExceprion e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    /**
     * проверка: код работает
     * @return возвращает ответ
     */
    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        }
        catch (UserNotFoundExceprion e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
