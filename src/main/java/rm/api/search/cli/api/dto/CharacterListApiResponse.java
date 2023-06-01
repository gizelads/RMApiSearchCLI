package rm.api.search.cli.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class CharacterListApiResponse extends ApiInfoResponse {
    private List<CharacterApiResponse> results;
}