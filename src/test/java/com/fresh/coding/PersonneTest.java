package com.fresh.coding;

import com.fresh.coding.affirmations.CompositeAffirmation;
import com.fresh.coding.affirmations.SimpleAffirmation;
import com.fresh.coding.conjonctions.Donc;
import com.fresh.coding.conjonctions.Et;
import com.fresh.coding.conjonctions.Ou;
import com.fresh.coding.verites.ValeurDeVerite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void ajouterAffirmation() {
        var lou = new Personne("Lou");
        var verite = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var mensonge = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);

        lou.ajouterAffirmation(verite);
        lou.ajouterAffirmation(mensonge);

        assertTrue(lou.getCalculusRatiocinator().getAffirmations().contains(verite));
        assertTrue(lou.getCalculusRatiocinator().getAffirmations().contains(mensonge));
    }

    @Test
    void evaluerAffirmation() {
        var lou = new Personne("Lou");
        var verite = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var mensonge = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);

        lou.ajouterAffirmation(verite);
        lou.ajouterAffirmation(mensonge);

        assertEquals(ValeurDeVerite.VRAI, lou.evaluerAffirmation(verite));
        assertEquals(ValeurDeVerite.FAUX, lou.evaluerAffirmation(mensonge));
    }

    @Test
    void evaluerAffirmations() {
        var lou = new Personne("Lou");

        var verite = new SimpleAffirmation("Lou est beau", ValeurDeVerite.VRAI);
        var mensonge = new SimpleAffirmation("Lou est pauvre", ValeurDeVerite.FAUX);
        var affirmation = new SimpleAffirmation("Lou est généreux", ValeurDeVerite.JENESAISPAS);

        lou.ajouterAffirmation(verite);
        lou.ajouterAffirmation(mensonge);
        lou.ajouterAffirmation(affirmation);

        var et = new Et();
        var ou = new Ou();
        var donc = new Donc();

        var louEstPauvreEtlouEstGenereux = lou.evaluerAffirmations(mensonge, affirmation, et);
        assertEquals(ValeurDeVerite.FAUX, louEstPauvreEtlouEstGenereux);

        var louEstBeauDoncLouEstPauvre = lou.evaluerAffirmations(verite, mensonge, donc);
        assertEquals(ValeurDeVerite.FAUX, louEstBeauDoncLouEstPauvre);

        var louEstPauvreDoncLouEstGenereux = lou.evaluerAffirmations(mensonge, affirmation, donc);
        assertEquals(ValeurDeVerite.VRAI, louEstPauvreDoncLouEstGenereux);

        var louEstBeauOuLouEstGenereuxDoncLouEstPauvre = new CompositeAffirmation("Lou est beau ou Lou est généreux", verite, affirmation, ou);
        var result = lou.evaluerAffirmations(louEstBeauOuLouEstGenereuxDoncLouEstPauvre, mensonge, donc);
        assertEquals(ValeurDeVerite.JENESAISPAS, result);
    }

    @Test
    void obtenirCalculusRatiocinator() {
        var lou = new Personne("Lou");
        assertNotNull(lou.getCalculusRatiocinator());
    }
}
