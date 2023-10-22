package baseball;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber = RandomNumberGenerator();
        Message.gameStart();
        playGame(computerNumber);
    }

    public static void playGame(List<Integer> computerNumber) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Message.gameInput();
            String N = Console.readLine();
            List<Integer> li = changeStrToList(N);
            runException(N);
            duplicate_Num(li);
            int strikes = countStrikes(computerNumber, li);
            int balls = countBalls(computerNumber, li);
            printInfo(strikes, balls);
            if (strikes == 3) break;
        }
        restartGame();
    }

    public static void duplicate_Num(List<Integer> li) {
        Set<Integer> set = new HashSet<>();

        for (Integer item : li) {
            if (!set.add(item)) {
                throw new IllegalStateException(Message.DUPLICATE_NUM);
            }
        }
    }

    public static List<Integer> changeStrToList(String input) {
        List<Integer> resultList = Arrays.stream(input.split("")).map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // 숫자로 변환 불가능 할 때, 예외 던지기
                throw new IllegalArgumentException(Message.ONLY_NUM);
            }
        }).collect(Collectors.toList());
        return resultList;
    }

    public static List<Integer> RandomNumberGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int countStrikes(List<Integer> computerNumber, List<Integer> guess_Num) {
        int strikes = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == guess_Num.get(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    public static int countBalls(List<Integer> computerNumber, List<Integer> guess_Num) {
        int balls = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            int targetDigit = guess_Num.get(i);
            if (targetDigit != computerNumber.get(i) && computerNumber.contains(targetDigit)) {
                balls++;
            }
        }
        return balls;
    }

    public static void printInfo(int strikes, int balls) {
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println();
        }
        if (strikes == 3) {
            Message.gameEnd();

        }
    }

    public static void restartGame() {
        Message.reStart();
        int game = Integer.parseInt(Console.readLine());
        if (game == 1) {
            List<Integer> ran_Num = RandomNumberGenerator();
            playGame(ran_Num);
        }
    }

    public static void runException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(Message.INVALID_INPUT_MESSAGE);
        }

    }
}

