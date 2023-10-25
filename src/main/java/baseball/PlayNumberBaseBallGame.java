package baseball;

import baseball.utils.Notification;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constant.*;
import static baseball.utils.Notification.*;
import static baseball.NumberGenerator.generateAnswerNumbers;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayNumberBaseBallGame {

    private static int strike;
    private static int ball;

    public static void start(){
        System.out.println(Notification.START_GAME);
        String gameStatus = RESTART_GAME;
        while(gameStatus.equals(RESTART_GAME)){
            playGame(generateAnswerNumbers());
            System.out.println(RESTART_OR_STOP_GAME);
            gameStatus = readLine();
            Validator.checkEndOrRestart(gameStatus);
        }
    }

    private static void playGame(List<Integer> answer) {
        initStatus();
        while(strike < NUMBER_SIZE){
            initStatus();
            System.out.println(INPUT_NUMBER);
            compareNumbers(answer, getPlayerAnswer());
            displayResult();
        }
    }

    private static List<Integer> getPlayerAnswer() {
        String playerAnswer = readLine();
        /* 입력으로 받으면 안 되는 예외 사항 총 처리 */
        Validator.checkAllException(playerAnswer);

        List<Integer> playerAnswerList = new ArrayList<>();
        for(int i = 0; i < NUMBER_SIZE; ++i){
            playerAnswerList.add(playerAnswer.charAt(i) - '0');
        }
        return playerAnswerList;
    }

    private static void compareNumbers(List<Integer> answerList, List<Integer> playerAnswer) {
        for(int i = 0; i < NUMBER_SIZE; ++i){
            int currentNumber = playerAnswer.get(i);
            /* 현 상태에 대한 값을 정리 */
            checkStatus(answerList, currentNumber, i);
        }
    }

    private static void checkStatus(List<Integer> answerList, int currentNumber, int index){
        if(!answerList.contains(currentNumber)){
            return;
        }
        if(answerList.get(index) == currentNumber){
            ++strike;
            return;
        }
        ++ball;
    }

    private static void displayResult() {
        if(strike == NUMBER_SIZE){
            System.out.println(FIND_ANSWER);
            return;
        }
        if(strike == 0 && ball == 0){
            System.out.println(FIND_NOTHING);
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private static void initStatus(){
        strike = 0;
        ball = 0;
    }
}
