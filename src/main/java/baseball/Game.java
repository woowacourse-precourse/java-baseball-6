package baseball;

import baseball.model.Number;
import baseball.type.MessageType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

/**
 * @Class : 야구 게임 클래스
 * @auther : SYB
 * @since : 2023/10/21
 */
public class Game {
    private static final int REPLAY_GAME = 1;
    private static final int EXIT_GAME = 0;


    /**
     *  @Method  : 게임 시작 기능
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    public void start() {
        //게임 시작 처리
        System.out.println(MessageType.START.getMessage());

        //게임 진행
        int replayChoice = REPLAY_GAME;
        while (replayChoice == REPLAY_GAME) {
            replayChoice = play();
        }
    }


    /**
     *  @Method  : 게임 진행 기능
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    private int play() {
        Number computerNumber = new Number();
        computerNumber.createRandomNumber();

        Number userNumber = new Number();

        boolean isAnswer = FALSE;
        while(!isAnswer) {
            userNumber.setUserNumberList(inputUserNumber());
            isAnswer = calculator(computerNumber, userNumber);
            userNumber.clear();
        }
        return checkExitReplay();
    }


    /**
     *  @Method  : 사용자 입력 기능
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    private List<Integer> inputUserNumber() {
        return new ArrayList<>();
    }


    /**
     *  @Method  : 재시작 및 종료 처리 기능
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    private int checkExitReplay() {
        return 0;
    }


    /**
     *  @Method  : 힌트 및 정답 처리 기능
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    private boolean calculator(Number computerNumber, Number userNumber) {
        return false;
    }
}
