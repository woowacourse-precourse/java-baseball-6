package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    public static final BaseballGame game = new BaseballGame();
    Scanner scanner = new Scanner(System.in);

    private List<Integer> compareAnswerWithUserInput(List<Integer> answer, List<Integer> userInput) {
        List<Integer> compared = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.contains(userInput.get(i))) {
                if (answer.get(i).equals(userInput.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        compared.add(ball);
        compared.add(strike);
        return compared;
    }

    private Boolean isNothing(List<Integer> compared) {
        return compared.get(0) == 0 && compared.get(1) == 0;
    }

    private Boolean isCorrect(List<Integer> compared) {
        return compared.get(1) == 3;
    }

    private List<Integer> convertUserInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
        return list;
    }

    private Boolean isContinue(String game) {
        return Integer.parseInt(game) == 1;
    }

    private void printResult(List<Integer> comparing) {
        String result = "";
        if (comparing.get(0) > 0) {
            result += String.format("%d볼 ", comparing.get(0));
        }
        if (comparing.get(1) > 0) {
            result += String.format("%d스트라이크", comparing.get(1));
        }
        if (result.length() > 0) {
            System.out.println(result);
        }
    }

    public void run() {
        String continueGame;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            doGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueGame = scanner.nextLine().strip();
            Validate.validateContinueGame(continueGame);
        } while (isContinue(continueGame));
    }

    private void doGame() {
        String number;
        List<Integer> userInput, compared;
        Answer.answer.generateAnswer();
//        System.out.println(Arrays.toString(Answer.answer.getNumber().toArray()));
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            number = scanner.nextLine();
            Validate.validateNumber(number);
            userInput = convertUserInputToList(number);
            compared = compareAnswerWithUserInput(Answer.answer.getNumber(), userInput);
            printResult(compared);
            if (isCorrect(compared)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (isNothing(compared)) {
                System.out.println("낫싱");
            }
        }
    }
}
