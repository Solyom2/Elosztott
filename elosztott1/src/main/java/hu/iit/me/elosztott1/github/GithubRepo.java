package hu.iit.me.elosztott1.github;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubRepo implements Repo {

    private final String GithubRepoUrl = "https://api.github.com/search/repositories";

    private final RestTemplate restTemplate;

    @Override
    public List<String> searchByText(String queryString) {
        String url = GithubRepoUrl + "?q=" + queryString;
        ResponseEntity<GithubSearchResponseRoot> response = restTemplate.getForEntity(url, GithubSearchResponseRoot.class);
        return response.getBody().getItems().stream().map(item -> item.getName()).collect(Collectors.toList());
    }

}
