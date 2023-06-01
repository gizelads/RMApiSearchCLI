package rm.api.search.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class CharacterListApiResponse {
    private ApiInfoResponse info;
    private List<CharacterApiResponse> results;
}