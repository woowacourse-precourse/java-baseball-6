package baseball.model;
import baseball.util.Result;
import java.util.List;
import baseball.vailidation.NumberValidator;

public class NumberComparator {

    public static Result compareNumber(List<Integer> computer, List<String> user){

        int strike = 0, ball = 0;
        for (int i = 0; i < user.size(); i++) {
            int number = NumberValidator.parseAndVaiidateInput(user.get(i));
            if (computer.get(i) == number) {
                strike++;
                continue;
            } else if (computer.contains(number)) {
                ball++;
            }
        }


        return new Result(strike, ball);
    }
}
