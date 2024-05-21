package br.com.ballihost;

public class TimeTypeX {
    private final int number;

    protected TimeTypeX(int number) {
        this.number = number;
    }

    protected int getNumber() {
        return number;
    }

    protected String getString() {
        return String.format("%d", number);
    }

}
