package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean doRestart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(doRestart){
            NumberBaseballGame.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userRestartNumber = Integer.parseInt(Console.readLine());

            if(userRestartNumber == 2){
                doRestart = false;
            }
            continue;

        }

    }
}

//클래스 필드 값을 내부 메소드에서 리턴 - 인스턴스 변수 vs 클래스 변수(static)
//(권장하지 않지만 굳이) 클래스의 static 변수를 여러 인스턴스에서 업데이트해가면서 사용한다면, 마지막 업데이트로 고정됨(static) - 인스턴스 전체가 공유하는 변 => final 처리하면 업데이트 금지됨
//상수 변수에서 띄어쓰기는 underscore 사용
//처음부터 모듈화 빡세게 고민하니까 고민이 끝도 없어짐. 적당히 하면서 나중에 리팩토링 & 모듈화 & 클린코드 & Java Convention 의식
//함수가 '동사'라면, 객체는 '명사'라고 착각함(아직 뭐라고 단정X) => 함수 리턴 형태에 따라, 다른 함수의 인자로 결과값을 패스해야할 듯
