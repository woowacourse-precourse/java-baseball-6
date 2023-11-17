package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {
    }

    public static String inputNumber(){
        return Console.readLine();
    }
}
