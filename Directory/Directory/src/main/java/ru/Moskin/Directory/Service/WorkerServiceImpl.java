package ru.Moskin.Directory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Moskin.Directory.Model.BranchModel;
import ru.Moskin.Directory.Model.PositionModel;
import ru.Moskin.Directory.Model.RoleModel;
import ru.Moskin.Directory.Model.WorkerModel;
import ru.Moskin.Directory.Repository.WorkerRepo;

import java.util.List;

@Service
public class WorkerServiceImpl implements UserDetailsService, WorkerService {

    private final WorkerRepo workerRepo;

    @Autowired
    public WorkerServiceImpl(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return workerRepo.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public List<WorkerModel> getAllWorker() {
        return workerRepo.findAll();
    }

    @Override
    public WorkerModel getByID(long id) {
        return workerRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(long id) {
        workerRepo.deleteById(id);
    }

    @Override
    public List<WorkerModel> getAllByBranchAndPosition(BranchModel branchModel, PositionModel positionModel) {
        return workerRepo.getAllByBranchModelAndPositionModel(branchModel, positionModel);
    }

    @Override
    public List<WorkerModel> getAllByBranchModel(BranchModel branchModel) {
        return workerRepo.getAllByBranchModel(branchModel);
    }

    @Override
    public List<WorkerModel> getAllByPositionModel(PositionModel positionModel) {
        return workerRepo.getAllByPositionModel(positionModel);
    }

    @Override
    public void workerAdd(String username, String password, String name, String surname, String patronymic, String vk, String phone, String telegram, BranchModel branchModel, PositionModel positionModel, RoleModel roleModel) {
        WorkerModel workerModel = new WorkerModel(username, password, name, surname, patronymic, branchModel, positionModel, roleModel, phone, vk, telegram);
        workerRepo.save(workerModel);
    }

    @Override
    public void workerEdite(String name, String surname, String patronymic, String vk, String phone, String telegram, BranchModel branchModel, PositionModel positionModel, RoleModel roleModel, WorkerModel workerModel) {
        workerModel.setName(name);
        workerModel.setSurname(surname);
        workerModel.setPatronymic(patronymic);
        workerModel.setBranchModel(branchModel);
        workerModel.setPositionModel(positionModel);
        workerModel.setRoleModel(roleModel);
        workerModel.setVK(vk);
        workerModel.setTelegram(telegram);
        workerRepo.save(workerModel);
    }

    @Override
    public boolean existByUsername(String username) {
        return workerRepo.existsByName(username);
    }

}
