package com.fresh.coding.conjonctions;

import com.fresh.coding.Conjonction;
import com.fresh.coding.enums.ValeurDeVerite;

public class Donc extends Conjonction {
    @Override
    public ValeurDeVerite evaluer(ValeurDeVerite a, ValeurDeVerite b) {
        if (a == ValeurDeVerite.VRAI && b == ValeurDeVerite.FAUX) {
            return ValeurDeVerite.FAUX;
        }
        return ValeurDeVerite.VRAI;
    }
}
