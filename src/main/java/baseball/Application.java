package baseball;

import baseball.model.InputModel;
import baseball.model.OutputModel;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        View.gameStartPrint();
        boolean done;
        do {
            Game.gameMiddle();
            done = Game.gameEnd();
        } while (done);
    }
}

class Game {
    public static void gameMiddle() {
        List<Integer> list;
        OutputModel.setAnswer();
        System.out.println(OutputModel.getAnswer()); // 제출할 때는 지우기!!!!
        do {
            View.gameNumberInputPrint();
            String str = InputModel.inputThreeNumber();
            System.out.println(str); // 제출할 때는 지우기!!!
            InputModel.isInputThreeNumber(str);
            list = InputModel.stringToIntegerList(str);
            List<Integer> result = BaseballCalculate.baseballCalculate(OutputModel.getAnswer(), list);
            String baseballHint = BaseballCalculate.makeBaseballHint(result);
            View.baseballHintPrint(baseballHint);
        } while (!OutputModel.getAnswer().equals(list));
        View.gameEndPrint();
    }

    public static boolean gameEnd() {
        View.gameRestartPrint();
        int i = Integer.parseInt(Console.readLine());
        if (i == 1) {
            return true;
        }
        return false;
        // 나머지 예외처리 ex. 숫자 범위, 숫자가 아닐 때
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

    public static String makeBaseballHint(List<Integer> list) {
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
