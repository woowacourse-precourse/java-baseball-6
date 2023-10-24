package baseball.Controller;

import baseball.Service.BaseballService;
import baseball.Service.InputNumberService;
import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;
import java.util.Map;

public class BaseballController {

    private InputNumberService inputNumberService;
    private BaseballService baseballService;
    private InputView inputView;
    private OutputView outputView;

    public BaseballController() {
        inputNumberService = new InputNumberService();
        baseballService = new BaseballService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void gameStart() {
        while (true) {
            outputView.printStartMessage();

            // 랜덤 숫자 뽑기
            List<Character> randomNumbers = getRandomNumberList();
            while (true) {
                // 사용자 입력 받기
                String inputNumber = inputView.readInputNumber();

                // 입력값 검증
                validate(inputNumber);

                // 입력값 리스트 생성
                List<Character> inputNumbers = inputNumberService.createInputNumberList(inputNumber);

                // 스트라이크 개수, 볼 개수
                Map<String, Integer> strikeBallCount = baseballService.getStrikeBallCount(randomNumbers, inputNumbers);

                // 결과 저장 및 출력
                boolean result = getResult(strikeBallCount);
                printResult(strikeBallCount);

                // 재시도 여부
                if (!result) {
                    continue;
                }
                if (!whetherRestart()) {
                    outputView.printEndMessage();
                    return;
                }
                break;
            }
        }
    }

    public List<Character> getRandomNumberList() {
        List<Character> randomNumberList = baseballService.createRandomNumberList();
        return randomNumberList;
    }

    public void validate(String inputNumber) {
        inputNumberService.validateNumber(inputNumber);
        inputNumberService.validateNumberSize(inputNumber);
        inputNumberService.validateFirstNumber(inputNumber);
    }

    public boolean getResult(Map<String, Integer> strikeBallCount) {
        int strikeCount = strikeBallCount.get("strike");

        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public void printResult(Map<String, Integer> strikeBallCount) {
        int ballCount = strikeBallCount.get("ball");
        int strikeCount = strikeBallCount.get("strike");

        if (strikeCount == 3) {
            OutputView.printStrikeCount(strikeCount);
            OutputView.printAllCorrectStrike();
            return;
        }
        if (strikeCount != 0 && ballCount == 0) {
            OutputView.printStrikeCount(strikeCount);
            return;
        }
        if (strikeCount == 0 && ballCount != 0) {
            OutputView.printBallCount(ballCount);
            return;
        }
        if (strikeCount != 0 && ballCount != 0) {
            OutputView.printBallStrikeCount(ballCount, strikeCount);
            return;
        }
        if (strikeCount == 0 && ballCount == 0) {
            OutputView.printNothing();
            return;
        }
    }

    public boolean whetherRestart() {
        return InputView.readGameRestart();
    }

}
