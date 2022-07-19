package ru.Moskin.Directory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Moskin.Directory.Model.RoleModel;

public interface RoleRepo extends JpaRepository<RoleModel, Long> {

    RoleModel getByName(String name);
}
