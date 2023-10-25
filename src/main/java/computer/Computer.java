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
    Hint hint = new Hint();

    /**
     * 3자리의 난수 생성
     * @return
     */
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

        try{
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
            } while (true);
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    /**
     * User의 input 입력받아 종료 조건과 비교해 진행
     * @return
     */
    public void getInput(){
        player = new Player();
        String playerInput;
        do{
            playerInput = player.start();
        }while (!chkResult(playerInput));
    }

    /**
     * ball, strike 갯수 count해서 결과문으로 출력 및 성공 여부 판단
     * @param inputNum
     * @return 성공 여부
     */
    private boolean chkResult(String inputNum) {
        int ball = hint.cntBall(randomString, inputNum);
        int strike = hint.cntStrike(randomString, inputNum);
        hint.printHintMessage(ball, strike);

        return (strike == SUCCESS_STRIKE);
    }

    /**
     * 사용자의 입력에 따른 재시작(1) or 종료(2) 판단
     * @param
     * @return 재시작(true), 종료(false)
     */
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


//    /**
//     * strike 갯수 Count
//     * @param inputNum
//     * @return strike 갯수
//     */
//    private int cntStrike(String inputNum) {
//        int strike = 0;
//        for (int i = 0; i < INPUT_LENGTH; i++) {
//            if (randomString.charAt(i) == inputNum.charAt(i)) {
//                strike++;
//            }
//        }
//        return strike;
//    }
//
//    /**
//     * ball 갯수 Count
//     * @param inputNum
//     * @return ball 갯수
//     */
//    private int cntBall(String inputNum) {
//        int ball = 0;
//        for (int i = 0; i < INPUT_LENGTH; i++) {
//            char tmp = inputNum.charAt(i);
//            if (randomString.contains(String.valueOf(tmp)) && randomString.charAt(i) != tmp) {
//                ball++;
//            }
//        }
//        return ball;
//    }

    // 결과 출력
//    private void printHintMessage(int ball, int strike) {
//
//        if (ball == NOTHING) {
//            if (strike == NOTHING) {
//                System.out.println(NOTHING_MESSAGE);
//            } else if (strike == SUCCESS_STRIKE) {
//                System.out.println(strike + STRIKE_MESSAGE);
//                System.out.println(SUCCESS_MESSAGE);
//            } else {
//                System.out.println(strike + STRIKE_MESSAGE);
//            }
//        } else {
//            if (strike == NOTHING) {
//                System.out.println(ball + BALL_MESSAGE);
//            } else {
//                System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
//            }
//        }
//    }
}
