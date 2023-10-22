package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = selectNumbers();
        game(computer);
    }

    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public static String inputResultNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        isStrikeOrBall(computer, input);
    }

    public static void isStrikeOrBall(List<Integer> computer, String input) {
        int cntStrike = 0;
        int cntBall = 0;
        for(int i=0; i<computer.size(); i++) {
            int num = stringToInt(input, i);
            if((num) == computer.get(i)) {
                cntStrike += 1;
            } else if (computer.contains(num)) {
                cntBall += 1;
            }
        }
        gameResult(cntStrike, cntBall);

        if (cntStrike == 3 && cntBall == 0) {
            restartOrNot(computer);
        } else {
            game(computer);
        }
    }

    public static int stringToInt(String str, int i) {
        int num = Character.getNumericValue(str.charAt(i));
        return num;
    }

    public static void gameResult(int cntStrike, int cntBall) {
        if (cntStrike == 0 && cntBall == 0) System.out.println("낫싱");
        else if (cntStrike == 0 && cntBall > 0 ) System.out.println(cntBall + "볼");
        else if (cntStrike > 0 && cntBall > 0) System.out.println(cntBall + "볼 "+ cntStrike + "스트라이크");
        else if (cntStrike > 0 && cntBall == 0 ) {
            System.out.println(cntStrike + "스트라이크");
            if (cntStrike ==3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }

    public static void restartOrNot(List<Integer> computer) {
        int num = stringToInt(inputResultNumber(),0);
        if (num == 1) gameRestart();
    }


    public static void gameRestart() {
        List<Integer> computer = selectNumbers();
        game(computer);
    }


}
