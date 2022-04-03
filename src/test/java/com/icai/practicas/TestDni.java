package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.icai.practicas.model.DNI;


public class TestDni {
    DNI dni1;
    DNI dni2;
    DNI dni3;
    DNI dni4;
    DNI dni5;
    DNI dni6;
    DNI dni7;
    DNI dni8;
    DNI dni9;
    DNI dni10;

    @BeforeEach
    void setUp() {
        dni1=new DNI("00000000T");
        dni2=new DNI("00000001R");
        dni3=new DNI("99999999R");
        dni4=new DNI("0123");
        dni5=new DNI("01234a67Z");
        dni6=new DNI("012345678-");
        dni7=new DNI("0123456789");

    //FUNCIONAN
        dni8=new DNI("12345678Z");
        dni9=new DNI("45673254S");
        dni10=new DNI("72849506L");
    }        

    @Test
    void validate_dni(){

    assertFalse(dni1.validar());
    assertFalse(dni2.validar());
    assertFalse(dni3.validar());
    assertFalse(dni4.validar());
    assertFalse(dni5.validar());
    assertFalse(dni6.validar());
    assertFalse(dni7.validar());

    // DNI que si cumplen todas las validaciones

    assertTrue(dni8.validar());
    assertTrue(dni9.validar());
    assertTrue(dni10.validar());


}}