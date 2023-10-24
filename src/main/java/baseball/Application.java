package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().run();
    }

    final String start = "숫자 야구 게임을 시작합니다.";
    final String strike = "스트라이크";
    final String ball = "볼";
    final String nothing = "낫싱";
    final String requestCommand = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String requestNumber = "숫자를 입력해 주세요 : ";
    final String end = "게임 종료";
    List<Integer> numbers;

    // 실행
    public void run() {
        // 0 진행 1 init 2 종료
        int gameStatus = 1;

        System.out.println(start);

        while (gameStatus != 2) {
            if (gameStatus == 1) {
                init();
                gameStatus = 0;
            }

            System.out.print(requestNumber);
            int[] ballCount = countBallAndStrike(inputNumber());

            // ball/strike 메시지
            System.out.println(makeMessage(ballCount));

            if (ballCount[1] == 3) {
                System.out.println(requestCommand);
                String cmd = inputCmd();
                gameStatus = Integer.parseInt(cmd);
                if (gameStatus == 2) {
                    System.out.println(end);
                }
            }
        }
    }

    // 게임 초기화
    public void init() {
        numbers = setNumbers();
    }

    // 난수 뽑기
    public List<Integer> setNumbers() {
        boolean[] check = new boolean[10];

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(1, 9);

            if (check[number]) {
                continue;
            }

            check[number] = true;
            numbers.add(number);
        }

        return numbers;
    }

    // 입력된 숫자 카운트
    public int[] countBallAndStrike(String param) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (param.charAt(i) - '0' == numbers.get(j)) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }

    // 숫자 입력
    public String inputNumber() {
        String param = Console.readLine();

        if (param.length() != 3 || !isInteger(param) || !isUnique(param)) {
            throw new IllegalArgumentException();
        }

        return param;
    }

    // 명령어 숫자 입력
    public String inputCmd() {
        String param = Console.readLine();

        if (param.length() != 1 || !isInteger(param) || !isCmd(param)) {
            throw new IllegalArgumentException();
        }

        return param;
    }

    // 숫자인지 확인
    public boolean isInteger(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 모두 다른 숫자인지 확인
    public boolean isUnique(String param) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < param.length(); i++) {
            set.add(param.charAt(i));
        }

        if (set.size() == 3) {
            return true;
        }
        return false;
    }

    // 명령어인지 확인
    public boolean isCmd(String param) {
        int n = Integer.parseInt(param);
        if (n == 1 || n == 2) {
            return true;
        }
        return false;
    }

    // 볼-스트라이크 메시지 생성
    public String makeMessage(int[] ballCount) {
        StringBuilder message = new StringBuilder();

        // nothing
        if (ballCount[0] == 0 && ballCount[1] == 0) {
            return message.append(nothing).toString();
        }

        // ball
        if (ballCount[0] != 0) {
            message.append(ballCount[0]).append(ball).append(' ');
        }

        // strike
        if (ballCount[1] != 0) {
            message.append(ballCount[1]).append(strike);
        }

        return message.toString();
    }
}
