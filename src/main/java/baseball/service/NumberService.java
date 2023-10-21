package baseball.service;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class NumberService {
    private static final String INPUT_ERROR_MESSAGE = "서로 다른 정수 3개를 입력해주세요 1<= N <= 9";

    public Number generate(){
        Number computer = new Number();
        while (computer.size() < Number.getGameSize()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Number toNumber(String userInput){
        Number user = new Number();
        if (validateInput(userInput)) {
            userInput.chars()
                    .map(Character::getNumericValue).forEach(user::add);
            return user;
        } else{
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public boolean validateInput(String userInput){
        HashSet<Character> set = new HashSet<>();

        if (userInput.length() != Number.getGameSize()) {
            return false;
        }

        for (int i=0;i<userInput.length();i++) {
            char ch = userInput.charAt(i);
            if (ch < '1' || ch > '9') {
                return false;
            }
            set.add(ch);
        }

        return set.size() == Number.getGameSize();
    }
}
