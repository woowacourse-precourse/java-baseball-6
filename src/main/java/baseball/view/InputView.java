package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.validateRestartOrExitChoice;
import static baseball.Application.validateUserThreeNumbers;

public final class InputView {

    private final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_END_AND_RESTART_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public List<Integer> readGameInput(){

        System.out.print(GAME_INPUT_MESSAGE);
        List<Integer> user = new ArrayList<>();
        String userThreeNumbers = Console.readLine();
        validateUserThreeNumbers(userThreeNumbers);
        for(char c: userThreeNumbers.toCharArray()){
            user.add(Character.getNumericValue(c));
        }
        return user;
    }

    public  boolean readGameControlInput(){//반환값이 1이면 restart
        System.out.print(GAME_END_AND_RESTART_MESSAGE);
        String choice = Console.readLine();
        return validateRestartOrExitChoice(choice);
    }
}
