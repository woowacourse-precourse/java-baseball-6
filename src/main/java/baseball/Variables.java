package baseball;

public enum Variables {
    NUM("사용할 숫자의 개수", 3);

    Variables(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
