package com.fresh.coding;

import com.fresh.coding.enums.ValeurDeVerite;

public abstract class Conjonction {
    protected abstract ValeurDeVerite evaluer(ValeurDeVerite a, ValeurDeVerite b);
}
