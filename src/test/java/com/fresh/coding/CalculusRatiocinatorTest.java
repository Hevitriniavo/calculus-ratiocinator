package com.fresh.coding;

import com.fresh.coding.conjonctions.Et;
import com.fresh.coding.enums.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculusRatiocinatorTest {

    @Test
    void addAffirmation() {
        var calculusRatiocinator = new CalculusRatiocinator();
        var premierAffirmation = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var deuxiemeAffirmation = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);

        calculusRatiocinator.ajouterAffirmation(premierAffirmation);
        calculusRatiocinator.ajouterAffirmation(deuxiemeAffirmation);
        assertEquals(2, calculusRatiocinator.getAffirmations().size());
        assertTrue(calculusRatiocinator.getAffirmations().contains(premierAffirmation));
        assertTrue(calculusRatiocinator.getAffirmations().contains(deuxiemeAffirmation));
    }

    @Test
    void evaluerSimpleAffirmation() {
        var cr = new CalculusRatiocinator();
        var affirmation1 = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var affirmation2 = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        cr.ajouterAffirmation(affirmation1);
        cr.ajouterAffirmation(affirmation2);
        assertEquals(ValeurDeVerite.VRAI, cr.evaluer(affirmation1));
        assertEquals(ValeurDeVerite.FAUX, cr.evaluer(affirmation2));
    }

    @Test
    void evaluerCompositeAffirmation() {
        var cr = new CalculusRatiocinator();
        var affirmation1 = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var affirmation2 = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        var compositeAffirmation = new CompositeAffirmation("Lou est beau et Lou est pauvre", affirmation1, affirmation2, new Et());
        cr.ajouterAffirmation(compositeAffirmation);
        assertEquals(ValeurDeVerite.FAUX, cr.evaluer(compositeAffirmation));
    }

}
