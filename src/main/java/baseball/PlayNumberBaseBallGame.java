package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Constant.*;
import static baseball.Notification.*;

public class PlayNumberBaseBallGame {

    private static Scanner scanner = new Scanner(System.in);
    private static int strike;
    private static int ball;

    public static void start(){
        System.out.println(Notification.START_GAME);
        String gameStatus = RESTART_GAME;
        while(gameStatus.equals(RESTART_GAME)){
            List<Integer> number = NumberGenerator.generateAnswerNumbers();
            playGame(number);
            System.out.println(RESTART_OR_STOP_GAME);
            gameStatus = scanner.next();
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
        String playerAnswer = scanner.next();
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
            /* 현 상태에 대한 값을  */
            if(!answerList.contains(currentNumber)){
                continue;
            }
            if(answerList.get(i) == currentNumber){
                ++strike;
                continue;
            }
            ++ball;
        }
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
