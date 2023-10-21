package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            playAgain = wannaPlayAgain();
        }
    }

    private static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = createComputerNumber();     //컴퓨터 난수 생성

        while (true) {
            List<Integer> userNumbers = getUserInput();     //값 받아오기
            int[] result = checkAnswerCorrect(userNumbers, computerNumbers);    //정답체크

            if (printResult(result)) {      //정답이면
                break;
            }
        }
    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {       //숫자가 아직 3개 다 채워지지 않았다면
            int randomNumber = Randoms.pickNumberInRange(1, 9);     //1에서 9까지 서로 다른 임의의 수 선택
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input == null || input.length() != NUMBER_LENGTH) {     //  숫자가 3개를 넘어가거나 공백일때
            throw new IllegalArgumentException();
        }
        return parseInput(input);
    }

    private static List<Integer> parseInput(String input) {     //값 할당하기
        String[] line = input.split("");
        List<Integer> user = new ArrayList<>(NUMBER_LENGTH);
        for (String s : line) {
            try {
                int num = Integer.parseInt(s);
                if (user.contains(num)) {      //공통된 숫자가 있다면 에러발생
                    throw new IllegalArgumentException();
                }
                user.add(num);
            } catch (NumberFormatException e) {     //3글자 문자열이 들어왔을 경우
                throw new IllegalArgumentException();
            }
        }
        return user;
    }

    private static int[] checkAnswerCorrect(List<Integer> user, List<Integer> computer) {
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
            } else if (computer.contains(user.get(i))) {
                balls++;
            }
        }
        return new int[]{balls, strikes};
    }

    private static boolean printResult(int[] result) {
        int balls = result[0];
        int strikes = result[1];

        if (balls == 0 && strikes == 0) {
            System.out.print("낫싱");
        } else {
            if (balls > 0) {
                System.out.print(result[0] + "볼 ");
            }
            if (strikes > 0) {
                System.out.print(result[1] + "스트라이크");
            }
        }
        System.out.println();

        if (strikes == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    static boolean wannaPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int try_again = Integer.parseInt(Console.readLine());

        if (try_again == 1) {
            return true;
        } else if (try_again == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
