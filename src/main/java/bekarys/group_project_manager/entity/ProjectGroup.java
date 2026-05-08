package bekarys.group_project_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName;

    private String projectDescription;

    private String status;

    private LocalDateTime createdAt;

    private Integer maxMembers = 7;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Student captain;
}