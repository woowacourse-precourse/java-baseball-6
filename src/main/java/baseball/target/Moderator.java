package baseball.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 게임 진행자가 하는 일을 다루는 클래스
 */
public class Moderator {

    public void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public List<Integer> getList(String userInput) {
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }

    public void validateUserNum(List<Integer> userNumbers) {
        if (userNumbers.size() != 3) {
            throw new IllegalArgumentException("세자리의 숫자를 입력해 주세요.");
        }
        if (userNumbers.contains(0)) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력할 수 있습니다.");
        }
        for (int i = 0; i < userNumbers.size(); i++) {
            if (Collections.frequency(userNumbers, userNumbers.get(i)) != 1) {
                throw new IllegalArgumentException("숫자가 중복될 수 없습니다.");
            }
        }
    }


}
