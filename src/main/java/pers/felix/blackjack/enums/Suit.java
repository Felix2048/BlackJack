package pers.felix.blackjack.enums;

public enum Suit {

    Spade("Spade", 0), Heart("Heart", 1), Diamond("Diamond", 2), Club("Club", 3), Joker("Jocker", 4);

    private String name;
    private int index;

    private Suit(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
