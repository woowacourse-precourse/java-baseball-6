package baseball;

import java.util.List;

public class BaseBallGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public BaseBallGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        // todo: 시작 문구 출력하기
        List<Integer> randomNumbers = randomNumberGenerator.createNumber(3);

        // todo: 입력문구 출력하기
        // todo: 사용자 입력 받기
        // todo: 사용자 입력 검증하기
        // todo: 난수와 사용자 입력 판별하기
        // todo: 결과 출력하기
        // todo:
        //  - 난수와 사용자 입력을 맞을 경우 재시작 | 시스템 종료 문구 출력 및 입력받기
        //  - 재입력받기
    }
}