package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameView {

    private static GameView gameView = new GameView();

    private GameView() {
    }

    public static GameView getInstance() {
        return gameView;
    }

    //비교 결과 반환
    public void displayResult(List<Integer> res) {
        StringBuilder sb = new StringBuilder();
        int ball = res.get(0);
        int strike = res.get(1);

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        if (strike > 0) {
            if (ball > 0) {
                sb.append(" ");
            }
            sb.append(strike).append("스트라이크");
            if (strike == 3) {
                sb.append("\n").append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        System.out.println(sb);
    }

    //사용자에게 숫자값 입력받기
    public List<Integer> userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int digit;
            try {
                digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력해주세요.");
            }
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력해주세요.");
            }
            if (!user.contains(digit)) {
                user.add(digit);
            }
        }

        for (Integer n : user) {
            System.out.print(n + " ");
        }
        System.out.println();
        if (user.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력하세요.");
        }
        return user;
    }

    //재시작 여부 입력받기
    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ans = Console.readLine();

        if (ans.length() > 1) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
        if (!ans.equals("1") && !ans.equals("2")) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
        if (ans.equals("1")) {
            return true;
        }
        return false;
    }

    //게임 시작
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
