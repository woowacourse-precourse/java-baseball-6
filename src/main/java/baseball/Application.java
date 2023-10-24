package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.CommandLine.input;
import static baseball.CommandLine.showln;

public class Application {

    public static void main(String[] args) {
        showln("숫자 야구 게임을 시작합니다.");
        baseballGame();
    }

    private static void baseballGame() {
        while (true) {
            List<Integer> computer = settingGame();
            while (true) {
                try {
                    if (playGame(computer)) return;
                } catch (IllegalArgumentException e) {
                    return;
                }
            }
        }
    }

    private static boolean playGame(List<Integer> computer) {
        String input = input("숫자를 입력해주세요: ");
        String[] arr = input.split("");

        int count = 0;
        int countS = 0;
        int countB = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (arr[i].contains(String.valueOf(computer.get(j)))) {
                    count++;
                    if (i == j) {
                        countS++;
                        break;
                    } else {
                        countB++;
                        break;
                    }
                }
            }
        }

        if (resultGame(count, countB, countS)) return true;
        return false;
    }

    private static boolean resultGame(int count, int countB, int countS) {
        if (count == 0) {
            showln("낫싱");
        }
        if (count > 0) {
            if (countB > 0 && countS == 0) {
                showln(countB + "볼");
            }
            if (countS > 0 && countB == 0) {
                showln(countS + "스트라이크");
            }
            if (countB > 0 && countS > 0) {
                showln(countB + "볼 " + countS + "스트라이크");
            }
            if (countS == 3) {
                showln("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // 게임 재시작
                String in = input();
                if (in.equals("2")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Integer> settingGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        showln("right answer for test : " + String.join("", computer.stream().map(String::valueOf).toList())); // 나중에 지워야 함.
        return computer;
    }
}


