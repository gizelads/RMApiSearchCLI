package rm.api.search.project;

import com.beust.jcommander.JCommander;
import rm.api.search.project.api.ApiRMFeignClient;
import rm.api.search.project.api.dto.CharacterListApiResponse;
import rm.api.search.project.cli.CliArguments;
import rm.api.search.project.cli.CliFunctions;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static rm.api.search.project.CommanderFunctions.buildCommanderWithName;
import static rm.api.search.project.CommanderFunctions.parseArguments;
import static rm.api.search.project.api.ApiFunctions.buildApi;

public class RMApiSearchCLI {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("rm-api-search-cli", CliArguments::newInstance);

        Stream<CliArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CliArguments) obj);

        Optional<CliArguments> cliOptional = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .findFirst();

        cliOptional.map(CliFunctions::toMap)
                .map(RMApiSearchCLI::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<CharacterListApiResponse> executeRequest(Map<String, Object> options) {
        ApiRMFeignClient apiRMFeignClient = buildApi(ApiRMFeignClient.class, "https://rickandmortyapi.com");

        return Stream.of(options)
                .map(apiRMFeignClient::filterCharacters);
    }
}
