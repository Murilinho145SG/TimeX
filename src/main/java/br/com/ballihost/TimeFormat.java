package br.com.ballihost;

public class TimeFormat {
    private final int number1;
    private final int number2;
    private final int number3;

    protected TimeFormat(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    protected String getHour() {
        return String.format("%02d:%02d:%02d", number1, number2, number3);
    }

    protected String getDate() {
        return String.format("%02d/%02d/%02d", number1, number2, number3);
    }
}
