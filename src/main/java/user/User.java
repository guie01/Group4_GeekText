package user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    public User(Integer id, String username, String password, String name, String email, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User(String username, String password, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User() {
    }
}