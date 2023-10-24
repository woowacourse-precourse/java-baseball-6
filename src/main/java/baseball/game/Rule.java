package baseball.game;

public enum Rule {

    MATCH_COUNT(3);
    private final int value;
    Rule(int value) {this.value = value;}
    public int getValue(){return value;}


}

