package com.tech.dojo.tax.calculator.components;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TaxCalculatorComponentsImpTest {
@Autowired
    TaxCalculatorComponents taxCalculatorComponents;
    /*
     *  Tax brackets
     * Tax bracket A(0 to 14k) = 10.5%
     * Tax bracket B($14,001 to $48,000) = 17.50%
     * Tax bracket C($48,001 to $70,000) = 30.00%
     * Tax bracket D($70,001 to $180,000) = 33.00%
     * Tax bracket E($180,000+) = 39.00%
     * */

    @Test
    public void taxBracketAisAppliedWhenIncomeIsBellow14k() {
        double income = 14000.00;
        double actualTaxToPay =  taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (10.5 / 100);
        Assertions.assertEquals(expectedTaxToPay,actualTaxToPay,"Amount is not as expected ");
    }
    @Test
    public void taxBracketBisAppliedWhenIncomeIsBellow48k() {
        double income = 14001.00;
        double actualTaxToPay =  taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (17.5 / 100);
        Assertions.assertEquals(expectedTaxToPay,actualTaxToPay,"Amount is not as expected ");
    }
    @Test
   public void taxBracketCisAppliedWhenIncomeIsBellow70k() {
        double income = 48001.00;
        double actualTaxToPay =  taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (30 / 100);
        Assertions.assertEquals(expectedTaxToPay,actualTaxToPay,"Amount is not as expected ");
    }
    @Test
    public void taxBracketDisAppliedWhenIncomeIsBellow180k() {
        double income = 70001.00;
        double actualTaxToPay =  taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (33 / 100);
        Assertions.assertEquals(expectedTaxToPay,actualTaxToPay,"Amount is not as expected ");
    }
    @Test
    public void taxBracketEisAppliedWhenIncomeIsAbove180k() {
        double income = 180001.00;
        double actualTaxToPay =  taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (39 / 100);
        Assertions.assertEquals(expectedTaxToPay,actualTaxToPay,"Amount is not as expected ");
    }
    @Test
    public void taxBracketFisAppliedWhenIncomeIsBellow0k() {
        double income = 0;
        double actualTaxToPay = taxCalculatorComponents.calculateTax(income);
        double expectedTaxToPay = income * (10.5 / 100);
        Assertions.assertEquals(expectedTaxToPay, actualTaxToPay, "Amount is not as expected ");
    }
}