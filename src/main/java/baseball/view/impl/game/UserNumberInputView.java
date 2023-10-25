package baseball.view.impl.game;

import baseball.model.UserBallNumbers;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class UserNumberInputView implements InputView<UserBallNumbers> {
    @Override
    public UserBallNumbers getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return UserBallNumbers.of(input);
    }
}
