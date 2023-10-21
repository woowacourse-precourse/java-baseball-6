package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {
    public String callNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
