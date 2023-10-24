package baseball.computer;

import java.util.List;

public interface Computer {
    //한 게임을 실행하는 기능
    public boolean play();

    //랜덤하게 숫자 생성하는 기능
    public void generateNumber();

    //잘못된 값 입력시 예외를 반환하고 종료하는 기능
    //* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    public List<Integer> checkInputFormat(String guessString);

    //입력한 숫자를 사용해 결과를 반환하는 기능
    public boolean checkGuess(List<Integer> guessNumber);

    //정답을 맞췄을 시 사용자의 입력을 받아 재시작을 확인하는 기능
    public boolean checkReplay(String replayNumberString);
}
