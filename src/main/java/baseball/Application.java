package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        boolean flag = true; // 게임 마지막 모두 성공 했을 때 계속할것인지 그만둘것인지를 결정하기 위해 flag 변수 생성

        try { // 모든 예외를 IllegalArgumentException 으로 처리하도록 try-catch를 사용함.

            while(flag) {

                System.out.println("숫자 야구 게임을 시작합니다.");
                List<Integer> computer = Application.randomNumber(); // 컴퓨터가 입력한 숫자를 List 객체에 담아줌.
                while(true) {
                    System.out.print("숫자를 입력해주세요 : ");

                    List<Integer> my = Application.myPickNum(); // 사용자가 입력한 숫자를 List객체에 담아줌.
                    int strike = 0; // 스트라이크의 갯수를 세기 위한 변수 생성
                    int ball = 0; // 볼의 갯수를 세기 위한 변수 생성

                    for (int i = 0; i < computer.size(); i++) { // 스트라이크인지 볼인지를 판별할 수 있도록 반복문 실행
                        Integer computerNum = computer.get(i); // computer의 i 번째에 해당하는 값을 대입
                        Integer myNum = my.get(i); // my의 i 번째에 해당하는 값을 대입

                        if (myNum == computerNum) { // my의 i번째 값과 computer의 i번째 값이 위치와 값이 같다면 stike의 값을 증가
                            strike++;
                        } else if (computer.stream().anyMatch(integer -> integer == myNum)) { // computer의 요소 중 my의 i번째 값이 들어있다면 위치와 상관없이 ball을 증가시킴
                            ball++;
                        } // if-elseif

                    } // for

                    if (strike == 3) { // strike가 3개이면 메세지를 출력하고 게임을 종료
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    } else if (strike == 0 && ball == 0) { // strike와 ball이 모두 0 이라면 "낫싱" 메시지를 출력
                        System.out.println("낫싱");
                    } else { // 위의 조건이 모두 참이 아닐 경우 아래 메시지를 출력
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    } // if-elseif-else

                } // while

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // 만약 게임이 종료되었을 때 이 문구를 출력하여 다시 시작할 것인지 아닌지를 입력받음

                String select = readLine(); // 위 메시지에 맞게 숫자를 입력받음.

                switch (select) {
                    case "1":
                        continue;
                    case "2":
                        flag = false;
                        break;
                    default: // 만약 1, 2가 아닌 다른 숫자를 입력할 시 IllegalArgumentException 예외를 던짐.
                        throw new IllegalArgumentException();
                }// switch

            } // while

        }catch(Exception e){ // try안의 모든 예외는 IllegalArgumentException 으로 처리하도록 함.
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        } // try-catch

    } // main

    public static List<Integer> randomNumber(){ // 컴퓨터가 랜덤한 값을 생성하는 메소드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> myPickNum() throws IllegalArgumentException{ // 사용자가 숫자를 입력하는 메소드

        String num = readLine(); // 사용자가 한번에 숫자를 입력받음
        String[] strArr = num.split(""); // 한번에 입력받은 숫자를 한자리씩 split을 통해서 잘라준 다음 배열에 담아줌.
        List<Integer> my = new ArrayList<>(); // 컴퓨터가 입력받은 타입과 동일하게 하기 위해 List 객체 생성

        for(int i=0; i<strArr.length; i++){ // String 배열에 들어있는 값들을 List 객체에 넣어줌.
            my.add(Integer.parseInt(strArr[i]));
        }

        Set<Integer> set = new HashSet<>(); // 중복체크를 위해서 set을 사용
        for(Integer myOneNum : my){ // 현재 담겨져 있는 my(List)에서 하나씩 뽑는다.
            if(!set.add(myOneNum)){ // 만약 set에 중복된 값이 있다면 조건문을 실행하고 예외를 발생시킨다.
                throw new IllegalArgumentException("");
            }

            if (myOneNum <= 0 && myOneNum < 9 || my.size() > 3) { // 만약 입력된 값 중 1개라도 1~9 범위에 있지 않거나, my(List)의 길이가 3을 초과하면 예외 발생
                throw new IllegalArgumentException("");
            }
        }

        return my;
    }

}
