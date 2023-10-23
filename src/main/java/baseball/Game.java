package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> inputNumberList = new ArrayList<>();
    private final List<Integer> randomNumberList = new ArrayList<>();

    private final GenerateNumerList generateNumerList = new GenerateNumerList();
    private final ValidateInputNumber validateInputNumber = new ValidateInputNumber();
    private final CalculateResult calculateResult = new CalculateResult(inputNumberList, randomNumberList);
    private final PrintResult printResult = new PrintResult();

    private void initializeNumberLists() {
        randomNumberList.clear();
        inputNumberList.clear();
    }

    public void gameStart() {
        initializeNumberLists();
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateNumerList.generateRandomNumberList(randomNumberList);
        gameInProgress();
    }

    private void gameInProgress() {
        inputNumberList.clear();

        // 유저 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        boolean isValidated = validateInputNumber.validateWithRegex(inputNumber);
        if (isValidated) {
            generateNumerList.generateInputNumberList(inputNumber, inputNumberList);
            // 입력값 검증
            validateInputNumber.validateResult(inputNumberList);
        }

        // 결과값 얻기 & 출력
        int strikes = calculateResult.calculateStrikes();
        int balls = calculateResult.calculateBalls();

        boolean isFinished = printResult.print(strikes, balls);
        if (isFinished) {
            gameEnd();
        } else {
            gameInProgress();
        }
    }

    private void gameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        if (Integer.parseInt(number) == 1) {
            gameStart();
        } else if (Integer.parseInt(number) != 2) {
            throw new IllegalArgumentException();
        }
    }
}
