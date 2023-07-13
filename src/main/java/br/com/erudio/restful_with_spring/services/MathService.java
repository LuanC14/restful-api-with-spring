package br.com.erudio.restful_with_spring.services;

import br.com.erudio.restful_with_spring.exceptions.UnsupportedMathOperationException;
import br.com.erudio.restful_with_spring.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {

        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Utils.convertToDouble(numberOne) + Utils.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {

        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Utils.convertToDouble(numberOne) - Utils.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Utils.convertToDouble(numberOne) * Utils.convertToDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo) {

        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return (Utils.convertToDouble(numberOne) + Utils.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {

        if (!Utils.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double numberConverted = Utils.convertToDouble(number);

        return Math.sqrt(numberConverted);
    }

}
