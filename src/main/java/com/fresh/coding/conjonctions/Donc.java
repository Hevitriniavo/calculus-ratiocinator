package com.fresh.coding.conjonctions;

import com.fresh.coding.verites.ValeurDeVerite;

public final class Donc extends Conjonction {
    @Override
    public ValeurDeVerite evaluer(ValeurDeVerite premierVerite, ValeurDeVerite deuxiemeVerite) {
        if (premierVerite == ValeurDeVerite.VRAI && deuxiemeVerite == ValeurDeVerite.FAUX) {
            return ValeurDeVerite.VRAI;
        }
        return ValeurDeVerite.FAUX;
    }
}
