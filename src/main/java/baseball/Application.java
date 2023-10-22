package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //라이브러리 Random 값 추출, 사용자 입력 주어진 거로 수정?

        int numArr[] = new int[3]; // 컴퓨터가 내는 랜덤 3자리
        int inputArr[] = new int[3]; // 유저의 입력값 3자리
        int strike = 0; // 입력한 값의 strike 저장
        int ball = 0; // 입력한 값의 ball 저장


        while(true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            for(int i =0; i<numArr.length; i++ ) {
                numArr[i] = (int)(Math.random()*9 + 1); // 1번째 고민: 1에서 9까지라서 +1 함
                for(int j=0; j<i; j++) { // 2번째 고민: 서로 다른 숫자라서 같은 숫자면 다시 선택하게 해야함, // i가 0일때는 차피 첫번째 선택이라 겹치는 숫자는 없음 그래서 i는 1부터 고려
                    if(numArr[i] == numArr[j]) {
                        i--; // i를 줄여 이전 숫자로 가고
                        break; // 해당 반복문을 탈출해서 다시 랜덤 숫자 받기
                    }
                }
            }

            for(int i =0; i<numArr.length; i++ ) {
                System.out.println("랜덤 숫자 테스트" + numArr[i]);
            }

            while(true) {
                System.out.print("숫자를 입력해주세요 :");  // println대신 print로 다음 입력이 개행되지 않게 수정
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();

                // 사용자가 입력할 때 범위가 벗어나면 오류 표시
                if(num<100 || num > 999) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                }

                inputArr[0] = num/100; // 처음에 num/100 = inputArr[i]로 함
                num = num - ((num/100)*100);
                inputArr[1] = num/10;
                num = num - ((num/10)*10);
                inputArr[2] = num;

                // 3번째 고민 3자리 숫자를 사용자한테 입력 받았는데, 어떻게 1자리씩 inputArr에 넣을 것인가


                // 입력 받을 때 같은 숫자가 있으면 오류 표시
                if(inputArr[0] == inputArr[1]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                } else if (inputArr[0] == inputArr[2]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                } else if (inputArr[1] == inputArr[2]) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다."); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                }

                // 이중 for문 사용
                for(int i =0; i<numArr.length; i++) {
                    for(int j=0; j<inputArr.length; j++) {
                        if((numArr[i] == inputArr[j]) & (i==j)){ // 숫자도 같고 인덱스도 같으면 strike, & && 차이?
                            strike++;
                        } else if((numArr[i] == inputArr[j]) & (i!=j)){ // 숫자는 같은데 인덱스는 다르면 ball
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
