package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        SetNumber setNumber = new SetNumber();
        InputNumber inputNumber = new InputNumber();
        ComputeResult computeResult = new ComputeResult();
        Finish finish = new Finish();
        int fin = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(fin == 1){
            List<Integer> computerNum = setNumber.generate();
            String result = "";

            while(!result.equals("3스트라이크")){
                try{
                    result = computeResult.result(computerNum, inputNumber.userNumber());
                }catch (IllegalArgumentException i){
                    throw new IllegalArgumentException("잘못된 형식의 값을 입력하셨습니다.");
                }

                System.out.println(result);
            }

            fin = finish.finish();

        }
    }
}
