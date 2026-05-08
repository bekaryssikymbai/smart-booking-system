package bekarys.group_project_manager.repository;


import bekarys.group_project_manager.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}