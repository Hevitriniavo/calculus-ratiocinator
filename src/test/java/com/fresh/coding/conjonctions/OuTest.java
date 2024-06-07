package com.fresh.coding.conjonctions;

import com.fresh.coding.enums.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OuTest {
    @Test
    void evaluer() {
        var ou = new Ou();
        assertEquals(ValeurDeVerite.FAUX, ou.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.FAUX));
        assertEquals(ValeurDeVerite.VRAI, ou.evaluer(ValeurDeVerite.FAUX, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.VRAI, ou.evaluer(ValeurDeVerite.VRAI, ValeurDeVerite.VRAI));
        assertEquals(ValeurDeVerite.VRAI, ou.evaluer(ValeurDeVerite.VRAI, ValeurDeVerite.FAUX));
    }
}