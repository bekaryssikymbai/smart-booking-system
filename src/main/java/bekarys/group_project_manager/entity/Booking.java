package bekarys.group_project_manager.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;

    private String accessCode;

    private LocalDateTime checkInDeadline;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ProjectGroup group;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}