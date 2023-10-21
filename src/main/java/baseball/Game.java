package baseball;

import baseball.model.Number;
import baseball.model.PitchCount;
import baseball.type.MessageType;
import camp.nextstep.edu.missionutils.Console;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @Method : 게임 시작 기능
     * @auther : SYB
     * @since : 2023/10/21
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
     * @Method : 게임 진행 기능
     * @auther : SYB
     * @since : 2023/10/21
     */
    public int play() {
        Number computerNumber = new Number();
        computerNumber.createRandomNumber();

        Number userNumber = new Number();

        boolean isAnswer = FALSE;
        while (!isAnswer) {
            userNumber.setUserNumberList(inputUserNumber());
            isAnswer = calculator(computerNumber, userNumber);
            userNumber.clear();
        }
        return checkExitReplay();
    }


    /**
     * @Method : 사용자 입력 기능
     * @auther : SYB
     * @since : 2023/10/21
     */
    public List<Integer> inputUserNumber() {
        System.out.print(MessageType.ASK.getMessage());

        String inputLine = Console.readLine();
        try {
            return Stream.of(inputLine.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * @Method : 힌트 및 정답 생성 처리 기능
     * @auther : SYB
     * @since : 2023/10/21
     */
    public boolean calculator(Number computerNumber, Number userNumber) {
        PitchCount pitchCount = new PitchCount();

        pitchCount.countStrikeBall(computerNumber.getTarget(), userNumber.getTarget());

        System.out.println(pitchCount.getHint());

        if (pitchCount.isAnswer()) {
            System.out.println(MessageType.SUCCESS.getMessage());
            return true;
        } else {
            return false;
        }
    }


    /**
     * @Method : 재시작 및 종료 처리 기능
     * @auther : SYB
     * @since : 2023/10/21
     */
    private int checkExitReplay() {
        return 0;
    }
}
