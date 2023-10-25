package baseball.service;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class BaseBallGameService {
    private InputErrorCheckService inputErrorCheckService;
    private GameResultReturnService gameResultReturnService;
    public BaseBallGameService(){
        inputErrorCheckService = new InputErrorCheckService();
        gameResultReturnService = new GameResultReturnService();
    }

    //한턴 게임
    public void playOneGame(List<Integer> computerNum) {
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            //유저 Input 받고, 숫자 리스트 만들기
            List<Integer> userNum = getUserNum(getUserInputNum());
            //입력받은 숫자로 결과 반환
            String gameResult = getResult(computerNum, userNum);
            //게임 종료 확인
            if (checkGameComplete(gameResult)) break;
        }
    }

    //게임 끝났는지 확인
    private static boolean checkGameComplete(String gameResult) {
        if (gameResult.equals("3스트라이크")){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    //유저 Input Number List로 컴퓨터 숫자와 비교해서 결과 확인
    public String getResult(List<Integer> computerNum, List<Integer> userNum) {
        String command;
        command = gameResultReturnService.gameResult(userNum, computerNum);
        System.out.println(command);
        return command;
    }

    //유저의 Input을 기반으로 UserInputList를 만든다
    public List<Integer> getUserNum(String userInputNum) {
        List<Integer> userNum = new ArrayList<>();
        for (char c : userInputNum.toCharArray()) userNum.add(Character.getNumericValue(c));
        return userNum;
    }

    //유저의 Input을 String으로 받고, input을 체크한다
    public String getUserInputNum() {
        String userInputNum = Console.readLine();
        if (!inputErrorCheckService.errorCheck(userInputNum)) throw new IllegalArgumentException();
        return userInputNum;
    }


    public Boolean endCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reGameCheck = Console.readLine();
        inputErrorCheckService.restartInputErrCheck(reGameCheck);
        //1을 선택하면 게임 종료 아니니 False, 2를 선택시에는 게임 끝이니 True 반환
        return (reGameCheck.equals("1"))? Boolean.FALSE : Boolean.TRUE;
    }


}
