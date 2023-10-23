package baseball.model;

import java.util.Objects;
import baseball.view.InputView;
public class ReplayNumber {

    private static String replayNumber;


    public static String getReplayNumber(){
        return replayNumber;
    }

    public ReplayNumber(String replayNumber){
        SelectReplayNumber(replayNumber);
        this.replayNumber  = replayNumber;
    }

    ////////
//매개변수 String num 1 or 2저장
    public static void SelectReplayNumber(String num)throws IllegalArgumentException{
        if(!Objects.equals(num, "1") && !Objects.equals(num, "2")){
            throw new IllegalArgumentException("잘못된값을 입력하셨습니다.");
        }
    }
}
