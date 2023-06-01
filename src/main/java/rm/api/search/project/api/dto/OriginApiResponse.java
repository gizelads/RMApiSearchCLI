package rm.api.search.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class OriginApiResponse {
    private String name;
    private String url;
}