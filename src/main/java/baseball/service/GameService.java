package baseball.service;

import baseball.util.ComputerUtil;

import java.util.List;

public class GameService {

    private static List<Integer> computerNumber;

    /*
     * 게임 초기설정 메서드
     * @Param input 플레이어의 숫자
     * */
    public static void setGame() {
        computerNumber = ComputerUtil.generateComputerNumber();
    }
}
