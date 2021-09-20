package hu.iit.me.elosztott1;

import hu.iit.me.elosztott1.github.GithubItemDto;
import hu.iit.me.elosztott1.github.GithubRepo;
import hu.iit.me.elosztott1.github.GithubSearchResponseRoot;
import hu.iit.me.elosztott1.github.RestCommunicationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.fail;

public class GithubRepoTest {

    private final String GithubRepoUrl = "https://api.github.com/search/repositories";

    @Test
    void test() {
        //GIVEN
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        GithubRepo repo = new GithubRepo(restTemplate);
        String testQuery = "ize";
        GithubItemDto item = new GithubItemDto();
        item.setName("demo");
        List<GithubItemDto> items = new ArrayList<>();
        items.add(item);
        GithubSearchResponseRoot mockRoot = new GithubSearchResponseRoot();
        mockRoot.setItems(items);

        ResponseEntity<GithubSearchResponseRoot> response;
        Mockito.when(restTemplate.getForEntity(GithubRepoUrl + "?q=" + testQuery, GithubSearchResponseRoot.class)).thenReturn(new ResponseEntity(mockRoot, HttpStatus.OK));

        //WHEN
        List<String> result = repo.searchByText(testQuery);
        assertThat(result, hasSize(1));
        assertThat(result.get(0), is("demo"));

        //THEN
        Mockito.verify(restTemplate).getForEntity(GithubRepoUrl + "?q=" + testQuery, GithubSearchResponseRoot.class);
    }

    @Test
    void testSearchError404() {
        //GIVEN
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        GithubRepo repo = new GithubRepo(restTemplate);
        String testQuery = "ize";

        Mockito.when(restTemplate.getForEntity(GithubRepoUrl + "?q=" + testQuery, GithubSearchResponseRoot.class)).thenReturn(new ResponseEntity(null, HttpStatus.NOT_FOUND));

        //WHEN
        try {
            List<String> result = repo.searchByText(testQuery);
            fail("Exception not thrown");
        }catch (RestCommunicationException e) {}


        //THEN
        Mockito.verify(restTemplate).getForEntity(GithubRepoUrl + "?q=" + testQuery, GithubSearchResponseRoot.class);
    }

}
