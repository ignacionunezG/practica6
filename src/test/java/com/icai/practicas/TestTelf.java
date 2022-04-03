package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.icai.practicas.model.Telefono;


public class TestTelf{

    Telefono telf1;
    Telefono telf2;
    Telefono telf3;    ;
    Telefono telf4;
    Telefono telf5;
    Telefono telf6;
    Telefono telf7;
    Telefono telf8;


    

    @BeforeEach
    void setUp() {
        telf1=new Telefono("+34609354516");
        telf2=new Telefono("609354516");
        telf3=new Telefono("+34 609354516");
        telf4=new Telefono("609 354 516");

        telf5=new Telefono("978609354516");
        telf6=new Telefono("6K9354516");
        telf7=new Telefono("354516");
        telf8=new Telefono("");


    }        

    @Test
    void validate_telf(){
    //BIEN ESCRITOS
    assertTrue(telf1.validar());
    assertTrue(telf2.validar());
    assertTrue(telf3.validar());
    assertTrue(telf4.validar());
    //MAL ESCRITOS
    assertFalse(telf5.validar());
    assertFalse(telf6.validar());
    assertFalse(telf7.validar());
    assertFalse(telf8.validar());




}}