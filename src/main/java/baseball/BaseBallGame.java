package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Objects;

public class BaseBallGame {
    private ArrayList<Integer> answerNum = new ArrayList<>();
    private ArrayList<Integer> userNum = new ArrayList<>();
    private GameState state = GameState.NOT_START;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        state = GameState.PLAYING;

        play();
    }

    private void play() {
        generateNum();
        while (state != GameState.CORRECT) {
            chooseNum();
            System.out.println(getResult());
        }
        exitGame();
        if (state == GameState.PLAYING) {
            play();
        }
    }


    private void chooseNum() {
        String input = "";

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        String[] userNumAsString = input.split("");
        userNum.clear();
        for (String str : userNumAsString) {
            int number = Integer.parseInt(str);
            userNum.add(number);
        }
        if ((userNum.get(0) == userNum.get(1)) || (userNum.get(0) == userNum.get(2)) || (userNum.get(1) == userNum.get(2))) {
            throw new IllegalArgumentException();
        }
        if(userNum.contains(0)){
            throw new IllegalArgumentException();
        }
    }

    private String getResult(){
        String msg = "";

        int ballNum = Calculater.getBallNum(answerNum, userNum);
        int strikeNum = Calculater.getStrikeNum(answerNum, userNum);

        if(ballNum != 0)
            msg += ballNum + "볼 ";
        if(strikeNum != 0)
            msg += strikeNum + "스트라이크";
        if(ballNum == 0 && strikeNum == 0)
            msg = "낫싱";
        if(strikeNum == 3)
            state = GameState.CORRECT;

        return msg;
    }

    private void exitGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(Objects.equals(input, "1")){
            state = GameState.PLAYING;
        }else if(Objects.equals(input, "2")){
            state = GameState.END;
        }else{
            throw new IllegalArgumentException();
        }
    }

    private void generateNum(){
        answerNum.clear();
        while (answerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNum.contains(randomNumber)) {
                answerNum.add(randomNumber);
            }
        }
    }

}
