package baseball.domain;
import java.util.ArrayList;
import java.util.List;

public class PlayBaseball {
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();
    private GameScoreSet gameScoreSet;

    public PlayBaseball(){
        this.computerNum = new ComputerNum().getComputerNum();
        System.out.println(this.computerNum);
    }
    public void gameResult(){
        this.gameScoreSet = new GameScoreSet(computerNum, userNum);
    }
    public void inputUserNum(String inputNum){
        userNum = new UserNum(inputNum).getUserNum();
    }

    public GameScoreSet getGameScoreSet(){
        return this.gameScoreSet;
    }



}
