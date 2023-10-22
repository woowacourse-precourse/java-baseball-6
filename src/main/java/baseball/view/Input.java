package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String inputNumber(){
        String number;
        try {
            number = Console.readLine();
            int num = Integer.parseInt(number);
            if(number.length()!=3 || num<123 || num>987){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException = new IllegalArgumentException("잘못입력 게임 종료");
            throw illegalArgumentException;
        }
        return number;
    }

    public int inputContinue(){
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
            if(number!=1 && number!=2){
                throw new IllegalArgumentException("잘못입력 게임 종료");
            }
        }catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
        return number;
    }
}
