package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    public static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 :";


    void playBall() {
        System.out.printf(GAME_START_MSG);
        boolean isGaming = true;
        while (isGaming) {
            Umpire umpire = new Umpire();
            isGaming = startInning(umpire);
        }
    }

    private static boolean startInning(Umpire umpire) {

        while (!Umpire.isCorrect()) {
            List<Integer> pitchBall;
            String input;

            System.out.println(INPUT_MSG);
            input = camp.nextstep.edu.missionutils.Console.readLine();
            pitchBall = choicePitchBall(input);
            umpire.pitch(pitchBall);

        }
        System.out.printf(GAME_OVER_MSG);
        return choicePlayGameToUser();
    }

    private static boolean choicePlayGameToUser() {
        String userChoice = camp.nextstep.edu.missionutils.Console.readLine();

        if (userChoice.equals("1")) {
            return true;
        }
        if (userChoice.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력 입니다.");
    }

    private static List<Integer> choicePitchBall(String input) {
        //입력값 컨버젼
        List<Integer> guess = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("값의 크기가 3이 아닙니다");
        }
        for (int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(input.charAt(i));
            if (!guess.contains(number)) {
                guess.add(number);
            } else {
                throw new IllegalArgumentException("올바른 선택지가 아닙니다");
            }
        }
        return guess;
    }
}
