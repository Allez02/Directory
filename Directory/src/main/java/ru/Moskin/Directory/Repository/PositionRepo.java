package ru.Moskin.Directory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Moskin.Directory.Model.PositionModel;

@Repository
public interface PositionRepo extends JpaRepository<PositionModel, Long> {
    PositionModel findPositionModelByName(String name);
}
