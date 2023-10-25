package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart = 1;

        while (restart == 1) {
            // 야구 게임 시작
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 랜덤 3자리수 생성
            List<Integer> computer = new ArrayList<>();
            generateThreeRandomNumber(computer);

            // 입력 루프
            boolean isFinished = false;

            while (!isFinished) {
                System.out.print("숫자를 입력해주세요 : ");
                String input1 = Console.readLine();

                // 입력 검증
                if (!isPlayerInputValid(input1)) {
                    throw new IllegalArgumentException("중복되지않는 3자리의 수를 입력해 주세요");
                }

                // 맞힘 확인
                List<Integer> player = convertToPlayerList(input1);
                String result = getGameResult(computer, player);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isFinished = true;
                }
            }

            // 재시작 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input2 = Console.readLine();
            if (!input2.matches("[12]{1}")) {
                throw new IllegalArgumentException("1 또는 2를 입력해 주세요");
            }

            restart = Integer.parseInt(input2);
        }
    }

    private static void generateThreeRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static boolean isPlayerInputValid(String playerInput) {
        // 3자리수 검증
        if (!playerInput.matches("[1-9]{3}")) {
            return false;
        }
        // 중복숫자 검증
        char[] numbers = playerInput.toCharArray();
        if (numbers[0] == numbers[1] || numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
            return false;
        }
        return true;
    }

    private static List<Integer> convertToPlayerList(String playerInput) {
        List<Integer> player = new ArrayList<>();
        for (char ch : playerInput.toCharArray()) {
            player.add(Character.digit(ch, 10));
        }
        return player;
    }

    private static String getGameResult(List<Integer> computer, List<Integer> player) {
        // 점수 집계
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < player.size(); j++) {
                if (computer.get(i).equals(player.get(j))) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }

        // 출력 문자열 매칭
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        if (ball == 0 && strike == 1) {
            result = "1스트라이크";
        }
        if (ball == 0 && strike == 2) {
            result = "2스트라이크";
        }
        if (ball == 0 && strike == 3) {
            result = "3스트라이크";
        }
        if (ball == 1 && strike == 0) {
            result = "1볼";
        }
        if (ball == 1 && strike == 1) {
            result = "1볼 1스트라이크";
        }
        if (ball == 1 && strike == 2) {
            result = "1볼 2스트라이크";
        }
        if (ball == 2 && strike == 0) {
            result = "2볼";
        }
        if (ball == 2 && strike == 1) {
            result = "2볼 1스트라이크";
        }
        if (ball == 3 && strike == 0) {
            result = "3볼";
        }

        return result;
    }
}
