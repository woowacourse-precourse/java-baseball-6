package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        boolean gameAgain = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameAgain) {
            // (1) 랜덤 숫자 만들기
            List<Integer> computerNumber = getComputerNum();
            // (2) 게임 시작
            baseballGame(computerNumber);
            // (3) 게임 재시작 판단
            gameAgain = restartGame();
        }
    }

    private static boolean restartGame() {
        boolean restart = false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char answer = Console.readLine().charAt(0);
        if (answer == '1') {
            restart = true;
        };
        return restart;
    }

    private static List<Integer> getComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void exceptionLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }
    public static void baseballGame(List<Integer> ans) {
        String result = "";
        while(!result.equals("3스트라이크")){
            // (1) 숫자 입력
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> user = new ArrayList<>();
            String input = Console.readLine();
            for (String i : input.split("")) {
                user.add(Integer.parseInt(i));
            }
            exceptionLength(input); // 숫자 입력 예외처리

            // (2) 결과값 생성
            result = gameResult(ans, user);
            System.out.println(result);
        }
    }

    private static String gameResult(List<Integer> computer, List<Integer> user) {
        int existingCount = 0;
        int strikeCount = 0;
        // (1) 숫서상관없이 같은 숫자가 존재하는지 확인
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                existingCount++;
            }
        }
        // (2) 순서상관있이 같은 숫자가 존재하는지 확인
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCount++;
            }
        }
        int ballCount = existingCount - strikeCount;
        if (existingCount == 0) {
            return "낫싱";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        } else if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼" + strikeCount + "스트라이크";
    }
}
