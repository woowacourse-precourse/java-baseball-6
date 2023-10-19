package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(); //게임 인스턴스 생성
        game.printStartMessage(); //게임 시작 문구 출력
        //숫자 야구 진행
        while(true){
            game.initGame(); //게임 상태 초기화
            game.startGame(); //게임 시작
            if(!game.isRestart()) //게임의 재시작 여부 결정
                break;
        }


    }
}
