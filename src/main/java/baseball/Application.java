package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.*;
public class Application {
    private String answer = null; // 사용자 진행 여부
    List<Integer> computer = new ArrayList<Integer>();
    public Application() { // 생성자를 통해서 객체 생성시 랜덤 난수 생성
        while(computer.size()<3){ // computer 리스트의 크기가 3이 만족할 때까지
            int randomNumber = Randoms.pickNumberInRange(1,9); // 난수 뽑기
            if(!computer.contains(randomNumber)){ // 리스트안에 중복 된 요소가 아닌 경우
                computer.add(randomNumber); // 리스트에 추가.
            }
        }
    }
    public Boolean umpire(List<String> list){
        int ball = 0; // 해당 메서드를 실행할 때마다 ball 변수를 초기화
        int strike = 0; // 해당 메서드를 실행할 때마다 strike 변수를 초기화

        for (int i = 0; i < computer.size(); i++) { // computer[i]에서부터
            for (int j = 0; j < list.size(); j++) { // list[1,2,3] 순으로 비교
                if (computer.get(i) == Integer.parseInt(list.get(j)) && i == j) // 난수 리스트 와 사용자가 입력한 리스트 안에 동일한 숫자가 존재하고 인덱스 위치까지 같다면
                    strike++; // strike count 1 증가
                if (computer.get(i) == Integer.parseInt(list.get(j)) && i != j) // 난수 리스트 와 사용자가 입력한 리스트 안에 동일한 숫자가 존재하고 인덱스 위치는 다르다면
                    ball++; //ball 1 증가
            }
        }

        if (ball > 0 && strike == 0) // 해당 숫자에 ball만 존재할 때
            System.out.println(ball + "볼");

        else if (strike > 0 && ball == 0) // 해당 숫자에 strike만 존재할 때
            System.out.println(strike + "스트라이크");

        else if (strike > 0 && ball > 0) //해당 숫자에 ball과 strike가 같이 존재할 때
            System.out.println(ball+"볼 "+strike+"스트라이크");

        else if (ball == 0 && strike == 0) // 해당 숫자에 ball이랑 strike가 없을 때
            System.out.println("낫싱");

        if (strike == 3) { // 해당 숫자를 전부 맞혔을 때
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void input(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            System.out.print("숫자를 입력해주세요:");
            String number = Console.readLine(); // 사용자가 입력한 수

            List<String> numberArray = Arrays.asList(number.split("")); // 사용자가 입력한 수 분리하여 담아놓기 위한 배열
            Boolean over = umpire(numberArray); // split한 배열을 판정하기 위해 umpire() 호출.
            if(over == true) // umpire()에서 정답을 맞추고 반환 값이 true이면 while문 탈출.
                break;
        }
    }

    public static void main(String[] args) {
        Application application = new Application(); // 객체 생성과 동시에 난수 생성.
        application.input(); // 사용자에서 수를 입력받는 input() 호출.

        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine(); // 진행 여부 입력받기

            if(answer.equals("1")) {
                application = new Application(); // 다시 시작 시 객체 다시 생성
                application.input();
            } else if (answer.equals("2")) {
                return; // 게임 종료
            }
        }
    }
}
