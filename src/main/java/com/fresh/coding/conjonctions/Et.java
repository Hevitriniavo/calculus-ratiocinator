package com.fresh.coding.conjonctions;

import com.fresh.coding.Conjonction;
import com.fresh.coding.enums.ValeurDeVerite;

public class Et extends Conjonction {
    @Override
    protected ValeurDeVerite evaluer(ValeurDeVerite a, ValeurDeVerite b) {
        if (a == ValeurDeVerite.VRAI && b == ValeurDeVerite.VRAI) {
            return ValeurDeVerite.VRAI;
        }
        return ValeurDeVerite.FAUX;
    }
}
