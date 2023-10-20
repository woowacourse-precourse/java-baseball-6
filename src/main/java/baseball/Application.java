package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Play play = new Play();

        int run = 1;

        while (run==1){
            System.out.println("숫자 야구 게임을 시작합니다.");
            play.play();
            run = play.getNext();
        }
    }

    public static class Problem {
        private ArrayList<Integer> computer = new ArrayList<>();

        public void creatNumber() {
            computer.clear();
            for (int i = 0; i < 3; i++) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(number)) {
                    computer.add(i, number);
                } else {
                    i--;
                }
            }
        }

        public ArrayList<Integer> getComputer() {
            return computer;
        }
    }


    public static class Answer {
        private final ArrayList<Integer> answer = new ArrayList<>();

        public ArrayList<Integer> getAnswer() {
            return answer;
        }

        public void inputAnswer() {
            System.out.println("숫자를 입력해주세요");
            String stringAnswer = Console.readLine();
            String integers = "[0-9]+";
            if (stringAnswer.length() == 3 && stringAnswer.matches(integers)) {
                answer.add(0, Character.getNumericValue(stringAnswer.charAt(0)));
                answer.add(1, Character.getNumericValue(stringAnswer.charAt(1)));
                answer.add(2, Character.getNumericValue(stringAnswer.charAt(2)));
            } else {
                throw new IllegalArgumentException("3자리 정수를 입력하세요. :)");
            }
        }
    }


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
                ArrayList<Integer> answer1 = answer.getAnswer();

                //judge
                for (int i = 0; i<3; i++) {
                    if (problemNumber.contains(answer1.get(i)) && Objects.equals(problemNumber.get(i), answer1.get(i))){
                            strike++;
                        }else if (problemNumber.contains(answer1.get(i))){
                            ball++;
                    }
                }
                if (strike==0&&ball==0) {
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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            next = Integer.parseInt(Console.readLine());
        }
    }
}

