package ru.Moskin.Directory.Service;

import ru.Moskin.Directory.Model.RoleModel;

import java.util.List;

public interface RoleService {

    List<RoleModel> getAllRole();

    RoleModel getByName(String name);
}
