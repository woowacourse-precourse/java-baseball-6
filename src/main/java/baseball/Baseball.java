package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    public boolean run(boolean reGame) {
        reGame = false;
        List<Integer> computer = createRandomNum();
        boolean retry = true;
        //게임 재도전
        while (retry) {
            System.out.println("숫자를 입력해주세요 :");
            //유저 답 입력
            String userInput = readLine();
            validateOverLength3(userInput);
            List<Integer> userInputList = transUserInputToList(userInput);
            System.out.println(computer);
            //정답과 유저의 답을 비교하는 메서드
            Map<String, Integer> calResult = calStrikeAndBallCount(computer,userInputList);

            int strikeCount = calResult.get("strikeCount");
            int ballCount = calResult.get("ballCount");
            //모두 맞으면
            if (strikeCount >= 3) {
                System.out.println(strikeCount + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String askReGame = readLine();
                reGame = validateRegame(askReGame);
                retry = false;
            }else if ((strikeCount==0)&&(ballCount==0)){
                //모두 틀리면
                System.out.println("낫싱");
            }else {
                //볼과 스트라이크가 존재하면
                System.out.println(ballCount + "볼 "+strikeCount + "스트라이크");
            }
        }
        return reGame;
    }

    private boolean validateRegame(String askReGame) {
        boolean reGame;
        if((!(askReGame.equals("1")))&&(!(askReGame.equals("2")))){
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
        if (askReGame.equals("2")) {
            System.out.println("종료");
            reGame = false;
        }else {
            reGame=true;
        }
        return reGame;
    }

    private void validateOverLength3(String userInput) {
        if(userInput.length()>3){
            throw new IllegalArgumentException("숫자는 3개만 입력해주세요");
        }
    }

    private List<Integer> transUserInputToList(String userInput) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : userInput.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    private List<Integer> createRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private Map<String,Integer> calStrikeAndBallCount(List<Integer> computer,List<Integer> userInputList){
        Map<String, Integer> calResult = new HashMap<>();
        int strikeCount = 0;
        int ballCount = 0;
        for (int userIndex = 0; userIndex < computer.size(); userIndex++) {
            int userNum = userInputList.get(userIndex);
            for (int ComIndex = 0; ComIndex < computer.size(); ComIndex++) {
                if (userNum == (computer.get(ComIndex))) {
                    //스트라이크 일 경우
                    if (userIndex == ComIndex) {
                        strikeCount++;
                    } else {
                        // 볼 일 경우
                        ballCount++;
                    }
                }
            }
            calResult.put("ballCount",ballCount);
            calResult.put("strikeCount", strikeCount);
        }
        return calResult;
    }
}
