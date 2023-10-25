package baseball.user;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class UserImpl implements User {
    @Override
    public String inputUserNumber() {
        String userInput;
        userInput = readLine();
        return userInput;
    }
}
