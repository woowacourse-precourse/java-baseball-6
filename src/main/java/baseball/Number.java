package baseball;

public enum Number {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    String title;

    Number(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
