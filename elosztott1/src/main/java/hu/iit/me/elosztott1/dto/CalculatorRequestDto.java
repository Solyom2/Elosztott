package hu.iit.me.elosztott1.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CalculatorRequestDto {

    @NotNull
    private Double operand1;
    @NotNull
    private Double operand2;
    @NotNull
    private String operator;

}
