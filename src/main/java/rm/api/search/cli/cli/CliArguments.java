package rm.api.search.cli.cli;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import rm.api.search.cli.cli.validator.CliHelpValidator;
import rm.api.search.cli.cli.validator.CliKeywordValidator;

@Getter
@ToString
@NoArgsConstructor
public class CliArguments {

    @Parameter(
            required = true,
            validateWith = CliKeywordValidator.class,
            descriptionKey = "CHARACTER",
            description = "Filter by the given character name.")
    private String name;

    @Parameter(
            names = {"--status", "-s"},
            validateWith = CliKeywordValidator.class,
            description = "Filter by the given status (alive, dead or unknown)."
    )
    private String status;

    @Parameter(
            names = "--species",
            validateWith = CliKeywordValidator.class,
            description = "Filter by the given species."
    )
    private String species;

    @Parameter(
            names = "--type",
            validateWith = CliKeywordValidator.class,
            description = "Filter by the given type."
    )
    private String type;

    @Parameter(
            names = {"--gender", "-g"},
            validateWith = CliKeywordValidator.class,
            description = "Filter by the given gender (female, male, genderless or unknown)"
    )
    private String gender;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CliHelpValidator.class,
            description = "Display this help"
    )
    private boolean help;

    public static CliArguments newInstance() {
        return new CliArguments();
    }
}
