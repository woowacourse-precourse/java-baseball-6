package baseball.deprecated;

import baseball.baseballgame.variables.Variables;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private int N = Variables.NUM.getValue();
    public List<Integer> create(String input){
        return input.chars()
                .mapToObj(ch -> Character.getNumericValue((char) ch))
                .collect(Collectors.toList());
    }
    public User createUser(String input){
        if (input.length() != N) {
            throw new IllegalArgumentException(N + "자리의 숫자를 입력해 주세요.");
        }

        return new User(create(input));
    }

}
