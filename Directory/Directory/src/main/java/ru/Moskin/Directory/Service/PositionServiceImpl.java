package ru.Moskin.Directory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Moskin.Directory.Model.PositionModel;
import ru.Moskin.Directory.Repository.PositionRepo;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    private final PositionRepo positionRepo;

    @Autowired
    public PositionServiceImpl(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    @Override
    public List<PositionModel> getAllPosition() {
        return positionRepo.findAll();
    }

    @Override
    public PositionModel getByID(long id) {
        return positionRepo.findById(id).orElseThrow();
    }

    @Override
    public void editePosition(PositionModel positionModel, String name, int salary) {
        positionModel.setName(name);
        positionModel.setSalary(salary);
        positionRepo.save(positionModel);
    }

    @Override
    public void addPosition(String name, int salary) {
        PositionModel positionModel = new PositionModel(name, salary);
        positionRepo.save(positionModel);
    }

    @Override
    public PositionModel getByName(String name) {
        return positionRepo.findPositionModelByName(name);
    }
}
