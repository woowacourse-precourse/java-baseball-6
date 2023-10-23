package baseball;

import baseball.model.generateRandom;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        generateRandom random = new generateRandom();
        List<Integer> test_num = random.randomNumber();

        // #1. '랜덤 숫자 생성' 기능 확인
        System.out.println(test_num);
    }
}
