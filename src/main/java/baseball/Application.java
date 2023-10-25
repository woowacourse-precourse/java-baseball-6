package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean a =true;
        while (a) {
            List<Integer> computer = new ArrayList<>();
            List<Integer> people = new ArrayList<>();
            int strike = 0;
            int ball = 0;
            while (computer.size() < 3) { //만약 컴퓨터 배열의 크기가 3이상이 아니면,
                int randomNum = Randoms.pickNumberInRange(1, 9); //랜덤 넘버를 뽑는다.
                if (!computer.contains(randomNum)) { //만약 뽑힌 랜덤넘버가 컴퓨터 리스트 안에 없으면,
                    computer.add(randomNum); //랜덤 넘버를 집어넣는다.
                }
            } //3개의 랜덤 넘버를 모두 만든 컴퓨터
            //사용자가 입력한다.
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.println("숫자를 입력해주세요: ");
            String num = Console.readLine();
            if(!num.matches("[0-9]+")){
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            for (int i = 0; i < 3 ; i++) {
                char n = num.charAt(i); //num을 문자열 하나하나로 자름
                Integer m = Character.getNumericValue(n); //다시 char을 Int로 만듬
                if(people.contains(m)){
                    throw new IllegalArgumentException("중복되는 값을 입력할 수 없습니다.");
                }
                people.add(m);
            }

            for (int i = 0; i < computer.size(); i++) {
                for (int j = 0; j < people.size(); j++) {
                    if (computer.get(i).equals(people.get(j)) && i == j) {
                        strike++;
                    } else if (computer.get(i).equals(people.get(j)) && i!=j) {
                        ball++;
                    }
                }
             }
            if(strike==3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String n = Console.readLine();
                if(n.equals("2")){
                    a = false;
                } else {
                    continue;
                }
            } else if(strike==0 && ball ==0){
                System.out.println("낫싱");
            } else if(strike==0 && ball>0){
                System.out.println(ball+"볼");
            } else if(strike>0 && ball==0){
                System.out.println(strike + "스트라이크");
            } else{
                System.out.println(strike + "스트라이크" +ball+"볼");
            }
        }
    }
}
