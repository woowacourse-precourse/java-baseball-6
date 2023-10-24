package baseball;

import baseball.utils.RandomUtil;
import baseball.utils.UserInputUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {

    public void startGame() {
        List<Integer> computerNumber = RandomUtil.generateRandomNumber(3);
        int strike = 0;
        int ball = 0;

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
        for(int i=0; i<3; i++){
            String result = compareNumber(computerNumber, userNumber.get(i), i);

            if(result.equals("스트라이크")) {
                strike++;
            }else if(result.equals("볼")) {
                ball++;
            }
        }

        System.out.println(getHint(ball, strike));
    }

    private String compareNumber(List<Integer> computerNumber, int userInputValue, int index) {
        for(int i = 0; i < 3; i++) {
            if(computerNumber.contains(userInputValue) && i == index) {
                return "스트라이크";
            } else if(computerNumber.contains(userInputValue) && i != index) {
                return "볼";
            }
        }
        return "낫싱";
    }

    private String getHint(int ball, int strike) {
        String hint = "";

        if(strike == 0 && ball == 0) {
            hint = "낫싱";
        }

        if(ball > 0) {
            hint = ball + "볼 ";
        }

        if(strike > 0) {
            hint += strike + "스트라이크";
        }

        return hint;
    }
}
