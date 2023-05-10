package com.tech.dojo.tax.calculator.controller;

import com.tech.dojo.tax.calculator.components.TaxCalculatorComponents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaxCalculatorController {
    @Autowired
    TaxCalculatorComponents taxCalculatorComponents;

    @GetMapping("/api/calculatetax")
    @ResponseBody
    public String calculatetax(@RequestParam double income){
        return "Your Tax is "+taxCalculatorComponents.calculateTax(income);
    }

}
