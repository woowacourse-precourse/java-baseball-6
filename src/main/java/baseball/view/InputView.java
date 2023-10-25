package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private List<Integer> playerAnswer = new ArrayList<>();

    public List<Integer> inputPlayerNumbers() {
        playerAnswer.clear();
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();  //입력받기
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                playerAnswer.add(Character.getNumericValue(c));
            } else if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("1~9 사이의 숫자를입력하세요");
            }
        }
        return playerAnswer;
    }
}
