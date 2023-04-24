package org.zimin.otus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.Date;

@SpringBootApplication
public class OtusHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtusHomeworkApplication.class, args);
    }

}

@RestController
class OtusController {
    @GetMapping
    public String statusUp() {
        return "{\"Otus homework status\": \"UP\"}";
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void statusError() {
        throw new RuntimeException("Error simulated");
    }
}

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Schema(example = "johndoe589")
    private String username;
    @Schema(example = "John")
    private String firstName;
    @Schema(example = "Doe")
    private String lastName;
    @Schema(example = "bestjohn@doe.com")
    private String email;
    @Schema(example = "+71002003040")
    private String phone;
    private Date createdAt = new Date();

}

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
interface UserRepository extends JpaRepository<User, Long> {
}
