package baseball.game;

import baseball.domain.BaseBall;
import baseball.domain.Inning;
import baseball.domain.Pitch;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_SUCCESSFULLY_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";


    public void run() {
        System.out.println(GAME_START_MESSAGE);

        while (true) {
            // Pitch 생성 책임
            Pitch computer = initializeComputerPitch();
            Pitch player = resolveBaseBallsFromInput();

            // Inning - Pitch 관계 설정의 책임
            Inning inning = new Inning(computer, player);

            // 게임 결과 처리
            String result = inning.referee();
            System.out.println(result);

            if (inning.isAllStrike()) {
                break;
            }
        }
        System.out.println(GAME_SUCCESSFULLY_END_MESSAGE);
    }


    private Pitch initializeComputerPitch() {
        List<BaseBall> computerBaseBalls = new ArrayList<>();
        while (computerBaseBalls.size() < Inning.FULL_STRIKE_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(BaseBall.MIN_VALUE, BaseBall.MAX_VALUE);

            List<Integer> computerBaseBallValues = computerBaseBalls.stream().map(BaseBall::getValue).toList();
            if (!computerBaseBallValues.contains(randomNumber)) {
                computerBaseBalls.add(new BaseBall(randomNumber));
            }
        }
        return new Pitch(Inning.FULL_STRIKE_COUNT, computerBaseBalls);
    }

    private Pitch resolveBaseBallsFromInput() {
        System.out.print(INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();

        try {
            List<BaseBall> baseBalls = new ArrayList<>();
            for (String number : input.split("")) {
                int value = Integer.parseInt(number);
                BaseBall baseBall = new BaseBall(value);
                baseBalls.add(baseBall);
            }
            return new Pitch(Inning.FULL_STRIKE_COUNT, baseBalls);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


}
