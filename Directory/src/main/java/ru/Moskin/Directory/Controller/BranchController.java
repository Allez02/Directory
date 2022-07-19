package ru.Moskin.Directory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.Moskin.Directory.Service.BranchService;

@Controller
public class BranchController {
    private BranchService branchService;

    public BranchController(@Autowired BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/branch")
    public String home(Model model) {
        model.addAttribute("branch", branchService.getAllBranch());
        return "branch";
    }
}
