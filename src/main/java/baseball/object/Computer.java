package baseball.object;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    //  TODO(2) - 사용자의 입력을 받아, 맞는 입력인지 검사하기
    public List<Integer> checkUserNum(String userNum) {
        final String REGEX = "[1-9]+";

        if (userNum.length() != 3) { // 3자리수가 아닌경우,
            throw new IllegalArgumentException();
        }

        if (!userNum.matches(REGEX)){ // 1-9로 만들어진 숫자가 아닌경우
            throw new IllegalArgumentException("1-9로 만들어진 숫자가 아닙니다.");
        }

        if (!checkDifferentNum(userNum)) { // 유저가 입력한 각 자리 숫자가 달라야 함 // TODO - 요구사항 확인
            throw new IllegalArgumentException("유저가 입력한 숫자는 서로 다른 3자리 숫자여야 합니다.");
        }

        return userNum.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    // TODO(1) - 1-9 까지의 서로 다른 숫자로 이루어진 3자리 수 만들기
    public List<Integer> makeRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }



    // 유저가 입력한 숫자가 서로 다른 세자리 수가 맞는지 확인
    private boolean checkDifferentNum(String userNum) {
        Set<Character> charSet = new HashSet<>();
        for (char c : userNum.toCharArray()) {
            charSet.add(c);
        }
        return charSet.size() == userNum.length();
    }
}
