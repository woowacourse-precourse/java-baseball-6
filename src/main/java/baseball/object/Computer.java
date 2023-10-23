package baseball.object;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    //  TODO(5) - 사용자의 입력을 받아, 게임 한번 더 할건지 물어보는 것에 대한 맞는 입력인지 검사하기
    public boolean checkTryAgain(String userNum) { // 한번 더 할건지
        final String REGEX = "[1-2]+";
        if (userNum.length() != 1) { // 3자리수가 아닌경우,
            throw new IllegalArgumentException();
        }
        if (!userNum.matches(REGEX)){ // 1-9로 만들어진 숫자가 아닌경우
            throw new IllegalArgumentException("1-9로 만들어진 숫자가 아닙니다.");
        }

        return Integer.parseInt(userNum) == 1;
    }


    //  TODO(4) - 사용자의 입력과 컴퓨터의 입력을 검사하기
    public int[] ismatch(List<Integer> computerNum, List<Integer> userNum) {
        int[] resultList = new int[3];
        int strikeCount = 0;
        int ballCount = 0;
        int nothingCount = 0;

        for (int index = 0 ; index<3 ; index++) {
            if (Objects.equals(computerNum.get(index), userNum.get(index))) {
                strikeCount +=1;
            } else if (computerNum.contains(userNum.get(index))) {
                ballCount +=1;
            }
        }
        if (strikeCount+ballCount ==0 ){
            nothingCount+=1;
        }
        resultList[0] = ballCount;
        resultList[1] = strikeCount;
        resultList[2] = nothingCount;

        return resultList;
    }

    //  TODO(2, 3) - 사용자의 입력을 받아, 맞는 입력인지 검사하기
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
