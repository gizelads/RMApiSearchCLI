package rm.api.search.cli.cli;

import java.util.HashMap;
import java.util.Map;

public interface CliFunctions {
    static Map<String, Object> toMap(CliArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", cliArguments.getName());
        params.put("status", cliArguments.getStatus());
        params.put("species", cliArguments.getSpecies());
        params.put("type", cliArguments.getType());
        params.put("gender", cliArguments.getGender());

        return params;
    }
}
