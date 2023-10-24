package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final int NUMBER_LENGTH = 3;
    private final Computer computer;

    public GameManager(Computer computer) {
        this.computer = computer;
    }

    // 이 메소드를 실행하면 게임을 시작합니다.
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            boolean isGameEnd = playerTurn();
            if (!isGameEnd) continue;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (!isRetry(input)) break; // TODO
            computer.setNumber();
        }
    }

    // 플레이어 턴일때 해야하는 일을 순차적으로 처리해줍니다.
    private boolean playerTurn() {
        List<Integer> input = getExpectNumberInput();
        int strike = computer.getStrikeCount(input);
        int ball = computer.getBallCount(input);
        System.out.println(getResultString(strike, ball));
        return isEnd(strike);
    }

    // strike와 ball 개수를 받아 출력해야하는 문자열을 만들어 반환합니다.
    private String getResultString(int strike, int ball) {
        if (strike+ball == 0) {
            return "낫싱";
        }
        String ballString = ball > 0 ? ball + "볼 " : "";
        String strikeString = strike > 0 ? strike + "스트라이크" : "";
        return (ballString + strikeString).strip();
    }

    // 유저에게서 입력을 받는 메소드입니다.
    private List<Integer> getExpectNumberInput() {
        System.out.print("숫자를 입력 해 주세요 : ");
        String input = Console.readLine();
        Validation.validate(input);
        return toIntegerList(input);
    }

    // 입력받은 문자열을 ArrayList<Integer>로 만들어 반환합니다.
    // 이 메소드를 호출하는 시점엔 입력 검증이 모두 끝났기에 항상 유효한 반환을 해줍니다.
    private List<Integer> toIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            result.add(input.charAt(i)-'0');
        }
        return result;
    }

    // strike의 개수를 받아 게임이 끝났는지 판단해줍니다.
    public boolean isEnd(int strike) {
        return strike == NUMBER_LENGTH;
    }
}
