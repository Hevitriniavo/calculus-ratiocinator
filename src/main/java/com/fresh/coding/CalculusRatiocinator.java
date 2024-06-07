package com.fresh.coding;

import com.fresh.coding.enums.ValeurDeVerite;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
public class CalculusRatiocinator {
    private final Map<String, Affirmation> affirmations;

    public CalculusRatiocinator() {
        this.affirmations = new HashMap<>();
    }

    public void addAffirmation(Affirmation affirmation) {
        affirmations.put(affirmation.getDescription(), affirmation);
    }

    public ValeurDeVerite evaluer(Affirmation affirmation){
        if(affirmations.containsKey(affirmation.getDescription())){
            return affirmation.evaluer();
        } else {
            return ValeurDeVerite.JENESAISPAS;
        }
    }
}
