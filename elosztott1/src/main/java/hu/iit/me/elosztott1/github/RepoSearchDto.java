package hu.iit.me.elosztott1.github;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RepoSearchDto {

    @NotNull
    @Size(min = 3)
    private String queryString;

}
