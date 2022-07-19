package ru.Moskin.Directory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.Moskin.Directory.Service.BranchService;
import ru.Moskin.Directory.Service.PositionService;
import ru.Moskin.Directory.Service.WorkerService;

@Controller
public class DirectoryController {

    private WorkerService workerService;

    private BranchService branchService;

    private PositionService positionService;

    public DirectoryController(@Autowired WorkerService workerService, @Autowired BranchService branchService, @Autowired PositionService positionService) {
        this.workerService = workerService;
        this.branchService = branchService;
        this.positionService = positionService;
    }

    @GetMapping("/directory")
    public String Worker(Model model) {
        model.addAttribute("worker", workerService.getAllWorker()).addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition());
        return "worker";
    }

    @PostMapping("/directory")
    public String WorkerFilter(Model model, @RequestParam String branch, @RequestParam String position){
        if (branch == "" && position == "") {
            return "redirect:/directory";
        }
        else if (branch == "") {
            model.addAttribute("worker", workerService.getAllByPositionModel(positionService.getByName(position))).addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition());
            return "worker";
        }
        else if (position == "") {
            model.addAttribute("worker", workerService.getAllByBranchModel(branchService.getByName(branch))).addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition());
            return "worker";
        }
        else {
            model.addAttribute("worker", workerService.getAllByBranchAndPosition(branchService.getByName(branch), positionService.getByName(position))).addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition());
            return "worker";
        }

    }
}
