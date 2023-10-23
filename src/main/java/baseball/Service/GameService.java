package baseball.Service;

import baseball.Computer;
import baseball.User;
import baseball.Utils.Converter;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();

    private Converter converter = new Converter();
    public void playContinuous(){
        while (true){

        }
    }
    public void play(){

    }

    public void setGame() {
        computer.generateNumber();
        OutputMessage.printStartMessage();
    }

    private void getUserNumber() {
        InputMessage.printUserInputMessage();
        String input = Console.readLine();
        user.setInputNumber(converter.convertUserInputToInt(input));
    }
}
