package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String inputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String numbers=readLine();

        return numbers;
    }
}
