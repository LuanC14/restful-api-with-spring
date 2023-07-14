package br.com.erudio.restful_with_spring.controllers;

import br.com.erudio.restful_with_spring.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        return mathService.sum(numberOne, numberTwo);
    }

    @GetMapping
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        return mathService.subtraction(numberOne, numberTwo);
    }

    @GetMapping
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        return mathService.multiplication(numberOne, numberTwo);
    }

    @GetMapping
    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        return mathService.average(numberOne, numberTwo);
    }

    @GetMapping
    @RequestMapping("/square/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) {

       return mathService.squareRoot(number);
    }

}
