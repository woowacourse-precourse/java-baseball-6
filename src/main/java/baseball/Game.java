package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.Arrays;

public class Game {
    List<Integer> computer = new ArrayList<>();

    public Game() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void start() {
        Game game;
        int restart = 0;
        do {
            game = new Game();
            game.defineGameResult();
            restart = game.checkRestart();
        } while (restart == 1);
    }

    private void defineGameResult() {
        int isSolved = 0;
        do {
            System.out.printf("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            checkWrongInput(Integer.parseInt(input));

            List<Integer> user = MakeIntArray(input);
            int StrikeCnt = GetStrikeCnt(user);
            int BallCnt = GetBallCnt(user);

            isSolved = printResult(StrikeCnt, BallCnt);

        } while (isSolved == 0);
    }

    private int printResult(int StrikeCnt, int BallCnt) {
        if (StrikeCnt == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        } else if (StrikeCnt == 0 && BallCnt == 0) {
            System.out.println("낫싱");
            return 0;
        } else if (StrikeCnt == 0) {
            System.out.println(BallCnt + "볼");
            return 0;
        } else if (BallCnt == 0) {
            System.out.println(StrikeCnt + "스트라이크");
            return 0;
        } else {
            System.out.println(BallCnt + "볼 " + StrikeCnt + "스트라이크");
            return 0;
        }
    }

    private List<Integer> MakeIntArray(String input) {
        List<Integer> user = new ArrayList<>();
        int num = Integer.parseInt(input);
        for (int i = 0; i < 3; i++) {
            user.add(num % 10);
            num /= 10;
        }
        Collections.reverse(user);
        return user;
    }

    private int GetStrikeCnt(List<Integer> user) {
        System.out.println(Arrays.deepToString(user.toArray()));
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(idx))) {
                user.remove(idx);
                cnt++;
            } else {
                idx++;
            }
        }
        return cnt;
    }

    private int GetBallCnt(List<Integer> user) {
        int cnt = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private void checkWrongInput(int input) {
        int place = input / 100;
        if (place == 0 || place > 9) {
            throw new IllegalArgumentException("게임 종료");
        }
        for (int i = 0; i < 3; i++) {
            if (input % 10 == 0) {
                throw new IllegalArgumentException("게임 종료");
            }
            input /= 10;
        }
    }

    private int checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (Objects.equals(input, "1")) {
            return 1;
        } else if (Objects.equals(input, "2")) {
            return 0;
        } else {
            throw new IllegalArgumentException("게임 종료");
        }
    }
}
