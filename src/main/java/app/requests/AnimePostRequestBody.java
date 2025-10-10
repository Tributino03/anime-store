package app.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class AnimePostRequestBody {
    @NotEmpty(message = "the anime name cannot be empty")
    @Schema(description = "This is the Anime's name", example = "Tensei Shittara Slime Datta Ken", required = true)
    private String name;
}
