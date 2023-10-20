package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputReader {
    InputReader(){}

    String readNumber(){
        String userInputNumber = readLine();
        if (userInputNumber.length() != 3){
            throw new IllegalArgumentException();
        }
        for (int inputNumberIndex = 0; inputNumberIndex < userInputNumber.length(); inputNumberIndex++){
            if (!Character.isDigit(userInputNumber.charAt(inputNumberIndex))){
                throw new IllegalArgumentException();
            }
        }
        return userInputNumber;
    }

    String readRestartNumber(){
        String restartNumber = readLine();
        if (restartNumber.length() != 1){
            throw new IllegalArgumentException();
        }
        if (!restartNumber.equals("1") && !restartNumber.equals("2")){
            throw new IllegalArgumentException();
        }
        return restartNumber;
    }
}
