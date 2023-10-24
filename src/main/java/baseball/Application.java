package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        //라이브러리 Random 값 추출, 사용자 입력 주어진 거로 수정?


        while(true) {
            List<Integer> computer = new ArrayList<>();
            int strike = 0; // 입력한 값의 strike 저장
            int ball = 0; // 입력한 값의 ball 저장
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

//            for(int i: computer) {
//                System.out.println("랜덤 숫자 테스트" + i);
//            }

            while(true) {
                System.out.print("숫자를 입력해주세요 : ");  // println대신 print로 다음 입력이 개행되지 않게 수정
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String inputArr = br.readLine();

                int input = Integer.parseInt(inputArr);

                int numberArr[] = new int[3];

                // 사용자가 입력할 때 범위가 벗어나면 오류 표시
                if(input<100 || input > 999) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                }

//                testNumber[0] = input/100; // 처음에 input/100 = inputArr[i]로 함
                numberArr[0] = input/100;
                input = input - ((input/100)*100);
                numberArr[1] = input/10;
                input = input - ((input/10)*10);
                numberArr[2] = input;

                // 3번째 고민 3자리 숫자를 사용자한테 입력 받았는데, 어떻게 1자리씩 inputArr에 넣을 것인가


                // 입력 받을 때 같은 숫자가 있으면 오류 표시
                if(numberArr[0] == numberArr[1]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                } else if (numberArr[0] == numberArr[2]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                } else if (numberArr[1] == numberArr[2]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                }

                // 이중 for문 사용
                for(int i =0; i<computer.size(); i++) {
                    for(int j=0; j<numberArr.length; j++) {
                        if((computer.get(i) == numberArr[j]) & (i==j)){ // 숫자도 같고 인덱스도 같으면 strike, & && 차이?
                            strike++;
                        } else if((computer.get(i) == numberArr[j]) & (i!=j)){ // 숫자는 같은데 인덱스는 다르면 ball
                            ball++;
                        }
                    }
                }

                //출력 부분
                if(strike == 0 & ball !=0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0 & strike !=0) {
                    System.out.println(strike + "스트라이크");
                } else if (strike == 0 & ball ==0) {
                    System.out.println("낫싱");
                }else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }


                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    Scanner s = new Scanner(System.in);
                    int button = s.nextInt(); // 마지막에 게임을 새로 시작할지 종료할지 선택
                    if (button == 1) {
                        // strike, ball 초기화 -> 게임을 새로 시작할때도 strike, ball 초기화를 생각해야했음
                        strike = 0;
                        ball = 0;
                        break;
                    } else if (button == 2) {
                        return;
                    } else {
                        throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                    }
                }

                // strike, ball 초기화
                strike = 0;
                ball = 0;


            }
        }


    }
}
