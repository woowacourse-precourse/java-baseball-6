package baseball.controller;

import baseball.domain.GameResult;
import baseball.service.CheckService;
import baseball.view.ResultView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BasicController {
    private List<Integer> computerNumber;

    public void createComputerNumber() {
        if(computerNumber != null)
            return;

        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println("computerNumber = " + computerNumber);
    }

    public Boolean checkNumber(String userInput){
        // String -> Integer
        List<Integer> userNum = makeIntegerArray(userInput);

        // service -> 1 0 0 과 같은 정보 리턴
        GameResult gameResult = CheckService.matchNumber(userNum, computerNumber);

        // view -> 해당 결과 출력 요청
        ResultView.printResult(gameResult);

        // 성공시 true, 아니면 false 반환
        if(gameResult.getSuccess() == true)
            return true;

        return false;

    }

    private List<Integer> makeIntegerArray(String userInput) {
        List<Integer> userNum = new ArrayList<>();
        for(int i = 0; i< userInput.length(); i++){
            userNum.add(userInput.charAt(i) - '0');
        }
        return userNum;
    }
}
