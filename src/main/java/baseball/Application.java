package baseball;

import java.util.*;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isEnd = false; // 게임 종료 여부

        // 전체 게임 루프
        while (!isEnd) {
            // 게임 승리 여부 초기화
            boolean isWin = false;

            // 컴퓨터 숫자 생성
            List<Integer> computer = generateComputerNums();

            // 매 라운드 루프 시작
            while (!isWin) {
                // 유저 숫자 입력 -> 리스트 생성
                List<Integer> user = generateUserNums();

                // 게임 진행
                GameResult result = play(user, computer);

                // 게임 결과 출력
                System.out.println(result);

                // 승리 판정
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

    /**
     * 게임 진행 도중 사용자가 비정상적인 값을 입력한 경우 예외를 터뜨린다.
     * @param str 사용자 입력 문자열
     */
    public static void checkInput(String str) {
        // 입력은 1부터 9까지만을 포함하며 3글자여야 한다.
        if (!Pattern.compile("^[1-9]{3}$").matcher(str).matches()) {
            throw new IllegalArgumentException("입력은 1부터 9까지만을 포함하며 3글자여야 한다.");
        }

        // 입력은 중복을 허용하지 않는다.
        if (str.charAt(0) == str.charAt(1)
                || str.charAt(0) == str.charAt(2)
                || str.charAt(1) == str.charAt(2)) {
            throw new IllegalArgumentException("입력은 중복을 허용하지 않는다.");
        }
    }

    /**
     * 규칙에 따라 게임을 진행하고 각각의 점수(볼, 스트라이크)를 반환한다.
     * @param user 사용자의 숫자 리스트
     * @param computer 컴퓨터의 숫자 리스트
     * @return 게임 결과
     */
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

    /**
     * 컴퓨터의 숫자를 랜덤하게 생성하고 리스트를 반환한다.
     * @return 컴퓨터 숫자 리스트
     */
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

    /**
     * 유저의 숫자를 입력받은 후 예외 처리를 하고 리스트를 반환한다.
     * @return 유저 숫자 리스트
     */
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