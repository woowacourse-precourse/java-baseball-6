package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumber;

    private Printer printer;

    //Printer를 주입 받는 생성자
    public Computer(Printer printer) {
        this.printer = printer;
    }

    //한 게임을 실행하는 기능
    public boolean play() {

        //숫자 생성
        generateNumber();

        //게임 play
            //숫자를 입력해주세요 :
            //입력된 숫자 받기

            // *잘못된 값 입력시 예외를 반환하고 종료하는 기능

            // *입력한 숫자를 사용해 결과를 반환하는 기능

            // 3스트라이크인 경우 break

        //사용자로부터 재시작 숫자 받아서 리턴하기
        return false;
    }

    //랜덤하게 숫자 생성하는 기능
    public void generateNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerNumber=computer;
    }

    //입력한 숫자를 사용해 결과를 반환하는 기능
    public boolean checkGuess(List<Integer> guessNumber) {
        int ball = 0;
        int strike = 0;

        for (int i=0 ; i<3 ; i++) {
            //guessNum의 값을 contain하는지 체크
            //contain한다면, 위치까지 맞는지 체크
            if (computerNumber.contains(guessNumber.get(i))) {
                if (computerNumber.get(i) == guessNumber.get(i)) {
                    strike++;
                    continue;
                }
                ball++;
            }
        }
        //Printer 사용해서 출력
        printer.printResult(ball, strike);

        if (strike == 3) return true;
        return false;
    }

}
