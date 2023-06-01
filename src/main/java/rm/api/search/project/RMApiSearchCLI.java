package rm.api.search.project;

import com.beust.jcommander.JCommander;
import rm.api.search.project.api.ApiRMFeignClient;
import rm.api.search.project.api.dto.CharacterApiResponse;
import rm.api.search.project.api.dto.CharacterListApiResponse;
import rm.api.search.project.cli.CliArguments;
import rm.api.search.project.cli.CliFunctions;

import java.util.*;
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
                .forEach(RMApiSearchCLI::printResponse);
    }

    private static Stream<CharacterListApiResponse> executeRequest(Map<String, Object> options) {
        ApiRMFeignClient apiRMFeignClient = buildApi(ApiRMFeignClient.class, "https://rickandmortyapi.com");

        return Stream.of(options)
                .map(apiRMFeignClient::filterCharacters);
    }

    private static void printResponse(CharacterListApiResponse characterListApiResponse) {
        List<CharacterApiResponse> characterApiResponses = characterListApiResponse.getResults();

        System.out.println("INFO: " +
                "count " + characterListApiResponse.getInfo().getCount() + ", " +
                "pages " + characterListApiResponse.getInfo().getPages() + "." + "\n");

        System.out.println("RESULTS: ");
        for (CharacterApiResponse character : characterApiResponses) {
            System.out.println("Id: " + character.getId());
            System.out.println("Name: " + character.getName());
            System.out.println("Status: " + character.getStatus());
            System.out.println("Species: " + character.getSpecies());
            System.out.println("Type: " + character.getType());
            System.out.println("Gender: " + character.getGender());
            System.out.println("Origin: " + character.getOrigin().getName());
            System.out.println("Location: " + character.getLocation().getName());
            System.out.println("Image: " + character.getImage());
            System.out.println("Episode: " + character.getEpisode());
            System.out.println("Url: " + character.getUrl());
            System.out.println("Created: " + character.getCreated() + "\n");
        }
    }
}
