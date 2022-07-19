package ru.Moskin.Directory.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "worker")
@Data
public class WorkerModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String phone;

    private String VK;

    private String telegram;

    @ManyToOne
    @JoinColumn(name = "branch_model_id")
    private BranchModel branchModel;

    @ManyToOne
    @JoinColumn(name = "role_model_id")
    private RoleModel roleModel;

    @ManyToOne
    @JoinColumn(name = "position_model_id")
    private PositionModel positionModel;

    public WorkerModel() {

    }

    public WorkerModel(String username, String password, String name, String surname, String patronymic, BranchModel branchModel, PositionModel positionModel, RoleModel roleModel, String phone, String VK, String telegram) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.branchModel = branchModel;
        this.roleModel = roleModel;
        this.positionModel = positionModel;
        this.phone = phone;
        this.VK = VK;
        this.telegram = telegram;
    }

    public String getFIO() {
        return this.surname + " " + this.name + " " + this.patronymic;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(roleModel);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
