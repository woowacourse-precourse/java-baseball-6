package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isEnd = false; // 게임 종료 여부

        // 전체 게임 루프
        while (!isEnd) {
            // 게임 승리 여부
            boolean isWin = false;

            // 컴퓨터 숫자 생성
            List<Integer> computer = generateComputerNums();
            for (Integer i : computer) {
                System.out.println("i = " + i);
            }

            // 매 라운드 루프
            while (!isWin) {
                // 유저 숫자 입력 및 생성
                List<Integer> user = generateUserNums();

                // 게임 진행
                GameResult result = play(user, computer);

                // 게임 결과 출력
                System.out.println(result);

                // 게임 승리 시
                if (result.getStrike() == 3) {
                    isWin = true;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String startOrEnd = readLine();

                    if (startOrEnd.equals("1")) {
                        continue;
                    } else if (startOrEnd.equals("2")) {
                        isEnd = true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } // 매 라운드 루프
        } // 전체 게임 루프
    }

    public static void checkInput(String str) {
        List<Character> legalValues = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

        // 세 글자가 아닌 경우 -> 예외 발생
        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 허용되지 않는 문자가 있는 경우 -> 예외 발생
        for (int i = 0; i < str.length(); i++) {
            if (!legalValues.contains(str.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        // 중복되는 경우 -> 예외 발생
        if (str.charAt(0) == str.charAt(1) ||
                str.charAt(0) == str.charAt(2) ||
                str.charAt(1) == str.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static GameResult play(List<Integer> user, List<Integer> computer) {
        GameResult result = new GameResult();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i).equals(computer.get(j))) {
                    if (i == j) {
                        result.addStrike();
                    } else {
                        result.addBall();
                    }
                }
            }
        }

        return result;
    }

    private static List<Integer> generateComputerNums() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int digit = pickNumberInRange(1, 9);
            if (!computer.contains(digit)) {
                computer.add(digit);
            }
        }

        return computer;
    }

    private static List<Integer> generateUserNums() {
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        checkInput(input); // 입력값 예외 처리

        for (int i = 0; i < 3; i++) {
            int digit = Character.getNumericValue(input.charAt(i)); // char -> int 변환
            user.add(digit);
        }

        return user;
    }
}