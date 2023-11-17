package baseball.Service;

import baseball.domain.BaseballMember;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {

    //computer가 랜덤으로 숫자를 생성함
    BaseballMember baseballMember = new BaseballMember();
    Game game;
    User user = new User();
    Result result = new Result();

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
            result.


        }
    }
   // public void playGame() {
    //    int strike = 0;
    //    while (strike != 3) {
    //        play();
    //        systemMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
    //        strike = game.getStrikeCount();
    //    }
   // }

    private void play() {
        game.initBaseBall();    //스트라이크 & 볼 0으로 초기화
        user.setMyinputList(getMyinputNumber());
    }

    private List<Integer> getMyinputNumber() {
    }

    public class MyinputNumber {
        //내가 입력한 3개의 값을 리스트에 저장
        public void Myinputlist(){
            User user = new User();

            for (int i = 0; i < 3; i++) {
                System.out.println((i+1) + "번째 수 입력: ");
                user.getMyinputList().add(i, Integer.valueOf(readLine()));  //입력받고 myinputlist에 저장
            }
        }
    }

    public static void main(String[] args) {

    }

}
