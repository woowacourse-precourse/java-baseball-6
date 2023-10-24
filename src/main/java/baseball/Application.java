package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static Computer computer;
    static BallExtractor ballExtractor = new BallExtractor();
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        computer = new Computer();
        Balls computerBalls = computer.makeNumbers();

        while (true) {
            // 숫자 입력
            System.out.println("숫자를 입력해주세요: ");
            Balls playerBalls = ballExtractor.extract(Console.readLine());

            // 결과 계산
            Result result = calculate(computerBalls, playerBalls);

            System.out.println(result);

            if (result.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
        String playerChoose = Console.readLine();

        int choose = validateNumber(playerChoose);

        validateValue(choose);

        if (choose == 1) {
            main(new String[]{});
        }
        if (choose == 2) {
            System.out.println("게임 종료");
        }
    }

    static List<Integer> makeNumbers () {
        // 임의의 수 3개를 만든다.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void validateLength (String playerInput){
        // 길이 검증
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    static int validateNumber (String playerInput){
        int playerNumber;
        // 숫자 검증
        try {
            playerNumber = Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return playerNumber;
    }

    private static void validateRange(int number) {
        // 1에서 9까지의 수인지 검증
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(List<Integer> playerNumbers, int number) {
        // 서로 다른지 검증
        if (playerNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    static public List<Integer> reverse (List < Integer > playerNumbers) {
        List<Integer> reverse = new ArrayList<>();
        for (int i = playerNumbers.size() - 1; i >= 0; i--) {
            reverse.add(playerNumbers.get(i));
        }
        return reverse;
    }

    private static Result calculate(Balls computerBalls, Balls playerBalls) {
        Result result = new Result();
        for (int i=0; i<3; i++) {
            Integer playerBall = playerBalls.get(i);

            if (!computerBalls.contains(playerBall)) result.increaseNothing();
            else if (playerBall != computerBalls.get(i)) result.increaseBall();
            else result.increaseStrike();
        }

        return result;
    }

    private static void validateValue(int choose) throws IllegalArgumentException {
        // 1, 2인지 검증한다.
        if (choose != 1 && choose != 2) {
            throw new IllegalArgumentException();
        }
    }
}
