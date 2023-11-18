package baseball.Service;

import baseball.View.RetryMessage;
import baseball.View.printScoreMessage;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class GameService {

    int size;
    Game game;
    User user = new User();
    Result result = new Result();
    printScoreMessage printScoreMessage = new printScoreMessage();

    public void setGame() {
        while ((game.getRandomNumbers().size()) < 3) {   //리스트에 들어있는 원소 수
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1~9까지의 수 랜덤으로 집어넣음
            if (!game.getRandomNumbers().contains(randomNumber)) { //중복방지
                game.getRandomNumbers().add(randomNumber);
            }
        }
    }

    public void playGame(){
        int strike = 0;
        while(strike != 3){
            play();
            printScoreMessage.printMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();    //스트라이크 & 볼 0으로 초기화
        user.setMyinputList(getUserNumber());
        Score();
    }


    private int[] getUserNumber() throws IllegalArgumentException {
        RetryMessage.printInputMessage();   //숫자를 입력해 주세요 :
        String inputNumber = Console.readLine();

        return User.checkUserInput(inputNumber, size);
    }
    private void Score() {
        for (int i = 0; i < size; i++) {
            computer(game.getGameNumbers(), user.getMyinputList(), i);
        }
    }

    private void computer(int[] gameNumber, int[] myinputList, int index) {
        int temp = -1;
        for (int j = 0; j < gameNumber.length; j++) {
            if (gameNumber[j] == myinputList[index]){
                temp = j;
                break;
            }
        }
        incCount(index, temp);

    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1)
            game.incBallCount();
        if (temp == index)
            game.incStrikeCount();
    }


}
