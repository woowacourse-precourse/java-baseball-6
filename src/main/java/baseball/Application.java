package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //new Application().solution();
        new BaseballGame().run();
    }

    private void solution() {
        String currentInput = "";
        List<Integer> computer;

        // 1. 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = pickNumber(); // 상대방(컴퓨터) 랜덤 값 추출

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            // 2. 플레이어 숫자 입력
            currentInput = Console.readLine();
            int check = 0;

            if (numberCheck(currentInput)) { // 2-1. 입력 값이 1~9 사이 숫자일 때, 스트라이크/볼/낫싱 확인
                System.out.println("1~9 사이 숫자야!");
                // 3. 입력된 숫자 스트라이크/볼/낫싱 확인
                check = strikeCheck(currentInput, computer);
                System.out.println("현재 플레이어가 입력한 수 결과: " + check);
            } else { // 2-2. 1~9 사이 숫자 아닐 때, 예외 출력 후 프로그램 종료
                throw new IllegalArgumentException();
            }

            if (check == 0) { // 5. 3스트라이크 일 때, 게임 종료
                // 6. 재시작/종료 문구 출력
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                currentInput = Console.readLine(); // 6-1. 플레이어 숫자 입력 (1또는2)
                if (currentInput.equals("1")) { // 6-2. 1일 때, 재시작
                    computer = pickNumber();
                } else if (currentInput.equals("2")) { // 6-3. 2일 때, 프로그램 종료
                    Console.close();
                    break;
                } else if (!currentInput.equals("1") || !currentInput.equals("2")) {
                    throw new IllegalArgumentException();
                }
            }
            // 5-1. 3스트라이크 아닐 때, 게임 반복
        }
    }

    private List<Integer> pickNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int com : computer) {
            System.out.println("상대방(컴퓨터) 입력 수: " + com);
        }
        return computer;
    }

    private int strikeCheck(String currentInput, List<Integer> computer) {

        int length = currentInput.length();
        int strike = 0;
        int ball = 0;
        int number = 0;
        int result = 0;

        // 플레이어가 입력한 값을 상대방(컴퓨터)이 입력한 값과 비교
        for (int i = 0; i < length; i++) {
            number = Integer.parseInt(String.valueOf(currentInput.charAt(i)));
            for (int j = 0; j < length; j++) { // depth 1
                if (i == j && number == computer.get(j)) { // depth 2 같은 수가 같은 자리에 있으면 스트라이크
                    System.out.println("스트라이크!"); // depth 3
                    strike++;
                    break;
                }
                if (i != j && number == computer.get(j)) { // 다른 자리에 있으면 볼
                    System.out.println("볼!");
                    ball++;
                    break;
                }
            }

        }

        // 3-1. 입력한 수에 대한 결과 문자열 만들기
        // 4. 확인된 카운트 문구 출력
        if (strike == 0 && ball == 0) { // 같은 수가 전혀 없으면 낫싱
            System.out.println("낫싱");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        // 3-2. 3스트라이크 일 때, 0 반환
        // 3-3. 3스트라이크 아닐 때, 1 반환
        if (strike != 3) {
            result = 1;
        }
        return result;
    }

    private boolean numberCheck(String currentInput) {
        return currentInput != null && currentInput.length() == 3 && currentInput.matches("^[1-9]*$");
    }
}
