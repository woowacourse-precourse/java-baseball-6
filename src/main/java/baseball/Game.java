package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    Boolean answer = true;
    ArrayList<Integer> computerInputArray = new ArrayList<>();

    public void Start() {
        // 게임을 시작합니다.
        computerInputArray = Computer.getRandomNumber();
        System.out.println(computerInputArray);

        while (answer) {
            Alert.userInputStartMessage();
            ArrayList<Integer> userInputArray = User.getNumber();

            if (Judge.judge(userInputArray, computerInputArray).equals("Strike")) {
                Alert.gameFinishMessage();
                answer = false;
            }

        }
    }

    public static boolean reStart() {
        // "메세지 다시 시작하시겠습니까?"
        String re = Console.readLine();
        if (re.equals("1")) {
            return true;
        } else if (re.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 숫자 입력");
        }
    }

}
