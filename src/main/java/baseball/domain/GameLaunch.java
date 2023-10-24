package baseball.domain;
import java.util.List;
import java.util.stream.Stream;

public class GameLaunch {
    private int strikeNum;
    private int ballNum;
    public GameLaunch(List<Integer> compNum, List<Integer> userNum){
        this.strikeNum = strikeByCompareNums(compNum, userNum);
        this.ballNum = ballByCompareNums(compNum, userNum);
    }

    public int strikeByCompareNums(List<Integer> compNum, List<Integer> userNum){
        return (int)Stream
                .iterate(0, i->i+1)
                .limit(compNum.size())
                .filter(number -> !compNum.get(number).equals(userNum.get(number)) && compNum.contains(userNum.get(number)))
                .count();
    }

    public int ballByCompareNums(List<Integer> compNum, List<Integer> userNum){
        return (int) Stream
                .iterate(0, i->i+1)
                .limit(compNum.size())
                .filter(number -> compNum.get(number).equals(userNum.get(number)))
                .count();
    }

    public int getStrikeNum(){
        return strikeNum;
    }

    public int getBallNum(){
        return ballNum;
    }
}
