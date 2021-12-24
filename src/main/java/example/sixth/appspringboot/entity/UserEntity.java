package example.sixth.appspringboot.entity;

import javax.persistence.*;
import java.util.List;

/**
 * сущности, которые взаимодействуют с бд, и объекты, с которыми происходит обмен с клиентом
 * это разные классы
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    /**
     * один пользователь может иметь список задач
     * отношение - один ко многим
     * CascadeType.AL - если удаляется пользователь из бд,
     * то удаляются и задачи, которые были прикреплены к этому пользователю
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<TodoEntity> todos;

    public UserEntity() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }
}




