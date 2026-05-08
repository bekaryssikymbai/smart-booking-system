package bekarys.group_project_manager.repository;

import bekarys.group_project_manager.entity.GroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {

    @Query("SELECT COUNT(m) FROM GroupMembership m WHERE m.group.id = :groupId AND m.status = 'CONFIRMED'")
    int countConfirmedMembers(@Param("groupId") Long groupId);
}