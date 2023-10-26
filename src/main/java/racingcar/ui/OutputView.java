package racingcar.ui;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {
    public static void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputAttemptMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printAttemptResultMessage() {
        System.out.println("실행 결과");
    }


    public static void printAttemptResult(List<RacingCar> racingCars) {
        for(RacingCar racingCar: racingCars) {
            String attemptResultString = racingCar.getName() + " : ";
            attemptResultString += "-".repeat(racingCar.getLocation());
            System.out.println(attemptResultString);
        }
        System.out.println();
    }

    public static void printGameResult(List<RacingCar> winners) {
        String result = "최종 우승자 : ";
        List<String> winnersName = new ArrayList<>();
        for(RacingCar winner: winners) {
            winnersName.add(winner.getName());
        }
        result += String.join(", ", winnersName);
        System.out.println(result);
    }
}
