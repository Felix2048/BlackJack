package pers.felix.blackjack.enums;

import java.util.Arrays;
import java.util.List;

public enum FaceValue {
    ACE("ACE", new Integer[]{1, 11}),
    TWO("TWO", new Integer[]{ 2 }),
    THREE("THREE", new Integer[]{ 3 }),
    FOUR("FOUR", new Integer[]{ 4 }),
    FIVE("FIVE", new Integer[]{ 5 }),
    SIX("SIX", new Integer[]{ 6 }),
    SEVEN("SEVEN", new Integer[]{ 7 }),
    EIGHT("EIGHT", new Integer[]{ 8 }),
    NINE("NINE", new Integer[]{ 9 }),
    TEN("TEN", new Integer[]{ 10 }),
    JACK("JACK", new Integer[]{ 10 }),
    QUEEN("QUEEN", new Integer[]{ 10 }),
    KING("KING", new Integer[]{ 10 });

    private String name;
    private List<Integer> values;

    private FaceValue(String name, Integer[] values) {
        this.name = name;
        this.values = Arrays.asList(values);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
