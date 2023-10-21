package baseball.service;

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

}
