package ru.Moskin.Directory.Service;

import ru.Moskin.Directory.Model.BranchModel;
import ru.Moskin.Directory.Model.PositionModel;
import ru.Moskin.Directory.Model.RoleModel;
import ru.Moskin.Directory.Model.WorkerModel;

import java.util.List;

public interface WorkerService {
    List<WorkerModel> getAllWorker();

    WorkerModel getByID(long id);

    void deleteById(long id);

    List<WorkerModel> getAllByBranchAndPosition(BranchModel branchModel, PositionModel positionModel);

    List<WorkerModel> getAllByBranchModel(BranchModel branchModel);

    List<WorkerModel> getAllByPositionModel(PositionModel positionModel);

    void workerAdd(String username, String password, String name, String surname, String patronymic, String vk, String phone, String telegram, BranchModel branchModel, PositionModel positionModel, RoleModel roleModel);

    void workerEdite(String name, String surname, String patronymic, String vk, String phone, String telegram, BranchModel branchModel, PositionModel positionModel, RoleModel roleModel, WorkerModel workerModel);

    boolean existByUsername(String username);
}
