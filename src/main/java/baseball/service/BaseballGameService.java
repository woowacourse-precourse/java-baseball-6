package baseball.service;

import static baseball.utils.BaseballGameUserInputUtils.isInputContainsUniqueValue;
import static baseball.utils.BaseballGameUserInputUtils.isValidInputLength;
import static baseball.utils.BaseballGameUserInputUtils.isValidInputValue;
import static baseball.vo.BaseballGameResultStatus.BALL;
import static baseball.vo.BaseballGameResultStatus.BALL_AND_STRIKE;
import static baseball.vo.BaseballGameResultStatus.NOTHING;
import static baseball.vo.BaseballGameResultStatus.STRIKE;

import baseball.vo.BaseballGameResultDTO;
import baseball.vo.BaseballGameResultStatus;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    public static final int ANSWER_LENGTH = 3;
    public static final String BALL_ANSWER_STRING = "볼";
    public static final String STRIKE_ANSWER_STRING = "스트라이크";
    public static final String NOTHING_ANSWER_STRING = "낫싱";

    public void playBaseballGame() {
        // 1. 게임 시작 => 게임 시작 시 사용자에게 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 게임을 위한 값 세팅 => 상대방 역할을 수행할 컴퓨터의 랜덤한 서로 다른 3가지 수 생성
        List<Integer> computerAnswers = createComputerValue();

        // 3. 입력 => 사용자로부터 서로 다른 3자리 수 입력받음
        String input = readUserAnswerInput();

        // 4. 입력 결과 분석 => 사용자의 입력 값과 컴퓨터의 값을 비교하여 스트라이크, 볼, 낫싱 판단
        BaseballGameResultDTO gameResultDTO = calResult(input.toCharArray(), computerAnswers);

        // 5. 입력에 대한 힌트 출력 => 볼과 스트라이크 개수 혹은 낫싱을 출력
        printUserInputResult(gameResultDTO);
    }

    private List<Integer> createComputerValue() {
        List<Integer> computerAnswers = new ArrayList<>();
        while (computerAnswers.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswers.contains(randomNumber)) {
                computerAnswers.add(randomNumber);
            }
        }
        return computerAnswers;
    }

    private String readUserAnswerInput() {
        System.out.print("숫자를 입력해 주세요 : ");

        String input = Console.readLine();

        if (!isValidInputLength(input)) {
            throw new IllegalArgumentException("3자리의 숫자만 입력해 주세요.");
        }
        if (!isValidInputValue(input)) {
            throw new IllegalArgumentException("1-9 사이의 숫자만 입력해 주세요.");
        }
        if (!isInputContainsUniqueValue(input)) {
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력해 주세요.");
        }

        return input;
    }

    private BaseballGameResultDTO calResult(char[] userInputArray, List<Integer> computerAnswers) {
        int inputValue = 0;
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userInputArray.length; i++) {
            inputValue = Character.getNumericValue(userInputArray[i]);
            for (int j = 0; j < computerAnswers.size(); j++) {
                if (inputValue == computerAnswers.get(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        BaseballGameResultStatus resultStatus = calResultStatus(strike, ball);

        return new BaseballGameResultDTO(resultStatus, ball, strike);
    }

    private BaseballGameResultStatus calResultStatus(int strike, int ball) {
        BaseballGameResultStatus baseballGameResultStatus;

        if (strike != 0) {
            if (ball != 0) {
                baseballGameResultStatus = BALL_AND_STRIKE;
            } else {
                baseballGameResultStatus = STRIKE;
            }
        } else {
            if (ball != 0) {
                baseballGameResultStatus = BALL;
            } else {
                baseballGameResultStatus = NOTHING;
            }
        }

        return baseballGameResultStatus;
    }

    private void printUserInputResult(BaseballGameResultDTO gameResultDTO) {
        int strike = gameResultDTO.getStrike();
        int ball = gameResultDTO.getBall();
        BaseballGameResultStatus resultStatus = gameResultDTO.getGameStatus();

        switch (resultStatus) {
            case BALL_AND_STRIKE -> System.out.println(ball + BALL_ANSWER_STRING + " " + strike + STRIKE_ANSWER_STRING);
            case BALL -> System.out.println(ball + BALL_ANSWER_STRING);
            case STRIKE -> System.out.println(strike + STRIKE_ANSWER_STRING);
            case NOTHING -> System.out.println(NOTHING_ANSWER_STRING);
        }
    }
}
