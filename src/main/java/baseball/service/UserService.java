package baseball.service;
import camp.nextstep.edu.missionutils.Console;
public class UserService {
    public int inputUserNumber(){
        String inputNumber = Console.readLine();
        int userNumber = Integer.parseInt(inputNumber);

        System.out.println(userNumber);
        return userNumber;
    }
}
