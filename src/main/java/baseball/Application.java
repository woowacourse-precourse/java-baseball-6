package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isEnd = false; // 게임 종료 여부

        // 전체 게임 루프
        while (!isEnd) {
            boolean isWin = false;
            List<Integer> computerNums = generateComputerNums();

            // 매 라운드 루프
            while (!isWin) {
                List<Integer> userNums = generateUserNums();

                GameResult result = play(userNums, computerNums);
                System.out.println(result); // 게임 결과 포맷에 맞게 출력

                isWin = result.isWin();

                // 승리한 경우 결과 표시
                if (isWin) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    switch (readLine()) {
                        case "1":
                            break;
                        case "2":
                            isEnd = true;
                            break;
                        default:
                            throw new IllegalArgumentException("1이나 2를 입력하여야 합니다.");
                    }
                }
            } // 매 라운드 루프 끝
        } // 전체 게임 루프 끝
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
            int digit = Character.getNumericValue(input.charAt(i)); // char -> int
            user.add(digit);
        }

        return user;
    }

    public static void checkInput(String str) {
        if (!Pattern.compile("^[1-9]{3}$").matcher(str).matches()) {
            throw new IllegalArgumentException("입력은 1부터 9까지만을 포함하며 3글자여야 한다.");
        }

        if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2)
            || str.charAt(1) == str.charAt(2)) {
            throw new IllegalArgumentException("입력은 중복을 허용하지 않는다.");
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
}