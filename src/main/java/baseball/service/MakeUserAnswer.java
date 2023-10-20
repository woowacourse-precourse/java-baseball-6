package baseball.service;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. input() : 사용자의 입력 받기
 */
public class MakeUserAnswer {
    private final UserValidation userValidation;

    public MakeUserAnswer(UserValidation userValidation) {
        this.userValidation = userValidation;
    }

    public User input() {
        String userInputString = Console.readLine();
        int userInput = userValidation.validate(userInputString);

        List<Integer> user = new ArrayList<>();
        user.add(userInput / 100);
        int ten = userInput % 100;
        user.add(ten / 10);
        user.add(ten % 10);
        
        return User.createUser(user);
    }
}