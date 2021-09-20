package hu.iit.me.elosztott1.github;

import lombok.Data;

import java.util.List;

@Data
public class GithubSearchResponseRoot {

    private int total_count;
    private boolean complete_results;
    private List<GithubItemDto> items;

}
