package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static int Strike = 0;
    static int Ball = 0;

    static List<Integer> PutNum() {
        String s = Console.readLine();
        int num = Integer.parseInt(s);
        if (num > 999 || num < 99) {
            throw new IllegalArgumentException();
        }
        List<Integer> human = new ArrayList<>();
        human.add(num / 100);
        num = num % 100;
        human.add(num / 10);
        num = num % 10;
        human.add(num);
        for (int i = 0; i < 3; i++) {
            if (human.get(i).equals(0)) {
                throw new IllegalArgumentException();
            }
        }
        Set<Integer> numSet = new HashSet<>(human);
        if (numSet.size() != human.size()) {
            throw new IllegalArgumentException();
        }
        return human;
    }

    static List<Integer> NumGen() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static boolean CheckNum(List<Integer> ComNum, List<Integer> HumNum) {
        for (int i = 0; i < 3; i++) {
            if (ComNum.get(i).equals(HumNum.get(i))) {
                Strike++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (ComNum.get(j).equals(HumNum.get(i))) {
                    Ball++;
                }
            }
        }
        if (Strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (Strike > 0 && Ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", Ball, Strike);
        } else if (Strike > 0 && Ball == 0) {
            System.out.printf("%d스트라이크\n", Strike);
        } else if (Strike == 0 && Ball > 0) {
            System.out.printf("%d볼\n", Ball);
        } else {
            System.out.println("낫싱");
        }
        return false;
    }

    static void InitNum() {
        Strike = 0;
        Ball = 0;
    }

    public static void play_game() {
        List<Integer> ComNum = NumGen();
        boolean N = true;
        while (N) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> HumNum = PutNum();
            N = !CheckNum(ComNum, HumNum);
            InitNum();
        }
    }

    public static int re_game() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play_game();
        }
        while (re_game() == 1);
    }
}