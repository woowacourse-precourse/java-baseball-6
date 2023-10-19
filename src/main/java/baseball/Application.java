package baseball;

import baseball.RandomNumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> computer = randomNumberGenerator.generateRandomNumber();
        
    }
}
