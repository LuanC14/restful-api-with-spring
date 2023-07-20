package br.com.erudio.restful_with_spring.services;

import br.com.erudio.restful_with_spring.exceptions.UnsupportedMathOperationException;
import br.com.erudio.restful_with_spring.utils.other.MathTools;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {

        if (!MathTools.isNumeric(numberOne) || !MathTools.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathTools.convertToDouble(numberOne) + MathTools.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {

        if (!MathTools.isNumeric(numberOne) || !MathTools.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathTools.convertToDouble(numberOne) - MathTools.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        if (!MathTools.isNumeric(numberOne) || !MathTools.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathTools.convertToDouble(numberOne) * MathTools.convertToDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo) {

        if (!MathTools.isNumeric(numberOne) || !MathTools.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return (MathTools.convertToDouble(numberOne) + MathTools.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {

        if (!MathTools.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double numberConverted = MathTools.convertToDouble(number);

        return java.lang.Math.sqrt(numberConverted);
    }

}
