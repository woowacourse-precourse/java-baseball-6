package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int DIGIT_LENGTH = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            while (true) {
                runGame();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
//                String input = validateInput();
                if (input.charAt(0) == '1')
                    continue ;
                else if (input.charAt(0) == '2')
                    break ;
                else
                    throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            return ;
        }
    }

//    public static String validateInput() {
//        while (true) {
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            String input = Console.readLine();
//            if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
//                return input;
//            }
//            System.out.println("잘못된 입력입니다.");
//        }
//    }


    public static void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = generateRandomNum();
        System.out.println("answer = " + answer);
        boolean isFinished = false;
        while (!isFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();
            List<Integer> inputNum = convertStringToList(inputString);
            int strike = countBallAndStrike(inputNum, answer);
            if (isAnswer(strike))
                break;
        }
    }

    public static List<Integer> generateRandomNum() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static List<Integer> convertStringToList(String inputString) {
        List<Integer> inputList = new ArrayList<>();
        validateInput(inputString);
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            char c = inputString.charAt(i);
            inputList.add(Character.getNumericValue(c));
        }
        return inputList;
    }

    public static void validateInput(String inputString) {
        if (inputString.length() != DIGIT_LENGTH)
            throw new IllegalArgumentException();
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (!Character.isDigit(inputString.charAt(i)))
                throw new IllegalArgumentException();
        }
    }

    public static boolean isAnswer(int strike) {
        if (strike == DIGIT_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static int countBallAndStrike(List<Integer> inputNum, List<Integer> answer) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            for (int j = 0; j < DIGIT_LENGTH; j++) {
                if (i != j && inputNum.get(i).equals(answer.get(j)))
                    ball++;
                else if (i == j && inputNum.get(i).equals(answer.get(j)))
                    strike++;
            }
        }
        if (ball > 0 && strike > 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");
        else if (ball > 0)
            System.out.println(ball + "볼");
        else if (strike > 0)
            System.out.println(strike + "스트라이크");
        else {
            System.out.println("낫싱");
        }
        return strike;
    }
}