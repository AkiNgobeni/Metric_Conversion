package ayoholdings.com.metricconversion.api.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type DistanceResponse.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
@Getter
@Setter
public class CurrencyResponse {

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String from;

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String to;

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private BigDecimal Value;

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String resultMessage;
}
