package ru.Moskin.Directory.Service;

import ru.Moskin.Directory.Model.PositionModel;

import java.util.List;

public interface PositionService {
    List<PositionModel> getAllPosition();

    PositionModel getByID(long id);

    void editePosition(PositionModel positionModel, String name, int salary);

    void addPosition(String name, int salary);

    PositionModel getByName(String name);
}
