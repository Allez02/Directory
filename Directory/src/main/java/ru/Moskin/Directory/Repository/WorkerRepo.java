package ru.Moskin.Directory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Moskin.Directory.Model.BranchModel;
import ru.Moskin.Directory.Model.PositionModel;
import ru.Moskin.Directory.Model.WorkerModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerModel, Long> {

    Optional<WorkerModel> getByUsername(String username);
    List<WorkerModel> getAllByBranchModelAndPositionModel(BranchModel branchModel, PositionModel positionModel);

    List<WorkerModel> getAllByBranchModel(BranchModel branchModel);

    List<WorkerModel> getAllByPositionModel(PositionModel positionModel);

    boolean existsByName(String name);
}
