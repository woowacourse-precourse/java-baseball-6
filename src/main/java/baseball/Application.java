package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int IN_GAME = 0;
    private static final int END_GAME = 1;

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = createComputerNumber(); // 새 컴퓨터 숫자를 생성

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine(); // 사용자로부터 입력을 받는다.
            verifyInput(input, IN_GAME); // 입력 문자열이 형식에 맞는지 검증한다.

            int ball = 0; // 볼의 개수
            int strike = 0; // 스트라이크의 개수

            // 입력의 첫번째 숫자부터 정답숫자의 각 숫자와 비교하여 볼, 스트라이크 여부를 판별한다.
            for (int i = 0; i < 3; i++) {
                for (int c = 0; c < 3; c++) {
                    if (computer.get(c) == input.charAt(i) - '0') { // 숫자가 같을 경우
                        if (c == i) strike++; // 위치도 같다면 strike
                        else ball++; // 위치가 다르면 ball
                    }
                }
            }

            if (ball > 0)
                System.out.print(ball + "볼 ");
            if (strike > 0)
                System.out.print(strike + "스트라이크");
            if (ball == 0 && strike == 0)
                System.out.print("낫싱");
            
            System.out.println();

            // 사용자가 숫자를 맞혔을 경우
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                   "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String retry = Console.readLine();
                verifyInput(retry, END_GAME);
                if (retry.equals("2")) break; // 2면 while문을 종료
                else computer = createComputerNumber(); // 1이면 새 컴퓨터 숫자로 다시 시작
            }
        }

        Console.close();
    }

    /**
     * 사용자가 입력한 문장이 프로그램이 원하는 형식(type)에 맞는지 검증한다.
     * type 종류:
     * - IN_GAME: 컴퓨터의 정답 숫자에 대한 예상 숫자. 즉, 3개의 서로 다른 숫자로 이루어진 문자열
     * - END_GAME: 게임의 재시작 여부를 결정하는 flag. 즉, 1과 2 중에 하나
     * @param input 입력 문장
     * @param type 검증 타입. IN_GAME, END_GAME 중에 하나.
     */
    public static void verifyInput(String input, final int type) {
        if (type == IN_GAME) {
            if (input.length() == 3) {
                // 각 위치의 문자를 숫자로 전환하고 중복되는 숫자가 있다면 return
                int a = input.charAt(0) - '0';
                int b = input.charAt(1) - '0';
                int c = input.charAt(2) - '0';
                if (a > 0 && b > 0 && c > 0 &&
                    a - b != 0 && a - c != 0 && b - c != 0) return;
            }
            throw new IllegalArgumentException("입력의 형식이 맞지 않습니다.");
        }
        else if (type == END_GAME) {
            // 입력이 "1"혹은 "2"가 아니라면 exception 발생 
            if (!input.equals("1") && !input.equals("2"))
                throw new IllegalArgumentException("입력이 1 혹은 2가 아닙니다.");
        }
    }

    /**
     * 새로운 컴퓨터 숫자를 생성한다.
     * @return 컴퓨터 숫자를 담은 List<Integer> 타입 객체
     */
    public static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }

        return computer;
    }
}