package baseball.service;

import java.util.List;

public interface BullsAndCowsService {

    // 컴퓨터 랜덤값 3자리 생성값 반환
    List<Integer> createComputerRandomValue();

    // 사용자 추측값 3자리 입력값 반환
    List<Integer> getThreeDigits();

    // 게임 종료 여부 값 반환
    boolean isGameRunning();

    // 컴퓨터 랜덤값, 사용자 추측값 비교
    boolean compareUserGuessWithRandom(List<Integer> computer, List<Integer> user);
}
