package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            runGame();
        }
        catch (IllegalArgumentException e) {
            return ;
        }
    }

    public static void runGame() {
        List<Integer> answer = generateRandomNum();
        System.out.println("answer = " + answer);
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();
            List<Integer> inputNum = convertStringToList(inputString);
            countBallAndStrike(inputNum, answer);
        }
    }

    public static List<Integer> generateRandomNum() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static List<Integer> convertStringToList(String inputString) {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c)) {
                inputList.add(Character.getNumericValue(c));
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return inputList;
    }

//    public static void isAnswer(List<Integer> inputNum, List<Integer> answer) {
//
//    }
//    public static int countStrike(List<Integer> inputNum, List<Integer> answer) {
//
//    }

    public static void countBallAndStrike(List<Integer> inputNum, List<Integer> answer) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < inputNum.size(); i++) {
            for (int j = 0; j < inputNum.size(); j++) {
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
    }
}
