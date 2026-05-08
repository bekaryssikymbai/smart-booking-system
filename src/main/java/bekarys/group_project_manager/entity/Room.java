package bekarys.group_project_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String roomNumber;

    private Integer capacity = 7;

    private Boolean hasProjector = false;

    private Boolean hasWhiteboard = false;

    private Boolean isActive = true;
}