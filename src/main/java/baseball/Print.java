package baseball;

// 사용자에게 보여질 화면을 표시하는 부분
public class Print {

    public void print_start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void print_input(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void print_output(int[] score){
        if (score[1] != 0) {
            System.out.print(score[1] + "볼 ");
            if (score[0] != 0) {
                System.out.print(score[0] + "스트라이크\n");
            } else{
                System.out.println(); // 개행을 위함
            }
        } else if(score[0] != 0) {
            System.out.print(score[0] + "스트라이크\n");
        } else{
            System.out.println("낫싱\n");
        }
    }

    public void print_end(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
