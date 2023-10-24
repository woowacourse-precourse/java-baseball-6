package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseBallGame {

    private Map<Integer, Integer> computerMap;
    private List<Integer> userNumList;
    private int strikeCnt;
    private int ballCnt;
    private final boolean GAME_CONTINUE = true;
    private final boolean GAME_EXIT = false;


    public void run(){
        printMessageAs(MessageType.GAME_BEGIN);
        do {
            play();
        } while (chooseNextStep());
    }

    private void play(){
        initComputer();
        while (true){
            inputUser();
            compare();
            boolean isGameEnd = showResult();
            if(isGameEnd){
                break;
            }
        }
    }

    private void initComputer(){
        computerMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            computerMap.put(i, 0);
        }

        int storedCnt = 0;
        while (storedCnt < 3){
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computerMap.get(randomNum) == 0){
                storedCnt++;
                computerMap.put(randomNum, storedCnt);
            }
        }
    }

    private void inputUser(){
        printMessageAs(MessageType.INPUT_USER_NUM);

        try {
        userNumList = Arrays.stream(Console.readLine().replaceAll(" ", "").split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        checkValidUserInputs();

        } catch (NumberFormatException exception){
            throw new IllegalArgumentException("숫자 이외의 값을 입력하여 게임을 종료합니다.");
        }
    }

    private void checkValidUserInputs(){
        if(userNumList.size() != 3){
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자 3개를 입력하지 않아 게임을 종료합니다.");
        }
    }

    private void compare(){
        strikeCnt = 0;
        ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerMap.get(userNumList.get(i)) == i + 1) {
                strikeCnt++;
            } else if (computerMap.get(userNumList.get(i)) != 0) {
                ballCnt++;
            }
        }
    }

    private boolean showResult(){
        boolean isGameEndFlag = false;
        if (strikeCnt == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGameEndFlag = true;
        } else if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else {
            String result = "";
            if (ballCnt > 0) {
                result += ballCnt + "볼 ";
            }
            if (strikeCnt > 0) {
                result += strikeCnt + "스트라이크 ";
            }
            System.out.println(result);
        }
        return isGameEndFlag;
    }

    private void printMessageAs(MessageType messageType){
        System.out.println(messageType.getMessageDetail());
    }

    private boolean chooseNextStep(){
        printMessageAs(MessageType.CHOOSE_NEXT_OR_END);

        String userChoice = Console.readLine();
        boolean isGameContinue = switch (userChoice){
            case "1" -> GAME_CONTINUE;
            case "2" -> { printMessageAs(MessageType.GAME_EXIT); yield GAME_EXIT; }
            default -> throw new IllegalArgumentException("선택지에 없는 값을 입력하여 게임을 종료합니다.");
        };

        return isGameContinue;
    }

}
