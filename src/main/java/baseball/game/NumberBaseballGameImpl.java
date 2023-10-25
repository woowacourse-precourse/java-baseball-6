package baseball.game;

import baseball.handleException.HandleException;
import baseball.gameMachine.GameMachineImpl;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGameImpl implements Game {


    public NumberBaseballGameImpl() {
    }

    @Override
    public void runGame() {
        giveOutputToMarchine(GameOutputText.STARTING_GAME);
        do {
            runGameLogic();
        } while (askForReGame());

    }

    private void runGameLogic() {
        List<Integer> gameNumList;
        int[] resultArray;
        String userNumber;

        gameNumList = generateComputerNumber();

        do {
            giveOutputToMarchine(GameOutputText.ASKING_USER_INPUT);
            userNumber = getTextFromMarchine();
            HandleException.exceptionHandlingForUserNumber(userNumber);
            List<Integer> userNumList = stringToList(userNumber);
            resultArray = compareComputerWithUser(userNumList, gameNumList);
            forwardResultToMarchine(resultArray);
        } while (!checkResult(resultArray));
    }

    @Override
    public void giveOutputToMarchine(String text) {
        GameMachineImpl.printText(text);
    }

    @Override
    public String getTextFromMarchine() {
        String input = GameMachineImpl.getTextFromUser();
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

    public static int[] compareComputerWithUser(List<Integer> computerNumList, List<Integer> userNumList) {
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

    private void forwardResultToMarchine(int[] resultArray) {
        int strikeNum = resultArray[0];
        int ballNum = resultArray[1];
        String resultString = null;
        if (ballNum != 0 && strikeNum == 0) {
            resultString = ballNum + GameOutputText.BALL + "\n";
        }
        if (ballNum == 0 && strikeNum != 0) {
            resultString = strikeNum + GameOutputText.STRIKE + "\n";
        }
        if (ballNum != 0 && strikeNum != 0) {
            resultString = ballNum + GameOutputText.BALL + " " + strikeNum + GameOutputText.STRIKE + "\n";
        }
        if (strikeNum == 0 && ballNum == 0) {
            resultString = GameOutputText.NOTHING + "\n";
        }
        giveOutputToMarchine(resultString);
    }

    private boolean checkResult(int[] resultArray) {
        //스트라이크 개수가 3개면 true리턴 아니면 false 리턴
        if (resultArray[0] == 3) {
            giveOutputToMarchine(GameOutputText.ENDING);
            return true;
        } else {
            return false;
        }
    }

    public boolean askForReGame() {
        giveOutputToMarchine(GameOutputText.ASKING_REGAME);
        String userInput = getTextFromMarchine();
        HandleException.exceptionHandlingForUserInput(userInput);
        int checkValue = Integer.parseInt(userInput);
        if (checkValue == 1) {
            return true;
        } else {
            return false;
        }
    }

}
