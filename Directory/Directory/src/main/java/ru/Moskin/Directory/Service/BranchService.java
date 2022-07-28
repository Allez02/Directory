package ru.Moskin.Directory.Service;

import ru.Moskin.Directory.Model.BranchModel;

import java.util.List;

public interface BranchService {
    List<BranchModel> getAllBranch();

    BranchModel getByID(long id);

    void editeBranch(BranchModel branchModel, String city, String address, String name);

    void addBranch(String city, String address, String name);

    BranchModel getByName(String name);
}
