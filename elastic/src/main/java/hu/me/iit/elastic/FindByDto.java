package hu.me.iit.elastic;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindByDto {

    @NotBlank
    private String query;

}
