package baseball.numberBaseball.type;

public enum PlayType {
    MAX_PLAY_SIZE(3),
    STRIKEOUT(3);

    private final int playValue;

    PlayType(int playValue){
        this.playValue = playValue;
    }

    public int getPlayValue(){
        return playValue;
    }
}
