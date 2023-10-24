package baseball;

import static baseball.status.ErrorCode.INVALID_DISTINCT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT2;
import static baseball.status.ErrorCode.INVALID_LENGTH_INPUT;
import static baseball.status.GameMsg.BALL;
import static baseball.status.GameMsg.BALL_AND_STRIKE;
import static baseball.status.GameMsg.GAME_OVER;
import static baseball.status.GameMsg.GAME_START;
import static baseball.status.GameMsg.NOTHING;
import static baseball.status.GameMsg.REPLAY_OR_OVER_MESSAGE;
import static baseball.status.GameMsg.SET_INPUT;
import static baseball.status.GameMsg.STRIKE;
import static baseball.status.GameMsg.SUCCESS_MESSAGE;
import static baseball.status.GameSetting.CHOICE_REGEX;
import static baseball.status.GameSetting.COUNT_NUM;
import static baseball.status.GameSetting.INPUT_REGEX;
import static baseball.status.GameSetting.MAX_NUM;
import static baseball.status.GameSetting.MIN_NUM;
import static baseball.status.GameSetting.OVER;
import static baseball.status.GameSetting.REPLAY;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game {

    public void play() {
        List<Integer> computerNum = setComputerNum();
        List<Integer> inputNum = new ArrayList<>();
        while (!inputNum.equals(computerNum)) {
            String input = setInput();
            inputNum = getIntegerInput(input);
            System.out.println(output(computerNum, inputNum));
        }
        handleGameChoice();
    }

    /**
     * 볼, 스트라이크, 낫싱 출력 메시지 생성
     *
     * @param computerNum 컴퓨터 수
     * @param inputNum    입력 수
     * @return 출력 메시지
     */
    public String output(List<Integer> computerNum, List<Integer> inputNum) {
        int[] result = calculateResult(computerNum, inputNum);
        int ball = result[0];
        int strike = result[1];

        StringBuilder outputMessage = new StringBuilder();

        if (strike > 0 && ball == 0) {
            outputMessage.append(STRIKE.getMsg().formatted(strike));
        }

        if (strike == 0 && ball > 0) {
            outputMessage.append(BALL.getMsg().formatted(ball));
        }

        if (strike > 0 && ball > 0) {
            outputMessage.append(BALL_AND_STRIKE.getMsg().formatted(ball, strike));
        }

        if (strike == 0 && ball == 0) {
            outputMessage.append(NOTHING.getMsg());
        }
        return outputMessage.toString();
    }

    /**
     * 볼, 스트라이크 개수 계산
     *
     * @param computerNum 컴퓨터 수
     * @param inputNum    입력 수
     * @return [ball 개수, strike 개수] 형태
     */
    private int[] calculateResult(List<Integer> computerNum, List<Integer> inputNum) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            int num = inputNum.get(i);
            if (computerNum.contains(num)) {
                if (computerNum.indexOf(num) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        return new int[]{ball, strike};
    }

    /**
     * 게임 재시작, 종료 여부
     */
    public void handleGameChoice() {
        System.out.println(SUCCESS_MESSAGE.getMsg());
        System.out.println(REPLAY_OR_OVER_MESSAGE.getMsg());
        String input = Console.readLine();
        String choice = getReplayOrOverInput(input);
        replayOrOver(choice);
    }

    /**
     * 종료 여부에 따른 게임 재시작, 게임 종료
     *
     * @param choice 종료 여부
     */
    private void replayOrOver(String choice) {
        if (choice.equals(REPLAY.getStringValue())) {
            play();
        } else if (choice.equals(OVER.getStringValue())) {
            System.out.println(GAME_OVER.getMsg());
        }
    }

    /**
     * 종료 여부 입력 값 유효성 체크
     *
     * @param s 입력 값
     * @return 입력 값
     */
    public String getReplayOrOverInput(String s) {
        if (!s.matches(CHOICE_REGEX.getStringValue())) {
            throw new IllegalArgumentException(INVALID_FORMAT_INPUT2.getMsg());
        }
        return s;
    }

    /**
     * 컴퓨터 수 설정
     *
     * @return 컴퓨터 수
     */
    private List<Integer> setComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < COUNT_NUM.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM.getValue(), MAX_NUM.getValue());
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }

        return computerNum;
    }

    /**
     * 서로 다른 3자리 수 공백 없이 입력받기
     *
     * @return 입력 값
     */
    private String setInput() {
        System.out.print(SET_INPUT.getMsg());
        return Console.readLine();
    }

    /**
     * 입력 받은 문자열을 Integer 리스트로 변환
     *
     * @param input 입력 값
     * @return 숫자로 변환된 입력 수
     */
    public List<Integer> getIntegerInput(String input) {
        String[] inputArr = input.split("");
        validationInput(inputArr);

        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < COUNT_NUM.getValue(); i++) {
            inputNum.add(Integer.parseInt(inputArr[i]));
        }
        return inputNum;
    }

    /**
     * 입력 값 유효성 체크
     *
     * @param input 입력 값
     */
    private void validationInput(String[] input) {
        if (input.length != COUNT_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT.getMsg());
        }

        for (String s : input) {
            if (!s.matches(INPUT_REGEX.getStringValue())) {
                throw new IllegalArgumentException(INVALID_FORMAT_INPUT.getMsg());
            }
        }

        if (Arrays.stream(input).distinct().count() != COUNT_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_DISTINCT_INPUT.getMsg());
        }
    }
}

public class Application {

    public static void main(String[] args) {
        System.out.println(GAME_START.getMsg());
        Game game = new Game();
        game.play();
        Console.close();
    }
}
