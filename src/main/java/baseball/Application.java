package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    //INPUT 에러 메세지
    private static final String ERROR_MSG_INPUT = "3자리 정수를 입력하세요. :)";
    private static final String ERROR_MSG_DUPLICATE = "3자리 숫자는 중복되지 않습니다. :)";


    public static void main(String[] args) {
        Play play = new Play();
        int run = 1;        //  시작,재사작 변수

        while (run == 1){
            System.out.println("숫자 야구 게임을 시작합니다.");
            play.play();
            run = play.getNext();       //게임 메소드 종료후 재시작 여부 불러오기
        }
    }


    // 문제 생성 클래스
    public static class Problem {
        private final ArrayList<Integer> computer = new ArrayList<>();

        public void creatNumber() {
            computer.clear();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
        }

        public ArrayList<Integer> getComputer() {
            return computer;
        }
    }


    //Player의 정답 입력 클래스
    public static class Answer {
        private final ArrayList<Integer> answer = new ArrayList<>();

        public ArrayList<Integer> getAnswer() {
            return answer;
        }

        public void inputAnswer() {
            System.out.println("숫자를 입력해주세요");
            answer.clear();
            String stringAnswer = Console.readLine();
            String integers = "[0-9]+";

            // 3자릿수 확인
            if (stringAnswer.length() == 3 && stringAnswer.matches(integers)) {
                answer.add(0, Character.getNumericValue(stringAnswer.charAt(0)));
                answer.add(1, Character.getNumericValue(stringAnswer.charAt(1)));
                answer.add(2, Character.getNumericValue(stringAnswer.charAt(2)));
            } else {
                throw new IllegalArgumentException(ERROR_MSG_INPUT);
            }

            // 중복 체크
            List<Integer> duplicationCheck = new ArrayList<>(answer);
            int check;
            for(int i = 2; i >= 0; i--){
            check = duplicationCheck.remove(i);
            if (duplicationCheck.contains(check)){
                throw new IllegalArgumentException(ERROR_MSG_DUPLICATE);
            }
            }
            duplicationCheck.clear();
        }
    }

    //동작부
    public static class Play{
        Answer answer = new Answer();
        Problem problem = new Problem();

        private int next;
        private int strike;
        private int ball;

        public int getNext() {
            return next;
        }

        public void play() {
            problem.creatNumber();
            ArrayList<Integer> problemNumber = problem.getComputer();
            int status = 0;
            while (status == 0){
                answer.inputAnswer();
                ArrayList<Integer> playAnswer = answer.getAnswer();
                //Player의 입력값 판정
                for (int i = 0; i < 3; i++) {
                    if (problemNumber.contains(playAnswer.get(i)) && problemNumber.get(i).equals(playAnswer.get(i))){
                            strike++;
                        }else if (problemNumber.contains(playAnswer.get(i))){
                            ball++;
                    }
                }

                //판정값 출력
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    status++;
                }
                strike = 0; ball = 0;
            }

            //재시작 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            next = Integer.parseInt(Console.readLine());
        }
    }
}