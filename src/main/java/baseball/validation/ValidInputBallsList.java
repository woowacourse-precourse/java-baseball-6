package baseball.validation;
import baseball.error.ErrorHandlerForInputBalls;
import baseball.error.ErrorHandler;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class ValidInputBallsList {
    ErrorHandler errorHandle = new ErrorHandlerForInputBalls();
    public List<Integer> createInputBallsList() {
        List<Integer> validBallsList = new ArrayList<>();
        String numbersString = readLine();
        try {
            errorHandle.checkString(numbersString);
        }
        catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
        String[] numberStringArray = numbersString.split("");
        for(String numberString : numberStringArray){
            validBallsList.add(Integer.parseInt(numberString));
        }
        return validBallsList;
    }
}
