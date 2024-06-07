package com.fresh.coding.conjonctions;

import com.fresh.coding.verites.ValeurDeVerite;

public sealed abstract class Conjonction permits Donc, Ou, Et {
    public abstract ValeurDeVerite evaluer(ValeurDeVerite a, ValeurDeVerite b);
}
