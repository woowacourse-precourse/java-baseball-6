package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumGame {
    public static final String GameStartStr = "Game Start ! -> ";
    public static final String GameOverStr = "New Game : 1, Exit : 2";
    private static final String InsertMsg = " 세자리 숫자를 입력 하십시오 : ";
    void startGame() {
        System.out.printf(GameStartStr);
        boolean bGame = true;
        while (bGame) {
            BaseballResult BaseballResult = new BaseballResult();
            bGame = startInning(BaseballResult);
        }
    }
    private static boolean startInning(BaseballResult BaseballResult) {

        while (!BaseballResult.bCorrect()) {
            List<Integer> pitchBall;
            String inputBall;

            System.out.println(InsertMsg);
            inputBall = camp.nextstep.edu.missionutils.Console.readLine();
            pitchBall = choiceBall(inputBall);
            BaseballResult.pitch(pitchBall);
        }
        System.out.printf(GameOverStr);
        return choiceUser();
    }

    private static boolean choiceUser() {
        String userChoice = camp.nextstep.edu.missionutils.Console.readLine();

        if (userChoice.equals("1")) {
            return true;
        }
        if (userChoice.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력 입니다..");
    }

    private static List<Integer> choiceBall(String inputBall) {
        List<Integer> maybe = new ArrayList<>();

        if (inputBall.length() != 3) {
            throw new IllegalArgumentException("값의 길이가 3이 아닙니다");
        }
        for (int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(inputBall.charAt(i));
            if (!maybe.contains(number)) {
                maybe.add(number);
            } else {
                throw new IllegalArgumentException("잘못된 선택입니다.");
            }
        }
        return maybe;
    }
}