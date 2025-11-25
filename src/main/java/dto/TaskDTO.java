package dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    //@NotNull
    //private StatusEnum statusEnum;
    //@NotNull
    //private Priority priorityEnum;
    @NotNull
    private LocalDateTime dueDate;




}
