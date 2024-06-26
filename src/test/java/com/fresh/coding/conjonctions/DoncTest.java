package com.fresh.coding.conjonctions;

import com.fresh.coding.verites.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoncTest {

    @Test
    void evaluer() {
        var donc = new Donc();
        assertEquals(ValeurDeVerite.FAUX, donc.evaluer(ValeurDeVerite.VRAI, ValeurDeVerite.FAUX));
        assertEquals(ValeurDeVerite.VRAI, donc.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.VRAI, donc.evaluer(ValeurDeVerite.VRAI, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.VRAI, donc.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.FAUX));
    }
}
