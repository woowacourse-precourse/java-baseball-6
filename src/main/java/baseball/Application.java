package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    private final int DIGIT = 3;
    private final int randomNumber;
    private boolean resume = true;

    public Application() {
        randomNumber = pickRandomNumber();
    }

    public static void main(String[] args) {
        (new Application()).run();
    }

    public void run() {
        while (resume) {
            matchingNumberLoop();
            checkResume();
        }
    }

    public void finishGame() {
        System.out.println("게임 종료");
        resume = false;
    }

    public int pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int randomNumber = 0;
        for (int i = 0; i < computer.size(); i++) {
            randomNumber += computer.get(i) * Math.pow(10, DIGIT - (i + 1));
        }

        return randomNumber;
    }

    public int validateInputNumber(String number) throws IllegalArgumentException {
        Set<Character> player = number.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (player.size() != DIGIT) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(number);
    }

    public int countStrikes(int number) {
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

    public int countBalls(int number) {
        Set<Character> computer = Integer.toString(randomNumber).chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> player = Integer.toString(number).chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        computer.retainAll(player);

        return computer.size();
    }

    public void matchingNumberLoop() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            StringBuilder sb = new StringBuilder();
            System.out.println("숫자를 입력해주세요 : ");
            int number = validateInputNumber(Console.readLine());

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

    public void checkResume() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("2")) {
            finishGame();
        } else if (!input.equals("1")) {
            throw new IllegalArgumentException();
        }
    }
}
