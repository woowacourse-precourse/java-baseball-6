package computer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import constants.MessageConstants;
import player.Player;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;

public class Computer {
    String randomString = new String();
    Hint hint = new Hint();
    Computer computer;
    Player player;

    public void start() {
        computer = new Computer();
        System.out.println(MessageConstants.GAME_START_MESSAGE);

        try{
            do {
                computer.getRandomNumbers();
                computer.getPlayerInput();
                if (computer.chkOptionString()) {
:wq                    // true: Restart
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
        return randomString;
    }

    /**
     * User의 input 입력받아 종료 조건과 비교해 진행
     * @return
     */
    public void getPlayerInput(){
        player = new Player();
        String playerInput;
        do{
            playerInput = player.getInputString();
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
    private boolean chkOptionString(){
        System.out.println(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String playerOption = Console.readLine();

        if (playerOption.equals(String.valueOf(OPTION_RESTART))) {
            return true;
        } else if (playerOption.equals(String.valueOf(OPTION_FINISH))) {
            return false;
        } else {
            throw new IllegalArgumentException(OPTION_INPUT_ERROR_MESSAGE);
        }
    }
}
