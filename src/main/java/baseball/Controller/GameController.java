package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Scanner scanner = new Scanner(System.in);

    public void gameStart() {
        boolean continueGame = true;

        do {
            outputView.printStartMessage();
            Computer computer = setComputerNumber();

            guess(computer);

            continueGame = askUser();
        } while(continueGame);

        outputView.printEndMessage();
    }

    boolean askUser() {
        inputView.printRetryMessage();
        String input = scanner.nextLine();

        if(!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력이 1 또는 2가 아닙니다.");
        }

        if(input.equals("1")) return true;
        return false;
    }

    void guess(Computer computer) {
        boolean success = false;

        do {
            inputView.printInputMessage();
            User user = setUserNumber();

            int ball = ballCount(computer, user);
            int strike = strikeCount(computer, user);

            outputView.resultMessage(ball, strike);

            if(strike == 3) success = true;
        } while(!success);

        outputView.successMessage();
    }

    int ballCount(Computer computer, User user) {
        int result = 0;
        for(int i=0; i<3; i++){
            if(computer.getAnswer().get(i) != user.getInput().get(i)
            && computer.getAnswer().contains(user.getInput().get(i))){
                result += 1;
            }
        }
        return result;
    }

    int strikeCount(Computer computer, User user) {
        int result = 0;
        for(int i=0; i<3; i++){
            if(computer.getAnswer().get(i) == user.getInput().get(i)){
                result += 1;
            }
        }
        return result;
    }

    User setUserNumber() {
        String input = scanner.nextLine();

        String regexPattern = "^[0-9]{3}$";
        if(!input.matches(regexPattern)){
            throw new IllegalArgumentException("입력이 3자리 정수가 아닙니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int num = Integer.parseInt(input.substring(i, i + 1));
            if (numbers.contains(num)) {
                throw new IllegalArgumentException("입력에 중복된 숫자가 존재합니다.");
            }
            numbers.add(num);
        }

        return new User(numbers);
    }

    Computer setComputerNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return new Computer(list);
    }
}