package rm.api.search.project.cli.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Validates a command-line keyword parameter to ensure it only contains letters (both uppercase and lowercase).
 * Implements the IParameterValidator interface.
 */
public class CliKeywordValidator implements IParameterValidator {
    /**
     * Validates the keyword parameter to ensure it only contains letters (both uppercase and lowercase).
     *
     * @param name     the name of the parameter being validated
     * @param value    the value of the parameter being validated
     * @throws ParameterException if the keyword parameter contains any character other than letters.
     */
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z]+$")) {
            System.err.println("Keyword: " + value + "is invalid, only letters allowed.\n");
            throw new ParameterException("Only letters are supported");
        }
    }
}
