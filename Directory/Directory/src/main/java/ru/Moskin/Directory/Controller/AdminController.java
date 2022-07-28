package ru.Moskin.Directory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.Moskin.Directory.Service.BranchService;
import ru.Moskin.Directory.Service.PositionService;
import ru.Moskin.Directory.Service.RoleService;
import ru.Moskin.Directory.Service.WorkerService;

@Controller
public class AdminController {

    private final WorkerService workerService;

    private final BranchService branchService;

    private final PositionService positionService;

    private final RoleService roleService;

    @Autowired
    public AdminController(WorkerService workerService, BranchService branchService, PositionService positionService, RoleService roleService) {
        this.workerService = workerService;
        this.branchService = branchService;
        this.positionService = positionService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/worker")
    public String adminWorker(Model model) {
        model.addAttribute("worker", workerService.getAllWorker());
        return "admin-worker";
    }

    @GetMapping("/admin/position")
    public String adminPosition(Model model) {
        model.addAttribute("position", positionService.getAllPosition());
        return "admin-position";
    }

    @GetMapping("/admin/branch")
    public String adminBranch(Model model) {
        model.addAttribute("branch", branchService.getAllBranch());
        return "admin-branch";
    }

    @GetMapping("/admin/worker/{id}/delete")
    public String adminWorkerDelete( @PathVariable(value = "id") long id) {
        workerService.deleteById(id);
        return "redirect:/admin/worker";
    }

    @GetMapping("/admin/worker/{id}/edit")
    public String workerEdite(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("worker", workerService.getByID(id)).addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition()).addAttribute("role", roleService.getAllRole());
        return "worker-edit";
    }

    @PostMapping("/admin/worker/{id}/edit")
    public String workerEditePost( @RequestParam String name, @RequestParam String surname, @RequestParam String patronymic, @RequestParam String vk, @RequestParam String phone, @RequestParam String telegram, @RequestParam String role, @RequestParam String position, @RequestParam String branch, @PathVariable(value = "id") Long id) {
        workerService.workerEdite(name, surname, patronymic, vk, phone, telegram, branchService.getByName(branch), positionService.getByName(position), roleService.getByName(role), workerService.getByID(id));
        return "redirect:/admin/worker";
    }

    @GetMapping("admin/worker/add")
    public String workerAdd(Model model) {
        model.addAttribute("branch", branchService.getAllBranch()).addAttribute("position", positionService.getAllPosition()).addAttribute("role", roleService.getAllRole());
        return "worker-add";
    }

    @PostMapping("admin/worker/add")
    public String workerAddPost(@RequestParam String name, @RequestParam String surname, @RequestParam String patronymic, @RequestParam String vk, @RequestParam String phone, @RequestParam String telegram, @RequestParam String role, @RequestParam String position, @RequestParam String branch, @RequestParam String username, @RequestParam String password) {
        if (!workerService.existByUsername(username)) {
            workerService.workerAdd(username, password, name, surname, patronymic, vk, phone, telegram, branchService.getByName(branch), positionService.getByName(position), roleService.getByName(role));
        }
        return "redirect:/admin/worker";
    }

    @GetMapping("/admin/position/add")
    public  String positionAdd() {
        return "position-add";
    }

    @PostMapping("/admin/position/add")
    public String positionAddPost( @RequestParam String name, @RequestParam int salary) {
        positionService.addPosition(name, salary);
        return "redirect:/admin/position";
    }

    @GetMapping("/admin/position/{id}/edit")
    public  String positionEdit(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("position", positionService.getByID(id));
        return "position-edit";
    }

    @PostMapping("/admin/position/{id}/edit")
    public String positionEditPost( @RequestParam String name, @RequestParam int salary, @PathVariable(value = "id") Long id) {
        positionService.editePosition(positionService.getByID(id), name, salary);
        return "redirect:/admin/position";
    }

    @GetMapping("/admin/branch/add")
    public  String branchAdd() {
        return "branch-add";
    }

    @PostMapping("/admin/branch/add")
    public  String branchAddPost(@RequestParam String name, @RequestParam String city, @RequestParam String address) {
        branchService.addBranch(city, address, name);
        return "redirect:/admin/branch";
    }

    @GetMapping("/admin/branch/{id}/edit")
    public  String branchEdit(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("branch", branchService.getByID(id));
        return "branch-edit";
    }

    @PostMapping("/admin/branch/{id}/edit")
    public  String branchEditPost(@RequestParam String name, @RequestParam String city, @RequestParam String address, @PathVariable(value = "id") Long id) {
        branchService.editeBranch(branchService.getByID(id), city, address, name);
        return "redirect:/admin/branch";
    }
}
