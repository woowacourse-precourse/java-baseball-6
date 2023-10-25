package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GamePlay gamePlay = new GamePlay();
        gamePlay.playGame();
    }
}

class GamePlay {
    private List<Integer> randomNumber = generateRandomNumber();
    private boolean gameState = false;

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameState) {
            System.out.print("숫자를 입력하세요: ");
            try {
                if (scanner.hasNextInt()) {
                    String input = scanner.next();
                    if (input.length() != 3 || input.charAt(0) == '0' || !input.matches("\\d+")) {
                        throw new IllegalArgumentException("올바른 범위의 3자리 숫자를 입력하세요.");
                    }

                    int userNum = Integer.parseInt(input);
                    List<Integer> userNumList = numberToList(userNum);
                    int strikes = countStrikes(randomNumber, userNumList);
                    int balls = countBalls(randomNumber, userNumList);

                    printResult(strikes, balls);

                    if (strikes == 3) {
                        handleGameEnd(scanner);
                    }
                } else {
                    throw new IllegalArgumentException("문자가 아닌 정수를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                break;
            }
        }
        scanner.close();
    }

    public static List<Integer> generateRandomNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Integer> randomNumber2 = new ArrayList<>();

        while (randomNumber2.size() < 3) {
            int number;
            do {
                number = random.nextInt(9) + 1;
            } while (randomNumber2.contains(number));
            randomNumber2.add(number);
        }

        return randomNumber2;
    }

    public static boolean containsNumber(List<Integer> list, int num) {
        return list.contains(num);
    }

    public static boolean containsDuplicate(List<Integer> list, int num) {
        return list.indexOf(num) != list.lastIndexOf(num);
    }

    public static List<Integer> numberToList(int number) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(number % 10);
            number /= 10;
        }

        return list;
    }

    public static int countStrikes(List<Integer> randomNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i).equals(userNumber.get(i))) {
                strikes++;
                if (containsDuplicate(userNumber, userNumber.get(i))) {
                    throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
                }
            }
        }
        return strikes;
    }

    public static int countBalls(List<Integer> randomNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (!randomNumber.get(i).equals(userNumber.get(i)) && containsNumber(randomNumber, userNumber.get(i))) {
                balls++;
                if (containsDuplicate(userNumber, userNumber.get(i))) {
                    throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
                }
            }
        }
        return balls;
    }

    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 0) {
            System.out.println(balls + "볼");
        } else if (balls == 0) {
            System.out.println(strikes + "스크라이크");
        } else {
            System.out.println(balls + "볼 " + strikes + "스크라이크");
        }
    }

    public void handleGameEnd(Scanner scanner) {
        System.out.println("3 스트라이크, 3개의 숫자를 모두 맞추셨습니다! 게임 종료.");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int number = scanner.nextInt();
        if (number == 1) {
            randomNumber = generateRandomNumber();
        } else {
            gameState = true;
            System.out.println("게임 종료");
        }
    }
}
