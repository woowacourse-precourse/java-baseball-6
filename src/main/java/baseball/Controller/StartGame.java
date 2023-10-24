package baseball.Controller;

import baseball.Utils.GameMessage;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.Utils.ExceptionProcess.duplicateNumberException;
import static baseball.Utils.ExceptionProcess.inputLengthExceededException;

public class StartGame {

    public void start() {
        Boolean enter;
        InputContrast inputComparator = new InputContrast();
        List<Integer> computer = computerSetting();
        do {
            enter = inputComparator.contrastList(computer, userSetting());
        }while(enter);
    }

    public List<Integer> computerSetting() {
        // ComputerPutData
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> userSetting() {
        // UserInputData
        List<Integer> user = new ArrayList<>();
        while (user.size() < 3) {
            System.out.print(GameMessage.INPUT);
            String[] userInput = Console.readLine().split("");
            if(userInput.length > 3) inputLengthExceededException(); // 숫자 3개 초과
            else {
                for (int i = 0; i < 3; i++) {
                    int num = Integer.parseInt(userInput[i]);
                    if (user.contains(num)) {
                        duplicateNumberException(); // 중복숫자 예외처리
                    } else {
                        user.add(num);
                    }
                }
            }
        }
        return user;
    }

    public void reStart() {
        start();
    }
}
