package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service {

    public List<Integer> makeNumber(){

        return IntStream.range(0,3)
                .mapToObj(i->Randoms.pickNumberInRange(1, 9))
                .toList();
    }

    public List<Integer> readNumber(){
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 문자열의 길이는 3이어야 합니다.");
        }

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

}
