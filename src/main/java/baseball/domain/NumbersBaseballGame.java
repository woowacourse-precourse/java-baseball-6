package baseball.domain;

import baseball.constant.ContinueFlag;
import baseball.util.InputValueValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersBaseballGame {
    private final int numberOfDigitsInAnswer;
    private final ComputerPlayer computerPlayer;

    public NumbersBaseballGame(int numberOfDigitsInAnswer) {
        this.numberOfDigitsInAnswer = numberOfDigitsInAnswer;
        this.computerPlayer = new ComputerPlayer();
    }

    public void run() {
        do {
            playGame();
        } while (isContinueGame());
        System.out.println("애플리케이션을 종료합니다.");
    }

    private void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerPlayer.makeAnswer(numberOfDigitsInAnswer);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            Numbers userAnswer = getNumbers();
            computerPlayer.judgeUserAnswer(userAnswer);
            computerPlayer.sayJudgement(numberOfDigitsInAnswer);
        } while (!computerPlayer.isCorrectAnswer(numberOfDigitsInAnswer));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private Numbers getNumbers() {
        String inputAnswer = Console.readLine();
        InputValueValidator.checkValidInputAnswer(inputAnswer, numberOfDigitsInAnswer);
        List<Integer> inputNumbers = Arrays.stream(inputAnswer.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return new Numbers(numberOfDigitsInAnswer, inputNumbers);
    }

    private boolean isContinueGame() {
        String message = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", ContinueFlag.CONTINUE.getValue(), ContinueFlag.DONE.getValue());
        System.out.println(message);
        return getContinueFlag() == ContinueFlag.CONTINUE.getValue();
    }

    private int getContinueFlag() {
        String inputContinueFlag = Console.readLine();
        InputValueValidator.checkValidInputContinueFlag(inputContinueFlag);
        return Integer.parseInt(inputContinueFlag);
    }
}
