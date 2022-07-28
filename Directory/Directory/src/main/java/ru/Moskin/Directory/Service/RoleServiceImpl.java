package ru.Moskin.Directory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Moskin.Directory.Model.RoleModel;
import ru.Moskin.Directory.Repository.RoleRepo;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    public RoleServiceImpl(@Autowired RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<RoleModel> getAllRole() {
        return roleRepo.findAll();
    }

    @Override
    public RoleModel getByName(String name) {
        return roleRepo.getByName(name);
    }
}
