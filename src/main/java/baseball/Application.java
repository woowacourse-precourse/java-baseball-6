package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Application {

    // 서로 다른 세자리 랜덤 숫자 생성
    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        Random random = new Random();

        while (computer.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 1부터 9 사이의 랜덤 숫자 생성
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 입력 받은 숫자를 List 로 변환
    public static List<Integer> convertNumberToList(int number) {
        List<Integer> user = new ArrayList<>();
        String numberStr = Integer.toString(number);

        for (int i = 0; i < numberStr.length(); i++) {
            char digitChar = numberStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            user.add(digit);
        }

        return user;
    }

    // 숫자 야구 검사
    public static boolean playBaseball(List<Integer> user, List<Integer> computer) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(user.get(i), computer.get(i))) {
                strikeCnt++;
            } else if (computer.contains(user.get(i))) {
                ballCnt++;
            }
        }

        if (strikeCnt == 3) {
            System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }

        return false;
    }

    public static boolean playAgain(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int gameState = scanner.nextInt();
        return gameState == 1;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner scanner = new Scanner(System.in);

        List<Integer> computer = generateRandomNumber();

        while (true) {

            // 사용자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String userValue = readLine();

            if (userValue.length() != 3) {
                throw new IllegalArgumentException();

            }

            int userNumber = Integer.parseInt(userValue);


            List<Integer> user = convertNumberToList(userNumber);

            // 숫자 야구 검사
            boolean gameOver = playBaseball(user, computer);

            if (gameOver) {
                // 게임 종료
                if (!playAgain(scanner)) {
                    break;
                } else { // 게임 재시작
                    computer = generateRandomNumber();
                }
            }
        }


    }
}