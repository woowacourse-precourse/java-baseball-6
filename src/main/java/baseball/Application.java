package baseball;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static class BaseballProgram {
        private String inputValue;
        private int step = 1;
        private boolean run = true;
        BaseballProgram() {
            display(step);
        }


        public void display(int inputStep) {
            while (run) {
                switch (inputStep) {
                    case 1:
                        System.out.println("========@숫자야구입니다@========");
                        System.out.println("============================");
                        System.out.println("숫자 3자리를 이어서 작성하시오 :");
                        Scanner scanner = new Scanner(System.in);
                        int input = scanner.nextInt();
                        getValue(input);
                }
            }



        }
        //getter
        public String getValue(int value) {
            this.inputValue = Integer.toString(value);
            return inputValue;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballProgram test = new BaseballProgram();


    }
}
