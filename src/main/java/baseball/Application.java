package baseball;

import baseball.domain.BaseBallNumber;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }

    public void run(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        List<Integer> userInput = stringToList(Console.readLine());

        BaseBallNumber computerNumber = new BaseBallNumber(computer);
        BaseBallNumber userNumber = new BaseBallNumber(userInput);

        BaseballService baseballService = new BaseballService(computerNumber);
        Integer[] ballAndStrike = baseballService.checkBallAndStrike(userNumber);

        for(Integer i: computer){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(ballAndStrike[0] + " Balls, " + ballAndStrike[1] + " Strikes");
    }
    public List<Integer> stringToList(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = Character.getNumericValue(c);
            result.add(digit);
        }

        return result;
    }
}
