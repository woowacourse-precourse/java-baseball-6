package baseball;

import baseball.utils.RandomUtil;
import baseball.utils.UserInputUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {

    public void startGame() {
        List<Integer> computerNumber = RandomUtil.generateRandomNumber(3);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        List<Integer> userNumber = UserInputUtil.convertStringToIntegerList(userInput);
    }
}
