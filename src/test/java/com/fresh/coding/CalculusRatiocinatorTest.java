package com.fresh.coding;

import com.fresh.coding.affirmations.CompositeAffirmation;
import com.fresh.coding.affirmations.SimpleAffirmation;
import com.fresh.coding.calculus.ratiocinator.CalculusRatiocinator;
import com.fresh.coding.conjonctions.Et;
import com.fresh.coding.verites.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculusRatiocinatorTest {

    @Test
    void ajouterAffirmation() {
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
        var premierAffirmation = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var deuxiemeAffirmation = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        cr.ajouterAffirmation(premierAffirmation);
        cr.ajouterAffirmation(deuxiemeAffirmation);
        assertEquals(ValeurDeVerite.VRAI, cr.evaluerAffirmation(premierAffirmation));
        assertEquals(ValeurDeVerite.FAUX, cr.evaluerAffirmation(deuxiemeAffirmation));
    }

    @Test
    void evaluerCompositeAffirmation() {
        var calculusRatiocinator = new CalculusRatiocinator();
        var premierAffirmation = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var deuxiemeAffirmation = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        var compositeAffirmation = new CompositeAffirmation("Lou est beau et Lou est pauvre", premierAffirmation, deuxiemeAffirmation, new Et());
        calculusRatiocinator.ajouterAffirmation(compositeAffirmation);
        assertEquals(ValeurDeVerite.FAUX, calculusRatiocinator.evaluerAffirmation(compositeAffirmation));
    }

}
