package baseball;

import baseball.BaseBallNumVerifier;
import baseball.ControlNumVerifier;
import baseball.Verifier;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public final class InputView {

    private final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_END_AND_RESTART_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private final Verifier baseballNumVerifier = new BaseBallNumVerifier();
    private final Verifier controlVerifier = new ControlNumVerifier();
    public List<Integer> readGameInput(){
        System.out.print(GAME_INPUT_MESSAGE);
        List<Integer> user = new ArrayList<>();
        String userThreeNumbers = Console.readLine();
        baseballNumVerifier.check(userThreeNumbers);
        userThreeNumbers.chars()
                .mapToObj(Character::getNumericValue)
                .forEach(user::add);
        return user;
    }

    public int readGameControlInput(){
        System.out.print(GAME_END_AND_RESTART_MESSAGE);
        String choice = Console.readLine();
        controlVerifier.check(choice);
        return Integer.parseInt(choice);
    }
}
