package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    private static void start() {
        loop:
        while (true) {
            List<String> computer = random();
            String answer = String.join("", computer);

            game(computer, answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            switch (Console.readLine()) {
                case "1":
                    break;
                case "2":
                    break loop;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private static void game(List<String> computer, String answer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String guess = Console.readLine();
            exception(guess);

            if (answer.equals(guess)) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            int ball = 0;
            int strike = 0;
            for (int i = 0; i < computer.size(); i++) {
                if (computer.get(i).equals(String.valueOf(guess.charAt(i)))) {
                    strike++;
                } else if (computer.contains(String.valueOf(guess.charAt(i)))) {
                    ball++;
                }
            }

            output(ball, strike);
        }
    }

    private static void output(int ball, int strike) {
        StringBuilder output = new StringBuilder();
        if (ball != 0) {
            output.append(ball).append("볼 ");
        }
        if (strike != 0) {
            output.append(strike).append("스트라이크");
        }
        if (output.isEmpty()) {
            output.append("낫싱");
        }
        System.out.println(output);
    }

    private static void exception(String guess) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (guess.length() != 3 || list.contains(c) || !Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
            list.add(c);
        }
    }

    private static List<String> random() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
