package computer;

import camp.nextstep.edu.missionutils.Randoms;
import constants.MessageConstants;
import player.Player;
import view.Input;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;

public class Computer {
    String randomString = new String();
    Computer computer;
    Player player;

    // 3자리 난수 생성
    public String getRandomNumbers() {
        randomString = "";
        while (randomString.length() < ANSWER_SIZE) {
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!randomString.contains(String.valueOf(randomNum))) {
                randomString += String.valueOf(randomNum);
            }
        }
//        System.out.println("randomString: " + randomString);
        return randomString;
    }

    public void start() {
        computer = new Computer();
        System.out.println(MessageConstants.GAME_START_MESSAGE);

        do {
            computer.getRandomNumbers();    // Computer 난수 생성
            computer.getInput();    // User의 입력
            if (computer.chkRestartOrFinish()) {
                // true: Restart
                // false: Finish
                computer = new Computer();
            } else {
                break;
            }
        }while(true);
    }

    // User의 입력값 받아오기
    public void getInput(){
        player = new Player();
        String playerInput;
        do{
            playerInput = player.start();
        }while (!chkResult(playerInput));
    }

    // strike 갯수 카운트
    private int cntStrike(String inputNum) {
        int strike = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (randomString.charAt(i) == inputNum.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    // ball의 갯수 카운트
    private int cntBall(String inputNum) {
        int ball = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            char tmp = inputNum.charAt(i);
            if (randomString.contains(String.valueOf(tmp)) && randomString.charAt(i) != tmp) {
                ball++;
            }
        }
        return ball;
    }

    private boolean chkResult(String inputNum) {
        int ball = cntBall(inputNum);
        int strike = cntStrike(inputNum);
        printResult(ball, strike);

        return strike == SUCCESS_STRIKE;
    }

    // restart or finish
    private boolean chkRestartOrFinish(){
        String playerOption = Input.readOption();
        if (playerOption.equals(String.valueOf(OPTION_RESTART))) {
            return true;
        } else if (playerOption.equals(String.valueOf(OPTION_FINISH))) {
            return false;
        } else {
            throw new IllegalArgumentException(OPTION_INPUT_ERROR_MESSAGE);
        }
    }

    // 결과 출력
    private void printResult(int ball, int strike) {

        if (ball == NOTHING && strike == NOTHING) {
            System.out.println(NOTHING_MESSAGE);
        } else if (strike == SUCCESS_STRIKE) {
            System.out.println(SUCCESS_MESSAGE);
        } else {
            if (ball == NOTHING) {
                System.out.println(strike + STRIKE_MESSAGE);
            } else if (strike == NOTHING) {
                System.out.println(ball + BALL_MESSAGE);
            } else {
                System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            }
        }
    }
}
