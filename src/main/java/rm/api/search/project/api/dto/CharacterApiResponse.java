package rm.api.search.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class CharacterApiResponse {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginApiResponse origin;
    private LocationApiResponse location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}