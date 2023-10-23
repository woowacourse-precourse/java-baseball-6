package baseball;

public class Umpire {
    public void umpireMessage(int[] result){
        if (result[1] > 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "스트라이크 ");
        }
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
