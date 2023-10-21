package baseball;
import camp.nextstep.edu.missionutils.Console;
public class User {
    private UserNumber userNumber;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void setUserNumber(){
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        this.userNumber = new UserNumber(input);
    }

    public String getUserNumber() {
        return userNumber.getUserNumber();
    }
}
