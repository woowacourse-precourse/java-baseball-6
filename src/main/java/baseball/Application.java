package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        BaseballGame Game = new BaseballGame();
        Game.Run();
    }
};

class BaseballGameManager{
    // 사용자에게 입력을 받습니다.
    public void runGame(){

    };
    public void getUserNumberInput(){};
    public void getGameFinishInput() {
        // 게임 종료 여부를 1 또는 2 로 입력받음
    };


}
class BaseballGame {

    // 컴퓨터가 사용할 숫자를 저장할 리스트
    List<Integer> computerNumbers = new ArrayList<>();

    // 유저가 사용할 숫자를 저장할 리스트
    List<Integer> userNumbers = new ArrayList<>();

    // 스트라이크 갯수
    int strikeCount;

    // 볼 갯수
    int ballCount;

    // 게임 종료 여부를 확인하기 위한 정수
    int gameFinish;

    // 유저가 입력한 숫자에서 중복값을 확인
    public void checkUserForDuplicates() {
        // 구현
    }

    // 컴퓨터가 게임에 사용할 숫자를 새로 갱신합니다.
    public void generateComputerNumbers() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    // 스트라이크 갯수를 증가시킵니다.
    public void incrementStrikeCount() {
        strikeCount += 1;
    }

    // 볼 갯수를 증가시킵니다.
    public void incrementBallCount() {
        ballCount += 1;
    }

    // 스트라이크와 볼 갯수를 초기화합니다.
    public void resetScores() {
        strikeCount = 0;
        ballCount = 0;
    }

    // Strike의 갯수를 반환합니다.
    public int getStrikeCount() {
        return strikeCount;
    }

    // Ball의 갯수를 반환합니다.
    public int getBallCount() {
        return ballCount;
    }

}


class OutputView{
    public void startGameAnnouncement(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void promptUserForRoundGuess() {
        System.out.print("숫자를 입력해주세요 :");
    }

    // 매 라운드의 숫자 야구에서 스트라이크를 출력합니다.
    public void printStrike(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    // 매 라운드의 숫자 야구에서 볼을 출력합니다.
    public void printBall(int ballCount) {
        System.out.println(ballCount +"볼");
    }

    // 매 라운드의 숫자 야구에서 아무 것도 출력하지 않습니다.
    public void printNothing() {
        System.out.println("낫싱");
    }

    // 매 라운드의 숫자 야구에서 스트라이크와 볼을 출력합니다.
    public void printBoth(int strikeCount, int ballCount) {
        System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
    }


};
