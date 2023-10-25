package baseball.constant;

public enum GameConstant {
    GAME_DIGIT(3),
    END_CHOICE(2),
    RESTART_CHOICE(1);
    private final int value;
    GameConstant(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
