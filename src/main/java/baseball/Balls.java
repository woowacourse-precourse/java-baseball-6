package baseball;

public class Balls {
    private final MyInt myInt;

    public Balls(String str) {
        myInt = new MyInt(str);
    }

    public MyInt getMyInt() {
        return myInt;
    }
}

