package baseball;

import baseball.scenario.Scenario;
import baseball.scenario.Scenario.ScenarioResultType;

public class BaseballApplication {

    public void run() {
        gameStartScenario().play();
    }

    Scenario gameStartScenario() {
        return Scenario.create()
                .next(this::initializeComputer)
                .build(() -> {
                    System.out.println("게임 스타트");
                    return ScenarioResultType.NEXT;
                });
    }

    Scenario initializeComputer() {
        return Scenario.create()
                .next(this::initializeUser)
                .build(() -> {
                    System.out.println("컴퓨터 초기화");
                    return ScenarioResultType.NEXT;
                });
    }

    Scenario initializeUser() {
        return Scenario.create()
                .next(this::refereeScenario)
                .build(() -> {
                    System.out.println("사용자 초기화");
                    return ScenarioResultType.NEXT;
                });
    }

    Scenario refereeScenario() {
        return Scenario.create()
                .next(this::retryScenario)
                .build(() -> {
                    System.out.println("검사");
                    return ScenarioResultType.NEXT;
                });
    }

    Scenario retryScenario() {
        return Scenario.create()
                .previous(this::initializeComputer)  // 이 부분을 수정함
                .build(() -> {
                    System.out.println("리트라이");
                    return ScenarioResultType.NEXT;
                });
    }
}