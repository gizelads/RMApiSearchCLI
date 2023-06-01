package rm.api.search.project.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ApiInfoResponse {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}