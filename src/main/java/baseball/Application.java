package baseball;


import baseball.controller.BaseballGame;
import baseball.model.RestartNum;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printGameStart(); // 숫자 야구 게임을 시작합니다

        do {
            BaseballGame baseBallGame = new BaseballGame();
            baseBallGame.gameStart();
        } while (restart());

    }
    public static boolean restart (){
        RestartNum restartNum = new RestartNum(Input.gameRestart());

        return restartNum.getRestartNum().equals("1");
    }
}


// https://github.com/ParkJungYoon/java-baseball/blob/ParkJungYoon/src/main/java/baseball/domain/GenerateRandomNumbers.java
// https://github.com/COBI-98/java-baseball/blob/EUNSH1/src/main/java/baseball/model/PlayerNumber.java



/*
느낀점
처음에는 평소 코딩테스트 하듯이 Application.java에 모든 코드를 작성하려고 했다. 그런데 하던 중 프로그래밍을 하면서 요구 사항들을 보고 그저
기능을 구현을 했는지 안 했는지를 보는 것이 너무 단순한 것 같다는 생각이 들었다. 검색해보니 MVC 형태와 객체지향적 설계를 지키면서 진행하는 것을
보고 어떻게 시작을 해야 할지도 난감했습니다.
간단한 게임이지만 세부적인 로직들을 구조적으로 구현하는 것이 생각보다 쉽지 않다는 것을 깨닫고 학부 때 했던 슈팅게임 방식을 보면서 다시 상기시키고 단계별로 진행을 시작했습니다.
시작은 무엇을 출력하고 입력할 것인지를 파악하기 위해 view 부분부터 구현했습니다.
그 다음은 Model에서 객체를 만들고 그 객체들의 요구사항들을 구현했습니다.
*/