package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer = new ArrayList<>();
    int ANSWER_SIZE = 3;

    public void initGame() {

        // 숫자 선택
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGameWithMenu() {
        initGame();
        playGame();

        while (true) {
            String menuInput = getMenuInputAndPrint();
            int menuChoice = validateAndConvertMenuInput(menuInput);

            if (menuChoice == 1) {
                initGame();
                playGame();
            } else if (menuChoice == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

    }

    public void playGame() {
        while (true) {
            String userInput = getUserInputAndPrint();
            validateUserInput(userInput);
            List<Integer> userInputList = stringToNumberList(userInput);

            if (checkGuess(userInputList)) {
                break;
            }
        }
    }

    public String getUserInputAndPrint() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    public String getMenuInputAndPrint() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public boolean checkGuess(List<Integer> userInputList) {
        int strikes = countStrikes(answer, userInputList);
        int balls = countBalls(answer, userInputList);

        if (balls > 0) {
            System.out.printf(balls + "볼 " );
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        if (balls == 0 && strikes == 0){
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static void validateUserInput(String input) {
        // 입력값이 3자리인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }

        // 입력값이 1부터 9까지의 숫자로만 구성되어 있는지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("허용 입력 숫자가 아닙니다.");
        }
    }

    public static Integer validateAndConvertMenuInput(String input) {
        // 입력값이 1자리인지 확인
        if (input.length() != 1) {
            throw new IllegalArgumentException("1자리가 아닙니다.");
        }

        // 입력값이 1부터 2까지의 숫자로만 구성되어 있는지 확인
        if (!input.matches("[1-2]+")) {
            throw new IllegalArgumentException("허용 입력 숫자가 아닙니다.");
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> stringToNumberList(String input) {
        List<Integer> numberList = new ArrayList<>();

        // 입력 문자열을 문자 단위로 순회하면서 숫자로 변환하여 리스트에 추가
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            if (Character.isDigit(digitChar)) {
                int digit = Character.getNumericValue(digitChar);
                numberList.add(digit);
            }
        }

        return numberList;
    }

    public static int countStrikes(List<Integer> answer, List<Integer> guess) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    public static int countBalls(List<Integer> answer, List<Integer> guess) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.contains(guess.get(i)) && !answer.get(i).equals(guess.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}
