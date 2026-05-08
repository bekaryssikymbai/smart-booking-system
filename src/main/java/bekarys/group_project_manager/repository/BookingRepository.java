package bekarys.group_project_manager.repository;



import bekarys.group_project_manager.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}