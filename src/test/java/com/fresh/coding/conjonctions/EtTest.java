package com.fresh.coding.conjonctions;

import com.fresh.coding.verites.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EtTest {

    @Test
    void evaluer() {
        var et = new Et();
        assertEquals(ValeurDeVerite.FAUX, et.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.FAUX));
        assertEquals(ValeurDeVerite.FAUX, et.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.VRAI, et.evaluer(ValeurDeVerite.VRAI, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.FAUX, et.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.FAUX));
    }
}