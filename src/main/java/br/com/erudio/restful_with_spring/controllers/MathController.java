package br.com.erudio.restful_with_spring.controllers;

import br.com.erudio.restful_with_spring.exceptions.UnsupportedMathOperationException;
import br.com.erudio.restful_with_spring.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!Utils.isNumeric(numberOne) || !Utils.isNumeric((numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Utils.convertToDouble(numberOne) + Utils.convertToDouble(numberTwo);
    }
}
