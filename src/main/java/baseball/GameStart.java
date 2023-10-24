package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//게임 시작
public class GameStart{

    public void AnswerValid(int answer){
        int digit = (int)(Math.log10(answer)+1);
        //사용자가 입력한 값이 3자리 숫자가 아닐 때
        if (digit != 3) {
            throw new IllegalArgumentException();
        }

    }

    public void GameLogic(){
        //컴퓨터 : 랜덤 값 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while(true) {
            System.out.print("숫자를 입력하세요 : ");
            int Useranswer = 0;
            try { //사용자에게 숫자 받아오기
                BufferedReader User = new BufferedReader(new InputStreamReader(System.in));
                String answer = User.readLine();

                Useranswer = Integer.parseInt(answer);
            } catch (IllegalArgumentException | IOException e) { //정수로 변환이 되지 않을 때 예외 처리
                System.out.println(e.getMessage());
            }

            AnswerValid(Useranswer);

            int[] arrNum = Stream.of(String.valueOf(Useranswer).split("")).mapToInt(Integer::parseInt).toArray();

            List<Integer> user = new ArrayList<>();
            for(int i=0;i<(int)Math.log10(Useranswer)+1;i++){ //3
                user.add(arrNum[i]);
            }


            //사용자 입력 값 검증
            int strike = 0; // 자리, 숫자 완전 일치할 때
            int ball = 0; //숫자만 포함되어 있을 때
            for (int i=0;i<3;i++){

                if (user.get(i) == computer.get(i)) {
                    strike++;
                }else if ((user.get(i) != computer.get(i)) && (computer.contains(user.get(i))) ) {
                    ball++;
                }

            }


            //1. 자리 확인 (완전 일치)
            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strike == 0 && ball == 0){
                System.out.println("낫싱");
            } else {
                if (strike == 0){
                    System.out.println(ball + "볼 ");
                }else if (ball == 0){
                    System.out.println(strike + "스트라이크");
                }else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }

            user.clear();

        }



    }



    public void run() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int AnswerContinue = 0;

        do{
            GameLogic();

            try { //사용자에게 숫자 받아오기
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                BufferedReader Continue = new BufferedReader(new InputStreamReader(System.in));
                String ContinueGame = Continue.readLine();

                AnswerContinue = Integer.parseInt(ContinueGame);

            } catch (IllegalArgumentException e) { //정수로 변환이 되지 않을 때 예외 처리
                System.out.println(e.getMessage());
            }

        }while(AnswerContinue == 1);



    }




}