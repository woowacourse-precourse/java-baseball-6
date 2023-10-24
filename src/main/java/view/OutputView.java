package view;

import domain.Computer;
import java.util.Map;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = Computer.LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(Map<String, Integer> result) {
        if (result.get("ball") > 0) {
            System.out.print(result.get("ball") + "볼 ");
        }
        if (result.get("strike") > 0) {
            System.out.print(result.get("strike") + "스트라이크");
        }
        if (result.get("ball") == 0 && result.get("strike") == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }
}