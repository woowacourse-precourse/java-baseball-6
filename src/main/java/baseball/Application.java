package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        view.gameStartPrint();
        boolean done;
        do {
            Game.gameMiddle();
            done = Game.gameEnd();
        } while (done);
    }
}

class Input {
    public static String inputThreeNumber() {
        return Console.readLine();
    }

    public static List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stringNumber.length(); i++) {
            char c = stringNumber.charAt(i);
            int digit = Character.getNumericValue(c);
            list.add(digit);
        }
        return list;
    }
}

class Game {
    public static void gameMiddle() {
        List<Integer> list;
        List<Integer> answer = RandomNumber.getUniqueNumbers();
        do {
            view.gameNumberInputPrint();
            String str = Input.inputThreeNumber();
            list = Input.stringToIntegerList(str);
            List<Integer> result = BaseballCalculate.baseballCalculate(answer, list);
            System.out.println(BaseballCalculate.baseballHintPrint(result));
        } while (answer.equals(list) == false);
        view.gameEndPrint();
    }

    public static boolean gameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int i = Integer.parseInt(Console.readLine());
        if (i == 1) {
            return true;
        }
        return false;
        // 나머지 예외처리 ex. 숫자 범위, 숫자가 아닐 때
    }
}

class view {
    public static void gameStartPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameNumberInputPrint() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameEndPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

class RandomNumber {
    private static List<Integer> baseballNumber;

    static List<Integer> getUniqueNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        baseballNumber = computer;
        System.out.println(baseballNumber);
        return baseballNumber;
    }
}

class BaseballCalculate {
    static List<Integer> baseballCalculate(List<Integer> list1, List<Integer> list2) {
        // 공통된 숫자의 수와 같은 위치에 있는 숫자의 수를 세기 위한 변수 초기화
        if (list1.size() != 3 || list2.size() != 3) {
            throw new IllegalArgumentException();
        }
        int samePositionCount = 0;
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        // 두 Set의 교집합을 구한다
        set1.retainAll(set2);
        // 두 리스트를 순회하면서 비교
        for (int i = 0; i < 3; i++) {
            int num1 = list1.get(i);
            int num2 = list2.get(i);

            if (num1 == num2) {
                samePositionCount++; // 공통된 숫자
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(samePositionCount);
        result.add(set1.size() - samePositionCount);
        return result;
    }

    static String baseballHintPrint(List<Integer> list) {
        int strike = list.get(0);
        int ball = list.get(1);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
