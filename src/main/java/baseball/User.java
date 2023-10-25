package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    UserService service;

    public User(){
        service = new UserService();
    }

    public List<Integer> inputNumbers() throws IllegalArgumentException{

        List<Integer> numbers =
        Arrays.stream(Console.readLine().split("")).
                map(Integer::parseInt).
                collect(Collectors.toList());


        if(!service.isInputRight(numbers)){
            throw new IllegalArgumentException("잘못된 입력입니다");
        }

        return numbers;
    }
}
