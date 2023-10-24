package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean restart = false;
        List<Integer> answer = new ArrayList<>();
        while (true){
            //2. 시작문구 출력
            if (!restart) {
                answer = makeAnswer(answer);
                System.out.println("숫자 야구 게임을 시작합니다.");
            }
            restart = true;
            //3. 입력받기
            System.out.print("숫자를 입력해주세요 : ");
            String[] input = Console.readLine().split("");
            if (input.length!=3) {
                userExeption();
            }
            int[] userAnswer = new int[3];
            for (int i=0;i<3;i++) {
                userAnswer[i] = Integer.parseInt(input[i]);
            }
            //4. 각 자리별 스트라이크, 볼 체크
            int strike = 0;
            int ball = 0;
            boolean out = true;
            for (int i=0;i<3;i++) {
                if (userAnswer[i]==answer.get(i)){
                    strike++;
                    out = false;
                } else {
                    for (int j=0;j<3;j++) {
                        if (i!=j&&userAnswer[i]== answer.get(j)) {
                            ball++;
                            out = false;
                        }
                    }
                }
            }

            //5. 입력에 맞는 답 출력, 답을 맞췄을 시 재시작과 종료 문구 출력
            if (!out) {
                if (strike==3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                            "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int answerStart = Integer.parseInt(Console.readLine());
                    if (answerStart==1) {
                        makeAnswer(answer);
                    } else if (answerStart==2) {
                        break;
                    } else {
                        userExeption();
                    }
                }else {
                    if (ball>0) {
                        System.out.println(ball+"볼 ");
                    }
                    if (strike>0) {
                        System.out.println(strike+"스트라이크");
                    }
                }
            } else {
                System.out.println("낫싱");
            }
        }
    }
    static void userExeption () throws IllegalArgumentException{
            throw new IllegalArgumentException();
    }

    //1. 1부터 9까지 서로 다른 3자리수 생성
    static List makeAnswer(List answer){
        answer.clear();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
