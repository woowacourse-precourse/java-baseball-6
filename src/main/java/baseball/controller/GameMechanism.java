package baseball.controller;

import baseball.domain.CreateNum;
import baseball.domain.UserNum;
import baseball.service.BallStrikeCount;
import baseball.view.InputArea;
import baseball.view.OutputArea;

public class GameMechanism {
    private final CreateNum create;
    private static UserNum user;
    private final BallStrikeCount counter;

    public GameMechanism(){
        create = new CreateNum();
        counter = new BallStrikeCount();
    }

    public void start() {
        do {
            getNumFromInput();
            printCount(getCompareResult());
        }while (!GameClearJudg());
    }

    public void getNumFromInput() {
        user = new UserNum(InputArea.inputUserNum());
        user.getUserNum();
    }

    public int[] getCompareResult() {
        return counter.compareResult(user.getUserNum(), create.getCreateNum());
    }

    public void printCount(int[] count) {
        countResult(count);
        printNothing(count);
    }

    public static void countResult(int[] count) {
        if (count[0] != 0) {
            if(count[1] != 0){
                OutputArea.BallText(count[0]);
                System.out.print(" ");
                OutputArea.StrikeText(count[1]);
            }else{
                OutputArea.BallText(count[0]);
                System.out.print("\n");
            }
        }else if(count[1] != 0){
            OutputArea.StrikeText(count[1]);
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputArea.NoneText();
        }
    }

    public boolean GameClearJudg() {
        if (counter.thirdStrike()) {
            OutputArea.GameClearText();
            return true;
        }
        return false;
    }
}