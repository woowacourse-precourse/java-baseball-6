package printcount;

public class PrintCount {


    public void CountResult(int ball, int strike){

        if (ball == 0 && strike ==0){
            System.out.println("낫싱");
        } else if(ball == 0 && strike != 0 ) {
            System.out.printf("%d스트라이크", strike);
            System.out.println();
        } else if(ball != 0 && strike == 0 ) {
            System.out.printf("%d볼", ball);
            System.out.println();
        } else {
            System.out.printf("%d볼 %d스크라이크",ball,strike);
            System.out.println();
        }
    }
}
