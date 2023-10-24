package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private List<Integer> answer;

    public BaseballGame() {
        this.answer = null;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            generateAnswer();
            while (true) {
                boolean isOver = query();
                if (isOver) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (isRetry());
    }

    private void generateAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    private boolean query() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String string = Console.readLine();

        if (string.length() != 3) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        int num;
        try {
            num = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            arr.add(0, num % 10);
            num /= 10;
        }

        BaseballResultState result = match(answer, arr);
        System.out.println(result);
        return result.isGameOver();
    }

    public boolean isRetry() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String string = Console.readLine();
        if (string.equals("1")) {
            return true;
        }
        if (string.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력이 올바르지 않습니다.");
    }

    static public BaseballResultState match(List<Integer> a, List<Integer> b) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!a.get(i).equals(b.get(j))) {
                    continue;
                }

                if (i == j) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return new BaseballResultState(ball, strike);
    }
}
