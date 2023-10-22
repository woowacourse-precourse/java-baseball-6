package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import utility.Check;

public class BaseballController {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> player = new ArrayList<>();
    static boolean RUNNING = true;
    static boolean ANSWER = false;

    public static void game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (RUNNING) {
            computer.clear();
            //임시로 출ㄹ력
            getRandomNumber(computer);
            ANSWER = false;
            System.out.println(computer + "\n");
            while (!ANSWER) {
                getPlayerNumber();
                ANSWER = isRight();
                if (ANSWER == true) {
                    continueGame();
                }
            }
        }
    }

    public static void getRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void getPlayerNumber() {
        player.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        for (int i = 0; i < 3; i++) {
            if (Check.checkUserInput(input)) {
                player.add(Integer.valueOf(input.substring(i, i + 1)));
            }
        }
    }

    public static boolean isRight() {
        int ballCnt = 0;
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(player.get(i))) {
                ballCnt++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == player.get(i)) {
                strikeCnt++;
                ballCnt--;
            }
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else if (ballCnt == 0 && strikeCnt != 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt != 0 && strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }

        if (strikeCnt == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    public static void continueGame() {
        String input = readLine();
        if (Check.checkContinueInput(input)){
            if (Objects.equals(input, "2")) {
                RUNNING = false;
                System.out.println("게임 종료");
            }
        }
    }

}
