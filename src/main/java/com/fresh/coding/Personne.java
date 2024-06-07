package com.fresh.coding;

import com.fresh.coding.enums.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public final class Personne {
    private final CalculusRatiocinator calculusRatiocinator;
    private final String name;

    public Personne(String name) {
        this.name = name;
        this.calculusRatiocinator = new CalculusRatiocinator();
    }

    public void ajouterAffirmation(Affirmation affirmation) {
        calculusRatiocinator.ajouterAffirmation(affirmation);
    }

    public ValeurDeVerite evaluerAffirmation(Affirmation affirmation) {
        return calculusRatiocinator.evaluerAffirmation(affirmation);
    }

    public ValeurDeVerite evaluerAffirmations(Affirmation premierAffirmation, Affirmation deuxiemeAffirmation, Conjonction conjonction) {
        return calculusRatiocinator.evaluerAffirmation(premierAffirmation, deuxiemeAffirmation, conjonction);
    }
}
