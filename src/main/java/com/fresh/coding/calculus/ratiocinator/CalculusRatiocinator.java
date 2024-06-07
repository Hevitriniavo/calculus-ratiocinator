package com.fresh.coding.calculus.ratiocinator;

import com.fresh.coding.affirmations.Affirmation;
import com.fresh.coding.conjonctions.Conjonction;
import com.fresh.coding.verites.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class CalculusRatiocinator {
    private final Set<Affirmation> affirmations;

    public CalculusRatiocinator() {
        this.affirmations = new HashSet<>();
    }

    public void ajouterAffirmation(Affirmation affirmation) {
        affirmations.add(affirmation);
    }

    public ValeurDeVerite evaluerAffirmation(Affirmation affirmation) {
        if (affirmations.contains(affirmation)) {
            return affirmation.evaluer();
        } else {
            return ValeurDeVerite.JENESAISPAS;
        }
    }

    public ValeurDeVerite evaluerAffirmation(Affirmation premierAffirmation, Affirmation deuxiemeAffirmation, Conjonction conjonction) {
        if (affirmations.contains(premierAffirmation) && affirmations.contains(deuxiemeAffirmation)) {
            return conjonction.evaluer(premierAffirmation.evaluer(), deuxiemeAffirmation.evaluer());
        } else {
            return ValeurDeVerite.JENESAISPAS;
        }
    }
}
