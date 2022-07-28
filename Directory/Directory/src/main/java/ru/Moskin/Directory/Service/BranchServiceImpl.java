package ru.Moskin.Directory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Moskin.Directory.Model.BranchModel;
import ru.Moskin.Directory.Repository.BranchRepo;

import java.util.List;

@Service
public class BranchServiceImpl implements  BranchService{

    private final BranchRepo branchRepo;

    @Autowired
    public BranchServiceImpl(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public List<BranchModel> getAllBranch() {
        return branchRepo.findAll();
    }

    @Override
    public BranchModel getByID(long id) {
        return branchRepo.findById(id).orElseThrow();
    }

    @Override
    public void editeBranch(BranchModel branchModel, String city, String address, String name) {
        branchModel.setCity(city);
        branchModel.setName(name);
        branchModel.setAddress(address);
        branchRepo.save(branchModel);
    }

    @Override
    public void addBranch(String city, String address, String name) {
        BranchModel branchModel = new BranchModel(city, address, name);
        branchRepo.save(branchModel);
    }

    @Override
    public BranchModel getByName(String name) {
        return branchRepo.findBranchModelByName(name);
    }


}
