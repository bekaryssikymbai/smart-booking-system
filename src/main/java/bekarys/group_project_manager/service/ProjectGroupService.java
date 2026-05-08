package bekarys.group_project_manager.service;



import bekarys.group_project_manager.entity.ProjectGroup;
import bekarys.group_project_manager.repository.ProjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectGroupService {

    @Autowired
    private ProjectGroupRepository groupRepository;

    public List<ProjectGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    public ProjectGroup getGroup(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public ProjectGroup createGroup(ProjectGroup group) {
        return groupRepository.save(group);
    }

    public ProjectGroup updateGroup(Long id, ProjectGroup group) {
        group.setId(id);
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}