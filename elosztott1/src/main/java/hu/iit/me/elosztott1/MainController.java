package hu.iit.me.elosztott1;

import hu.iit.me.elosztott1.dto.CalculatorRequestDto;
import hu.iit.me.elosztott1.github.Repo;
import hu.iit.me.elosztott1.github.RepoSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CalculatorInterface calculator;
    private final Repo repo;

    @RequestMapping("/")
    String main() {
        return "Hello world!";
    }

    @RequestMapping(value = "/calc", produces = {MediaType.APPLICATION_JSON_VALUE})
    Double calculate(@Valid CalculatorRequestDto calculatorRequestDto) {
        return calculator.add(calculatorRequestDto.getOperand1(), calculatorRequestDto.getOperand2());
    }

    @RequestMapping(value = "/repoSearch", produces = {MediaType.APPLICATION_JSON_VALUE})
    List<String> repoSearch(@Valid RepoSearchDto repoSearchDto) {
        return repo.searchByText(repoSearchDto.getQueryString());
    }

}
