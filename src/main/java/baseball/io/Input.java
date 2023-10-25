package baseball.io;
import baseball.model.Status;
import camp.nextstep.edu.missionutils.Console;


public class Input {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final Status status;

    public Input(Status status) {
        this.status = status;

    }

    public String readLine(){
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public void userChoice(){
        String userInput = Console.readLine();
        status.setStatus(userInput);
    }
}

