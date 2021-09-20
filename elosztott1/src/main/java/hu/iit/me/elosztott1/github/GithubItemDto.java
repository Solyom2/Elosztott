package hu.iit.me.elosztott1.github;

import lombok.Data;

import java.util.List;

@Data
public class GithubItemDto {

    private String name;
    private String path;
    private String url;
    private List<GithubRepoDto> githubRepoDtos;

}
