package baseball;

import camp.nextstep.edu.missionutils.Console;
/*  -> (1) 상대방의 수 만들기: generateComputerNumber() OK,
    -> (2) 사용자의 입력을 받는 기능: inputUserNumber() OK,
        2-1) 스트라이크인지 확인하는 기능 isStrike(), OK
        2-2) 볼인지 확인하는 기능 isBall(), OK
        2-3) 결과를 출력하는 기능 outputResult()
    -> (3) 게임을 시작하고 종료하는 기능 startEndGame(),
        3-1) 종료 후 재시작 여부를 확인하는 기능 isRestart() OK
    -> (4) 사용자의 입력이 숫자인지 확인하는 기능 isDigit() OK,
        4-1) 사용자의 입력이 3자리 숫자인지 확인하는 기능 isThree() OK,
        4-2) 사용자가 입력한 숫자 중 동일한 숫자가 없는지 확인하는 기능
             isDupilcate() OK */
public class GamePlay {
    String userString = "";

    public String getUserString() {
        return userString;
    }

    public void setUserString(String userString) {
        this.userString = userString;
    }

    public void inputUserString() {
        System.out.print("숫자를 입력해주세요 : ");
        setUserString(Console.readLine());
    }
}
