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
        if(userInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
        }
        for(char c: userInput.toCharArray()) {
            if(!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
            }
        }

        List<Integer> userNumber = UserInputUtil.convertStringToIntegerList(userInput);
    }
}
