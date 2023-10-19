package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }

    private InputView(){}

    public String printUserInput(){
        System.out.print(Message.User_Input.message);
        String input = Console.readLine();
        return input;
    }

    private enum Message{
        User_Input("숫자를 입력해주세요 : ");

        private String message;

        private Message(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }

    }
}
