package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public List<Integer> numbers;

    public void initializeNumber() {
        numbers = new ArrayList<>();
        while (numbers.size() != 3){
            Integer number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public void run() {
        initializeNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String pitchInput = Console.readLine();

            validatePitchInput(pitchInput);

            List<Integer> pitches = parsePitchInput(pitchInput);
            List<Integer> score = ScoreCalculator.calculate(pitches, numbers);

            if (score.get(0) == 0 && score.get(1) == 0) {
                System.out.println("낫싱");
                continue;
            }
            if (score.get(1) > 0) {
                System.out.print(score.get(1) + "볼 ");
            }
            if (score.get(0) > 0) {
                System.out.print(score.get(0) + "스트라이크");
            }
            System.out.println();

            if (score.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restartInput = Console.readLine();

                validateRestartInput(restartInput);

                if (restartInput.equals("2")) {
                    System.out.println("게임을 끝냅니다.");
                    break;
                }

                initializeNumber();
            }
        }
    }

    private void validateRestartInput(String restartInput) {
        if (!(restartInput.equals("1") || restartInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePitchInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.matches(".*[^1-9].*")) {
            throw new IllegalArgumentException();
        }

        if (!input.matches("^(?!.*(.).*\\1)[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> parsePitchInput(String input) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            result.add(input.charAt(index) - '0');
        }

        return result;
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
