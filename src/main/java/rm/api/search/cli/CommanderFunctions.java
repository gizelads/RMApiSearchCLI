package rm.api.search.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * The {@code CommanderFunctions} interface provides static methods for building JCommander instances.
 */
public interface CommanderFunctions {
    /**
     * Builds a JCommander instance with the specified name and argument supplier.
     *
     * @param cliName            the name of the command-line interface
     * @param argumentSupplier   a supplier providing the arguments for the command-line interface
     * @param <T>                the type of the argument object
     * @return a {@link JCommander} instance configured with the specified name and arguments.
     */
    static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
        JCommander jCommander = buildCommander(argumentSupplier.get());
        jCommander.setProgramName(cliName);
        return jCommander;
    }

    /**
     * Builds a JCommander instance for the specified object.
     *
     * @param object     the object containing the command-line options
     * @return a {@link JCommander} instance.
     */
    static JCommander buildCommander(Object object) {
        return JCommander
                .newBuilder()
                .addObject(object)
                .build();
    }

    /**
     * Parses the cli arguments using the provided JCommander instance.
     *
     * @param jCommander        the JCommander instance for parsing arguments
     * @param arguments         the command-line arguments to be parsed
     * @param onCommandError    the error handler for handling parameter exceptions
     * @return An Optional containing a list of parsed objects if parsing succeeds, or an empty Optional if an error occurs.
     */
    static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, OnCommandError onCommandError) {
        try {
            jCommander.parse(arguments);

            return Optional.of(jCommander.getObjects());
        } catch (ParameterException e) {
            onCommandError.onError(jCommander);
        }

        return Optional.empty();
    }

    /**
     * Functional interface for handling command errors.
     */
    @FunctionalInterface
    interface OnCommandError {
        void onError(JCommander jCommander);
    }
}
