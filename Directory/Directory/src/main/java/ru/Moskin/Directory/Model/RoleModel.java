package ru.Moskin.Directory.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public RoleModel() {

    }

    public RoleModel(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
