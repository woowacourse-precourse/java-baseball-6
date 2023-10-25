package baseball.Controller;

import baseball.Model.PlayNumber;
import baseball.View.OutputView;
import java.util.List;

/*
1. 정답 비교
    1). 숫자가 포함되어있는지 비교
    2). 숫자가 포함되어있는 경우
        2-1). 순서와 숫자가 모두 일치하는 경우
        2-2). 숫자만 포함되어 있는 경우
    3). 숫자가 포함되지 않은 경우
2. 힌트 제공
 */
public class CheckAnswer {
    private static final int gameAnswerLength = 3;
    private static final int answerStrike = 3;
    private static final int init = 0;
    private static final String strike = "스트라이크";
    private static final String ball = "볼";
    private static final String nothing = "낫싱";
    private static final String nullMsg = "";
    private static final String emptySpaceMsg = " ";
    private int strikeCount;
    private int ballCount;

    RandomNumber randomNumber = new RandomNumber();
    OutputView outputView = new OutputView();

    public void startGame(PlayNumber playNumber) {
        List<Integer> computerNumber = randomNumber.generateGameNumbers();
        playNumber.setComputerNumber(computerNumber);
    }

    public boolean toDo(PlayNumber playNumber) {
        List<Integer> playerNumber = playNumber.getPlayerNumber();
        List<Integer> computerNumber = playNumber.getComputerNumber();

        compareNumber(playerNumber, computerNumber);

        boolean check = triStrike();
        return check;

    }

    public void compareNumber(List<Integer> playerNumber, List<Integer> computerNumber) {
        initCount();
        checkAns(playerNumber, computerNumber);
        hint();

    }

    private void hint() {
        String hintMsg = "";

        hintMsg += ballMsg();
        hintMsg += strikeMsg();
        hintMsg += nothingMsg();

        outputView.printHintMsg(hintMsg);
    }

    private String nothingMsg() {
        if (ballCount == 0 && strikeCount == 0) {
            return nothing;
        }
        return nullMsg;
    }

    private String strikeMsg() {
        if (strikeCount > 0) {
            return strikeCount + strike + emptySpaceMsg;
        }
        return nullMsg;
    }

    private String ballMsg() {
        if (ballCount > 0) {
            return ballCount + ball + emptySpaceMsg;
        }
        return nullMsg;
    }

    private void checkAns(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < gameAnswerLength; i++) {
            //스트라이크 비교
            checkStrike(computerNumbers.get(i), playerNumbers.get(i));
            //볼 비교
            checkBall(computerNumbers, playerNumbers.get(i), i);
        }

    }

    private void checkBall(List<Integer> computerNumber, int playerNumber, int i) {
        if (computerNumber.get(i) != playerNumber && computerNumber.contains(playerNumber)) {
            ballCount++;
        }
    }

    private void checkStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strikeCount++;
        }
    }

    private void initCount() {
        strikeCount = init;
        ballCount = init;
    }

    public boolean triStrike() {
        return strikeCount == answerStrike;

    }


}