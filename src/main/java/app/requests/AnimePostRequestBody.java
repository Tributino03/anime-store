package app.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class AnimePostRequestBody {
    @NotEmpty(message = "the anime name cannot be empty")
    private String name;
}
