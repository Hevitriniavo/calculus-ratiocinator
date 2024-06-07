package com.fresh.coding;

import com.fresh.coding.conjonctions.Et;
import com.fresh.coding.enums.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public ValeurDeVerite evaluer(Affirmation affirmation) {
        if (affirmations.contains(affirmation)) {
            return affirmation.evaluer();
        } else {
            return ValeurDeVerite.JENESAISPAS;
        }
    }

    public ValeurDeVerite evaluer(Affirmation premierAffirmation, Affirmation deuxiemeAffirmation, Conjonction conjonction) {
        if (affirmations.contains(premierAffirmation) && affirmations.contains(deuxiemeAffirmation)) {
            return conjonction.evaluer(premierAffirmation.evaluer(), deuxiemeAffirmation.evaluer());
        } else {
            return ValeurDeVerite.JENESAISPAS;
        }
    }
}
