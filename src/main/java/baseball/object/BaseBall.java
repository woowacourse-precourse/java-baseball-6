package baseball.object;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {
    public void start() {
        Computer computer = new Computer();
        List<Integer> computerNum = computer.makeRandomNumbers();
        List<Integer> userNumList;

        while (true) {
            greeting();
            String userNum = readLine();
            userNumList = checkUserNum(userNum); // 맞는 숫자인지 확인
            int[] result = ismatch(computerNum, userNumList);

            if (result[1] == 3) {
                userNum = askNewGame();
                if (!checkTryAgain(userNum)) {
                    return;
                }
                computerNum = computer.makeRandomNumbers();
            }
            else {
                printResult(result);
            }

        }
    }

    private void greeting(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String askNewGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

    private void printResult(int[] result) {
        String resultContent = "";
        if (result[0]!= 0) {
            resultContent += result[0] +"볼 ";
        }
        if (result[1]!=0) {
            resultContent += result[1] + "스트라이크";
        }
        if (result[2]!=0) {
            resultContent = "낫싱";
        }
        System.out.println(resultContent);
    }


    // - 사용자의 입력을 받아, 게임 한번 더 할건지 물어보는 것에 대한 맞는 입력인지 검사하기
    private boolean checkTryAgain(String userNum) { // 한번 더 할건지
        final String REGEX = "[1-2]+";
        if (userNum.length() != 1) { // 3자리수가 아닌경우,
            throw new IllegalArgumentException();
        }
        if (!userNum.matches(REGEX)){ // 1-9로 만들어진 숫자가 아닌경우
            throw new IllegalArgumentException("1-9로 만들어진 숫자가 아닙니다.");
        }

        return Integer.parseInt(userNum) == 1;
    }



    // - 사용자의 입력과 컴퓨터의 입력을 검사하기
    private int[] ismatch(List<Integer> computerNum, List<Integer> userNum) {
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



    //  - 사용자의 입력을 받아, 맞는 입력인지 검사하기
    private List<Integer> checkUserNum(String userNum) {
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

    // - 유저가 입력한 숫자가 서로 다른 세자리 수가 맞는지 확인
    private boolean checkDifferentNum(String userNum) {
        Set<Character> charSet = new HashSet<>();
        for (char c : userNum.toCharArray()) {
            charSet.add(c);
        }
        return charSet.size() == userNum.length();
    }

}
