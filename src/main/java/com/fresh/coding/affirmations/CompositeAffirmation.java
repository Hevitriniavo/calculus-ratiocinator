package com.fresh.coding.affirmations;


import com.fresh.coding.conjonctions.Conjonction;
import com.fresh.coding.verites.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CompositeAffirmation extends Affirmation {
    private final Affirmation droit;
    private final Affirmation gauche;
    private final Conjonction conjonction;

    public CompositeAffirmation(String description, Affirmation droit, Affirmation gauche, Conjonction conjonction) {
        super(description);
        this.droit = droit;
        this.gauche = gauche;
        this.conjonction = conjonction;
    }

    @Override
    public ValeurDeVerite evaluer() {
        return conjonction.evaluer(droit.evaluer(), gauche.evaluer());
    }
}
