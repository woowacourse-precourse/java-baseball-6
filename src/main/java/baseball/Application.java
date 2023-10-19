package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.List;


public class Application {

    void baseball() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            System.out.println("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            exceptionHandler(user);
            strike = 0;
            ball = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == Integer.parseInt(String.valueOf(user.charAt(j)))) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            if (ballCount(strike, ball)) {
                break;
            }
        }
    }

    boolean ballCount(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    void exceptionHandler(String user) {
        if (user.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(user.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            application.baseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String play = Console.readLine();
            if (play.equals("1")) {
                continue;
            }
            if (play.equals("2")) {
                return;
            }
        }
    }
}
