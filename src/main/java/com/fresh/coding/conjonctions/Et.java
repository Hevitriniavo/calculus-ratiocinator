package com.fresh.coding.conjonctions;

import com.fresh.coding.verites.ValeurDeVerite;

public final class Et extends Conjonction {
    @Override
    public ValeurDeVerite evaluer(ValeurDeVerite a, ValeurDeVerite b) {
        if (a == ValeurDeVerite.VRAI && b == ValeurDeVerite.VRAI) {
            return ValeurDeVerite.VRAI;
        }
        return ValeurDeVerite.FAUX;
    }
}
