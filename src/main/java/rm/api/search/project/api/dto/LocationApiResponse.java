package rm.api.search.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class LocationApiResponse {
    private String name;
    private String url;
}