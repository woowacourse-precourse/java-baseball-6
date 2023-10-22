package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<Integer> inputNumberList = new ArrayList<>();
    static List<Integer> randomNumberList = new ArrayList<>();
    static String inputNumber;
    static boolean isValidated;
    static boolean isFinished;

    private final ValidateInputNumber validateInputNumber;
    private final GenerateResult generateResult;
    private final GenerateNumerList generateNumerList;

    public Game() {
        this.validateInputNumber = new ValidateInputNumber();
        this.generateResult = new GenerateResult();
        this.generateNumerList = new GenerateNumerList();
    }

    public void gameStart() {
        randomNumberList.clear();
        inputNumberList.clear();

        System.out.println("숫자 야구 게임을 시작합니다.");

        generateNumerList.generateRandomNumberList(randomNumberList);
        gameInProgress();
    }

    public void gameInProgress() {
        inputNumberList.clear();
        // 유저 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();

        isValidated = validateInputNumber.validateWithRegex(inputNumber);

        if (isValidated) {
            generateNumerList.generateInputNumberList(inputNumber, inputNumberList);
            // 입력값 검증
            validateInputNumber.validateResult(inputNumberList);
        }

        // 결과값 얻기 & 출력
        isFinished = generateResult.getResult(inputNumberList, randomNumberList);
        if (isFinished) {
            gameEnd();
        } else {
            gameInProgress();
        }
    }

    public void gameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        if (Integer.parseInt(number) == 1) {
            gameStart();
        } else if (Integer.parseInt(number) != 2) {
            throw new IllegalArgumentException();
        }
    }
}
