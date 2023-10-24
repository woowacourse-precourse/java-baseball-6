package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.run();
    }
}

class BaseballGame {
    private List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    private List<Integer> compareAnswerWithUserInput(List<Integer> answer, List<Integer> userInput) {
        List<Integer> comparing = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i=0;i<3;i++) {
            if (answer.contains(userInput.get(i))) {
                if (answer.get(i).equals(userInput.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        comparing.add(ball);
        comparing.add(strike);
        return comparing;
    }

    private Boolean isNothing(List<Integer> comparing) {
        return comparing.get(0) == 0 && comparing.get(1) == 0;
    }

    private Boolean isCorrect(List<Integer> comparing) {
        return comparing.get(1) == 3;
    }

    private List<Integer> convertUserInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<input.length();i++) {
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

    private void validateNumber(String number) throws IllegalArgumentException {
        if (number.length() != 3)
            throw new IllegalArgumentException();
        char num;
        Set<Character> distinctNumber = new HashSet<>();
        for (int i=0;i<3;i++) {
            num = number.charAt(i);
            if ('1' > num || num > '9')
                throw new IllegalArgumentException();
            distinctNumber.add(num);
        }
        if (distinctNumber.size() < 3)
            throw new IllegalArgumentException();

    }

    private void validateContinueGame(String number) throws IllegalArgumentException {
        if (number.length() != 1)
            throw new IllegalArgumentException();
        if (!(number.equals("1") || number.equals("2")))
            throw new IllegalArgumentException();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String number, continueGame;
        List<Integer> userInput;
        List<Integer> comparing;
        List<Integer> answer;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            answer = generateAnswer();
//            System.out.println(Arrays.toString(answer.toArray()));
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                number = scanner.nextLine();
                validateNumber(number);
                userInput = convertUserInputToList(number);
                comparing = compareAnswerWithUserInput(answer, userInput);
                printResult(comparing);
                if (isCorrect(comparing)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                if (isNothing(comparing)) {
                    System.out.println("낫싱");
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueGame = scanner.nextLine().strip();
            validateContinueGame(continueGame);
            if (!isContinue(continueGame)) {
                break;
            }
        }
    }
}