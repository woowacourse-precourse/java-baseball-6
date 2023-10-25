package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int wantNewGame = 1; // 1 : 게임 계속 / 2: 게임그만
        char[] userChar; //이용자 입력값을 char 형태로 저장할곳..
        //게임시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        //게임 종료하기 값을 받을 때까지 게임 계속 반복
        while (true) {


            //랜덤값 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }// 1~9 랜덤값 3개 설정완료

            //답을 맞출때까지 사용자로부터 입력받기 무한반복
            while (true) {


                //사용자로부터 값 입력받기
                System.out.print("숫자를 입력해주세요 : ");
                userChar = Console.readLine().toCharArray(); // 문자 배열로 저장

                //입력받은 값이 이상한애면 .. 예외처리하기//////////////여기 다시 .. .추가해줄거있음. ..
                //1. 입력값의 길이가 3이 아니면 예외처리
                if (userChar.length != 3) {
                    throw new IllegalArgumentException();
                }

                //3. 숫자가 아닌 다른 문자가 오면 오류발생
                for ( char i : userChar) {
                    if (!Character.isDigit(i)) throw new IllegalArgumentException();
                }


                List<Integer> user = new ArrayList<>(); // 이용자의 입력값을 정수 형태로 저장할곳

                //입력받은값을 정수로 변환
                for (char i : userChar) {
                    user.add(Character.getNumericValue(i));
                }

                //2. 서로다른값을 입력하지 않으면 예외처리
                //중복값 존재하면 예외처리
                HashSet<Integer> user2 = new HashSet<Integer>(user) ;
                ArrayList<Integer> user3 = new ArrayList<Integer>(user2);
                if (user3.size() !=3 ) {
                    throw new IllegalArgumentException();
                }

                //리스트의 값이 동일하면 3스트라이크 하고 종료문 출력, 종료
                if (user.equals(computer)) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    //스트라이크 / 볼 개수판별

                    int cntStrike = 0; // 스트라이크 개수 저장하는 변수
                    int cntBall = 0; //볼 개수 저장하는 변수

                    //user , computer
                    for (int i = 0; i < 3; i++) {
                        if (computer.contains(user.get(i)))// user 의 값을 컴터가 갖고있다면 -> 볼또는 스트라이크
                        {
                            // 볼인지 스트라이크인지 판별
                            if (computer.get(i) == user.get(i)) cntStrike++;
                            else cntBall++;

                        }
                    }


                    //스트라이크, 볼 개수 출력
                    if (cntBall != 0 && cntStrike != 0)
                        System.out.printf("%d볼 %d스트라이크\n", cntBall, cntStrike);
                    else if (cntBall != 0)
                        System.out.printf("%d볼\n", cntBall);
                    else if (cntStrike != 0)
                        System.out.printf("%d스트라이크\n", cntStrike);
                    else System.out.println("낫싱");

                }
            }// 사용자 3개의 값 입력받기 종료


            //사용자로부터 게임 계속할것인지 여부 체크
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            wantNewGame = Integer.parseInt(Console.readLine());
            if (wantNewGame != 1 && wantNewGame != 2) {
                throw new IllegalArgumentException();
            }
            if (wantNewGame == 2) // 게임 그만하겠다고 하면 게임종료
                break;

        } // 게임 완전히 종료
    }
}



