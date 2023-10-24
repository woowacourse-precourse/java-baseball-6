package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = selectNumbers();
        game(computer);
    }

    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public static List<Integer> selectNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void game(List<Integer> computer) {
          String input = inputNumbers();
          int len = input.length();
          checkInputSize(len);
          compare(computer, input);
    }

    public static void compare(List<Integer> computer, String input) {
        int cntStrike = 0;
        int cntBall = 0;
        HashSet<Integer> checkRepetition = new HashSet<>();

        for(int i=0; i<computer.size(); i++) {
            int num = stringToInt(input, i);
            numberRangeValidation(num);
            checkRepetition.add(num);

            if((num) == computer.get(i)) cntStrike += 1;
            else if (computer.contains(num)) cntBall += 1;

        }
        checkOverlap(checkRepetition);
        countResult(cntStrike, cntBall);
        gameResult(computer, cntStrike, cntBall);

    }

    public static void checkInputSize(int len) {
        if(len != 3) {
            throw new IllegalArgumentException("숫자 3개를 입력하세요.");
        }
    }

    public static void checkOverlap(HashSet<Integer> array) {
        if(array.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요.");
        }
    }

    public static void numberRangeValidation(int num) {
        if (num<1 | num>9) throw new IllegalArgumentException("1~9를 이용한 3자리의 수만 입력할 수 있습니다.");
    }

    public static void gameResult(List<Integer> computer, int cntStrike, int cntBall) {
        if (cntStrike == 3 && cntBall == 0) restartOrNot();
        else game(computer);
    }

    public static int stringToInt(String str, int i) {
        int num = Character.getNumericValue(str.charAt(i));
        return num;
    }

    public static void countResult(int cntStrike, int cntBall) {
        if (cntStrike == 0 && cntBall == 0) System.out.println("낫싱");
        else if (cntStrike == 0 && cntBall > 0 ) System.out.println(cntBall + "볼");
        else if (cntStrike > 0 && cntBall > 0) System.out.println(cntBall + "볼 "+ cntStrike + "스트라이크");
        else if (cntStrike > 0 && cntBall == 0 ) {
            System.out.println(cntStrike + "스트라이크");
            if (cntStrike ==3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }

    public static String inputRestartStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void restartOrNot() {
        String input = inputRestartStatus();
        int num = stringToInt(input,0);
        if (num == 1) gameRestart();
        else if (num == 2) return;
        else inputRestartStatusValidation();
    }

    public static void inputRestartStatusValidation() {
        throw new IllegalArgumentException("1,2 이외의 값은 입력할 수 없습니다.");
    }

    public static void gameRestart() {
        List<Integer> computer = selectNumbers();
        game(computer);
    }

}
