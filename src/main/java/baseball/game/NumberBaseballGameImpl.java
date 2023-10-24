package baseball.game;

import baseball.gameMachine.GameMachineImpl;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGameImpl implements Game{
    private final String startingGame = "숫자 야구 게임을 시작합니다.\n";
    private static final String askingUserInput = "숫자를 입력해주세요 : ";
    private final String ending = "3개의 숫자를 모두 맞히셨습니다! 게임 종료/n";

    public NumberBaseballGameImpl() {

    }

    @Override
    public void runGame()  {
        List<Integer> gameNumList;
        int[] resultArray;
        
        forwardText(startingGame);
        gameNumList = generateComputerNumber();
        String userNumber;
        do {
            forwardText(askingUserInput);
            userNumber = askForInput();
            HandleGameException.askingUserInputException(userNumber);
            List<Integer> userNumList = stringToList(userNumber);
            resultArray = compare(userNumList, gameNumList);
            printResult(resultArray);
        } while (!checkResult(resultArray));
    }

    @Override
    public void forwardText(String text) {
        GameMachineImpl.printText(text);
    }

    @Override
    public String askForInput() {
        String input = GameMachineImpl.getInput();
        return input;
    }

    public static List<Integer> generateComputerNumber() {
        List<Integer> computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }

        return computerNumList;
    }

    public static int[] compare(List<Integer> computerNumList, List<Integer> userNumList) {
        //변수 선언
        // resultArray의 인덱스 0은 stikeNum을 위한 자리, 인덱스 1은 ballNum을 위한 자리이다.
        int[] resultArray;
        int strikeNum = 0;
        int ballNum = 0;
        int[] userNumberCheckArray = new int[10];
        int[] computerNumberCheckArray = new int[10];

        //스트라이크 개수 체크
        for (int i = 0; i < computerNumList.size(); i++) {
            userNumberCheckArray[userNumList.get(i)] = userNumberCheckArray[userNumList.get(i)] + 1;
            computerNumberCheckArray[computerNumList.get(i)] = computerNumberCheckArray[computerNumList.get(i)] + 1;
            if (computerNumList.get(i) == userNumList.get(i)) {
                strikeNum++;
            }
        }

        //볼 개수 체크
        for (int i = 0; i < userNumberCheckArray.length; i++) {
            if ((userNumberCheckArray[i] == computerNumberCheckArray[i]) && computerNumberCheckArray[i] != 0) {
                ballNum++;
            }

        }
        ballNum = ballNum - strikeNum;

        //배열에 저장
        resultArray = new int[]{strikeNum, ballNum};
        //반환
        return resultArray;
    }

    private List<Integer> stringToList(String text) {
        List<Integer> userNumList = new ArrayList<>();
        for (String s : text.split("")) {
            userNumList.add(Integer.parseInt(s));
        }

        return userNumList;
    }

    private void printResult(int[] resultArray) {
        int strikeNum = resultArray[0];
        int ballNum = resultArray[1];
        String resultString = null;
        if (ballNum != 0 && strikeNum == 0) {
            resultString = ballNum + "볼\n";
        }
        if (ballNum == 0 && strikeNum != 0) {
            resultString = strikeNum + "스트라이크\n";
        }
        if (ballNum != 0 && strikeNum != 0) {
            resultString = ballNum + "볼 " + strikeNum + "스트라이크\n";
        }
        if (strikeNum == 0 && ballNum == 0) {
            resultString = "낫싱\n";
        }
        forwardText(resultString);
    }
    private boolean checkResult(int[] resultArray) {
        //스트라이크 개수가 3개면 true리턴 아니면 false 리턴
        if (resultArray[0] == 3) {
            forwardText(ending);
            return true;
        } else {
            return false;
        }
    }

}
