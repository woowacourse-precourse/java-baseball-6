package baseball.Controller;

import baseball.Utils.ExceptionProcess;
import baseball.Utils.GameMessage;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class StartGame {

    public void start() {
        Boolean enter;
        InputContrast inputComparator = new InputContrast();
        List<Integer> computer = computerSetting();
        do {
            enter = inputComparator.contrastList(computer, userSetting());
        } while (enter);
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
        ExceptionProcess exceptionProcess = new ExceptionProcess();
        // UserInputData
        List<Integer> user = new ArrayList<>();
        while (user.size() < 3) {
            System.out.print(GameMessage.INPUT);
            String input = Console.readLine();
            exceptionProcess.allUserException(input); // 예외 처리 코드
            String[] userInput = input.split("");
            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(userInput[i]);
                user.add(num);
            }
        }
        return user;
    }

    public void reStart() {
        start();
    }
}
