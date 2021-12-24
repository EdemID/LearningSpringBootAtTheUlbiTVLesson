package example.sixth.appspringboot.model;


import example.sixth.appspringboot.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * модели отвечают за обмен данными между клиентом и сервером
 */
public class User {
    /**
     * указываем те поля, которые будут использоваться на клиенте
     */
    private Long id;
    private String username;
    private List<Todo> todos;

    public User() {
    }

    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());
        /**
         * map выполняет метод переданный параметром для каждого элемента массива
         */
        model.setTodos(userEntity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
