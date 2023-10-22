package baseball.model;

public class PlayerNum {
    private String playerNum;
    public PlayerNum(){
        initPlayerNum();
    }
    public void initPlayerNum() {
        this.playerNum = "";
    }
    public String getPlayerNum() {
        return playerNum;
    }
    public void setPlayerNum(String playerNum) {
        this.playerNum = playerNum;
    }
}
