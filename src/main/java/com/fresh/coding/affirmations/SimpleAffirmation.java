package com.fresh.coding.affirmations;

import com.fresh.coding.verites.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class SimpleAffirmation extends Affirmation {
    private final ValeurDeVerite valeurDeVerite;

    public SimpleAffirmation(String description, ValeurDeVerite valeurDeVerite) {
        super(description);
        this.valeurDeVerite = valeurDeVerite;
    }

    @Override
    public ValeurDeVerite evaluer() {
        return valeurDeVerite;
    }
}
