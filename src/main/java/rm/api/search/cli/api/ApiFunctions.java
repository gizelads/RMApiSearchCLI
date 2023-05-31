package rm.api.search.cli.api;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * The {@code ApiFunctions} interface provides a static method for building API instances using Feign.
 */
public interface ApiFunctions {
    /**
     * Builds an instance of the API using the specified class and base URL.
     *
     * @param api the interface class representing the API.
     * @param url the base URL of the API.
     * @param <T> the type of the API interface.
     * @return an instance of the API.
     */
    static <T> T buildApi(Class<T> api, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(api, url);
    }
}
