package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameRunning = true;

        while (gameRunning) {
            List<Integer> targetNumbers = generateTargetNumbers(random);
            System.out.println("숫자 야구 게임을 시작합니다.");

            int attempts = 0;

            while (true) {
                try {
                    List<Integer> userNumbers = getUserInput(scanner);
                    validateUserInput(userNumbers);

                    int strikeCnt = countStrikes(targetNumbers, userNumbers);
                    int ballCnt = countBalls(targetNumbers, userNumbers);

                    if (strikeCnt > 0 && ballCnt > 0) {
                        System.out.println("볼 : " + ballCnt + ", 스트라이크 : " + strikeCnt);
                    } else if (ballCnt > 0) {
                        System.out.println("볼 : " + ballCnt);

                    } else if (strikeCnt > 0) {
                        System.out.println("스트라이크 : " + strikeCnt);

                    } else {
                        System.out.println("낫싱");
                    }

                    if (strikeCnt == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }

                    attempts++;
                } catch (IllegalArgumentException e) {
                    gameRunning = false;
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = scanner.nextInt();

            if (choice != 1) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }

    // 무작위로 서로 다른 세 자리 숫자 생성
    private static List<Integer> generateTargetNumbers(Random random) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = 1 + random.nextInt(9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    // 사용자로부터 입력을 받아 List<Integer>로 반환
    private static List<Integer> getUserInput(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        int userInput = scanner.nextInt();
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.add(userInput / 100);
        userNumbers.add((userInput / 10) % 10);
        userNumbers.add(userInput % 10);
        return userNumbers;
    }

    // 사용자 입력 유효성 검사
    private static void validateUserInput(List<Integer> userNumbers) {
        if (userNumbers.size() != 3 ||
                userNumbers.stream().anyMatch(n -> n < 1 || n > 9) ||
                userNumbers.stream().distinct().count() < 3) {
            throw new IllegalArgumentException();
        }
    }

    // 스트라이크 개수 계산
    private static int countStrikes(List<Integer> target, List<Integer> user) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (target.get(i).equals(user.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    // 볼 개수 계산
    private static int countBalls(List<Integer> target, List<Integer> user) {
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (!target.get(i).equals(user.get(i)) && target.contains(user.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

}

