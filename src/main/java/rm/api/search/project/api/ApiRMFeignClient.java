package rm.api.search.project.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import rm.api.search.project.api.dto.CharacterListApiResponse;

import java.util.Map;

@Headers("Accept: application/json")
public interface ApiRMFeignClient {
    @RequestLine("GET /api/character")
    CharacterListApiResponse filterCharacters(@QueryMap Map<String, Object> queryMap);
}
