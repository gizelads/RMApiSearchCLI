package rm.api.search.cli.cli.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * A custom parameter validator that checks if the "help" flag is set.
 * This validator implements the IParameterValidator interface.
 */
public class CliHelpValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean(value);
        if(actualValue) {
            throw new ParameterException("Help asked");
        }
    }
}
