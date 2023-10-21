package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.println();

        ArrayList<Integer> computerNumList = RandomNumber.randomNumber();

        ArrayList<Integer> userNumList = UserInput.userInput();

        Assessment.assessment(computerNumList, userNumList);
    }

}
