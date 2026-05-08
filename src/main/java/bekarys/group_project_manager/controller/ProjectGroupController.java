package bekarys.group_project_manager.controller;



import bekarys.group_project_manager.entity.ProjectGroup;
import bekarys.group_project_manager.service.ProjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class ProjectGroupController {

    @Autowired
    private ProjectGroupService groupService;

    @GetMapping
    public List<ProjectGroup> getAll() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public ProjectGroup getOne(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping
    public ProjectGroup create(@RequestBody ProjectGroup group) {
        return groupService.createGroup(group);
    }

    @PutMapping("/{id}")
    public ProjectGroup update(@PathVariable Long id, @RequestBody ProjectGroup group) {
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}