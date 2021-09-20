package hu.iit.me.elosztott1.impl;

import hu.iit.me.elosztott1.CalculatorInterface;
import org.springframework.stereotype.Service;

@Service
public class CalculatorInterfaceImpl implements CalculatorInterface {

    @Override
    public Double add(Double operand1, Double operand2) {
        return operand1 + operand2;
    }

    @Override
    public Double minus(Double operand1, Double operand2) {
        return operand1 - operand2;
    }

    @Override
    public Double multiple(Double operand1, Double operand2) {
        return operand1 * operand2;
    }

    @Override
    public Double divide(Double operand1, Double operand2) {
        return operand1 / operand2;
    }
}
