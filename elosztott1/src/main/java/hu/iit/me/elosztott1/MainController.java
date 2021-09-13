package hu.iit.me.elosztott1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CalculatorInterface calculator;

    @RequestMapping("/")
    String main() {
        return "Hello world!";
    }

    @RequestMapping(value = "/calc", produces = {MediaType.APPLICATION_JSON_VALUE})
    Double calculate(@Valid CalculatorRequestDto calculatorRequestDto) {
        return calculator.add(calculatorRequestDto.getOperand1(), calculatorRequestDto.getOperand2());
    }

}
