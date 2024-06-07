package com.fresh.coding;

import com.fresh.coding.conjonctions.Et;
import com.fresh.coding.enums.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculusRatiocinatorTest {

    @Test
    void addAffirmation() {
        var cr = new CalculusRatiocinator();
        var affirmation1 = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var affirmation2 = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);

        cr.addAffirmation(affirmation1);
        cr.addAffirmation(affirmation2);

        assertEquals(2, cr.getAffirmations().size());
        assertTrue(cr.getAffirmations().containsKey("Lou est beau"));
        assertTrue(cr.getAffirmations().containsKey("Lou est pauvre"));
    }

    @Test
    void evaluerSimpleAffirmation() {
        var cr = new CalculusRatiocinator();
        var affirmation1 = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var affirmation2 = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        cr.addAffirmation(affirmation1);
        cr.addAffirmation(affirmation2);
        assertEquals(ValeurDeVerite.VRAI, cr.evaluer(affirmation1));
        assertEquals(ValeurDeVerite.FAUX, cr.evaluer(affirmation2));
    }

    @Test
    void evaluerCompositeAffirmation() {
        var cr = new CalculusRatiocinator();
        var affirmation1 = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var affirmation2 = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        var compositeAffirmation = new CompositeAffirmation("Lou est beau et Lou est pauvre", affirmation1, affirmation2, new Et());
        cr.addAffirmation(compositeAffirmation);
        assertEquals(ValeurDeVerite.FAUX, cr.evaluer(compositeAffirmation));
    }

}
