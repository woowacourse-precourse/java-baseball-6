package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    private static final int DIGIT = 3;
    private static int randomNumber;

    public static int pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int randomNumber = 0;
        for (int i = 0; i < computer.size(); i++) {
            randomNumber += computer.get(i) * Math.pow(10, DIGIT - i);
        }

        return randomNumber;
    }

    public static int validateInputNumber(String number) throws IllegalArgumentException {
        Set<Character> player = number.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (player.size() != DIGIT) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(number);
    }

    public static int countStrikes(int number) {
        int strike = 0;
        String computer = Integer.toString(randomNumber);
        String player = Integer.toString(number);

        for (int i = 0; i < DIGIT; i++) {
            if (computer.charAt(i) == player.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    public static int countBalls(int number) {
        Set<Character> computer = Integer.toString(randomNumber).chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> player = Integer.toString(number).chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        computer.retainAll(player);

        return computer.size();
    }

    public static void loopMatching() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            int number = validateInputNumber(Console.readLine());

            StringBuilder sb = new StringBuilder();
            int strike = countStrikes(number);
            if (strike > 0) {
                sb.append(strike);
                sb.append("스트라이크");
            }

            if (strike == DIGIT) {
                System.out.println(sb);
                System.out.println(DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            int ball = countBalls(number) - strike;
            if (ball > 0) {
                sb.insert(0, ball + "볼 ");
                System.out.println(sb);
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
        }
    }

    public static boolean checkResume() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else if (!input.equals("1")) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static void main(String[] args) {
        boolean resume = true;
        while (resume) {
            randomNumber = pickRandomNumber();
            loopMatching();
            resume= checkResume();
        }
    }
}
