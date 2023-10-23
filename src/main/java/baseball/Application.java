package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        boolean isGameActive = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isGameActive) {
            newGame();
        }
    }

    private static void newGame() {
        List<Integer> computer = generateUnique3DigitNum();
        int ball;
        int strike=0;
        while(strike<3){
            List<Integer> user = getUserNumber();
        }
    }

    private static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUnique3DigitNum(input);
        List<Integer> list = new ArrayList<>();
        for (String s : input.split("")) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }



    private static List<Integer> generateUnique3DigitNum() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            while (list.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (list.contains(randomNumber)) continue;
                list.add(randomNumber);
            }
        }
        return list;
    }

    private static void validateUnique3DigitNum(String input) {
        if (input.length() != 3) //세자리수가 아닐 경우
            throw new IllegalArgumentException("잘못된 입력 값입니다. 애플리케이션을 종료합니다.");
        boolean[] visit = new boolean[10];
        for (int i = 0; i < input.length(); i++) {
            int num = (int) input.charAt(i) - '0';
            if (num < 1 || num > 9) { //1에서 9사이의 숫자가 아닐 경우
                throw new IllegalArgumentException("잘못된 입력 값입니다. 애플리케이션을 종료합니다.");
            } else if (visit[num]) { //서로다른 숫자가 아닐 경우
                throw new IllegalArgumentException("잘못된 입력 값입니다. 애플리케이션을 종료합니다.");
            } else {
                visit[num] = true;
            }
        }
    }

}
