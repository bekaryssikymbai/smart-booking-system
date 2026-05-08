package bekarys.group_project_manager.repository;



import bekarys.group_project_manager.entity.ProjectGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectGroupRepository extends JpaRepository<ProjectGroup, Long> {
}