package baseball.game;

import baseball.core.code.Message;
import baseball.core.utils.MessagePrinter;
import baseball.core.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.core.code.ErrorMessage.INPUT_ONLY_1_OR_2;
import static baseball.core.code.Message.*;
import static baseball.core.code.Message.STRIKE;

/**
 * Game
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class Game {

    /**
     * 야구 게임 실행
     */
    public void play() {
        // 시작 메시지 출력
        MessagePrinter.print(Message.START);

        // 컴퓨터 숫자 3자리 추출
        List<Integer> computerNumbers = getComputerNumbers();

        boolean gameOver = false;
        while (!gameOver) {
            // 사용자 숫자 입력 기능 및 유효성 체크
            String input = Console.readLine();
            ValidationUtils.validInput(input);

            // 사용자 입력 받은 수와 기존 지정된 숫자 비교
            List<Integer> inputNumbers = Arrays.stream(input.split("")).map(Integer::parseInt).toList();
            gameOver = compare(computerNumbers, inputNumbers);
        }
        // 3개 숫자가 모두 동일한 경우 안내 멘트 출력 후 게임 종료 처리
        MessagePrinter.print(GAME_OVER);

        // 게임 새로 시작 또는 종료 기능 구현
        MessagePrinter.print(GAME_RESTART_OR_QUIT);
        String input = Console.readLine();
        switch (input) {
            case "1":
                play();
                break;
            case "2":
                break;
            default:
                throw new IllegalArgumentException(INPUT_ONLY_1_OR_2.getDescription());
        }
    }

    /**
     * 게임용 숫자 3자리 추출
     * @return List<Integer> 컴퓨터 숫자 리스트
     */
    private List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < ValidationUtils.STANDARD_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    /**
     * 컴퓨터, 사용자 입력 숫자 비교
     * @param computerNumbers 컴퓨터 추출 숫자
     * @param inputNumbers 사용자 입력 숫자
     * @return
     */
    private boolean compare(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer inputNumber = inputNumbers.get(i);

            if (computerNumber == inputNumber) {
                strikeCount++;
            } else if (inputNumbers.contains(computerNumber)) {
                ballCount++;
            }
        }

        String resultMessage = makeResultMessage(strikeCount, ballCount);
        MessagePrinter.print(resultMessage);

        return strikeCount == ValidationUtils.STANDARD_NUMBER;
    }

    /**
     * 두수 비교 결과 메시지 생성
     * @param strikeCount
     * @param ballCount
     * @return
     */
    private String makeResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING.getDescription();
        }

        String resultMessage = "";
        if (ballCount != 0) {
            resultMessage = ballCount + BALL.getDescription();
        }

        if (ballCount != 0 && strikeCount!= 0) {
            resultMessage += " ";
        }

        if (strikeCount != 0) {
            resultMessage += strikeCount + STRIKE.getDescription();
        }
        return resultMessage;
    }
}
