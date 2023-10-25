package baseball.view;
import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    InputException inputException;
    public Input(){
        inputException = new InputException();
    }
    public String inputNumber(){
        String number;
        number = Console.readLine();
        if(!inputException.isThree(number) || !inputException.isToInt(number) ||
                !inputException.isRange(number) || inputException.isContainZero(number) ||
                inputException.isContainSameNum(number)){
            throw new IllegalArgumentException("게임 종료");
        }
        return number;
    }

    public int inputContinue(){
        int number;
        number = Integer.parseInt(Console.readLine());
        if(inputException.inputContinue(number)){
                return number;
        }
        throw new IllegalArgumentException("게임종료");
    }
}
