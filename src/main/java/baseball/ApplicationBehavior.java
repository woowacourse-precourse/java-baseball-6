package baseball;

import java.util.List;

public interface ApplicationBehavior {

    List<Integer> generateRandomComputerNumber(); // 컴퓨터 입력값
    String checkNumber(List<Integer> computer, String str); // 사용자, 컴퓨터 입력값 비교
}
