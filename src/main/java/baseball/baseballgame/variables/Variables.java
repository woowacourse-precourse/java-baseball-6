package baseball.baseballgame.variables;

public enum Variables {
    NUM("사용할 숫자의 개수", 3);

    Variables(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;
    public int getValue() {
        return value;
    }
}
