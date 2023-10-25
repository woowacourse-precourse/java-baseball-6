package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = getRandomNum();

            boolean playGame = true;        // 게임 진행 여부를 boolean 값으로 검사
            while (playGame) {
                playGame = playRound(computer);     // 라운드마다 boolean 값을 리턴해 반복문 조건을 검사
            }

            if (askRestartOrExit()) break;  // return되는 boolean 값에 따라 재시작 혹은 종료 결정
        }
    }

    private static boolean playRound(List<Integer> computer) {  // 라운드 진행
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> userNumbers = getUserNum(input);
        calcResult result = calcResult(userNumbers, computer);      // calcResult 함수에 입력받은 숫자와 컴퓨터에 배정된 숫자를 넘겨준다
        return printResult(result);     // 리턴받은 결과를 printResult에 넘겨주면서 그 반환값을 return한다.
    }

    private static List<Integer> getRandomNum() {   // 컴퓨터에 랜덤 숫자 배정
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {      // 중복 숫자에 대한 처리
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserNum(String input) {     // 유저에게 입력 받기
        if (input.length() != 3) {      // 인자의 갯수에 대한 예외 처리
            throw new IllegalArgumentException();
        }

        char[] inputChars = input.toCharArray();     // 중복된 숫자에 대한 예외 처리
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputChars) {
            if (!uniqueChars.add(c)) {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : inputChars) {
            userNumbers.add(Character.getNumericValue(c));
        }
        return userNumbers;
    }

    private static calcResult calcResult(List<Integer> userNumbers, List<Integer> computer) {   // 결과 계산
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(userNumbers.get(i), computer.get(i))) {
                strike++;
            } else if (computer.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        return new calcResult(ball, strike);
    }

    private static boolean printResult(calcResult result) {     // 결과 출력
        if (result.strike() == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (result.ball() == 0 && result.strike() == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result.ball() + "볼 " + result.strike() + "스트라이크");
        }
        return true;
    }

    private static boolean askRestartOrExit() {     // 재시작 혹은 종료 여부 묻기
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        if (Objects.equals(choice, "2")) {
            System.out.println("게임을 종료합니다.");
            return true;
        } else {
            System.out.println("게임을 새로 시작합니다.");
            return false;
        }
    }

    private record calcResult(int ball, int strike) {
    }
}
