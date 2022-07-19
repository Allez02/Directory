package ru.Moskin.Directory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Moskin.Directory.Model.BranchModel;

@Repository
public interface BranchRepo extends JpaRepository<BranchModel, Long> {
    BranchModel findBranchModelByName(String name);
}
