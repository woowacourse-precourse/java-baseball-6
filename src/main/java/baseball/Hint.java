package baseball;

import baseball.View.PlayGameView;

import java.util.List;

public class Hint {
    public static boolean isThreeBall = false;
    public static void compareNumber(List<Integer> computerNum, List<Integer> playerInput){
        isThreeBall = false;
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < 3; i++){
            int player = playerInput.get(i);
            int computer = computerNum.get(i);
            if (player == computer){
                strikeCnt += 1;
            } else if (computerNum.contains(player)){
                ballCnt += 1;
            }
        }

        if (strikeCnt == 3){
            isThreeBall = true;
        }
        PlayGameView.printHint(ballCnt, strikeCnt);

    }
}
