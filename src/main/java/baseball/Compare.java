package baseball;

public class Compare {

    public static boolean CompareNum(String com, String usr){

        int Ball = 0;
        int Strike = 0;

        for(int i = 0; i < 3; i++) {
            if(com.charAt(i) == usr.charAt(i)){
                Strike++;
            }

            else{
                for(int j = 0; j < 3; j++){
                    if(com.charAt(i) == usr.charAt(j)) {
                        Ball++;
                        break;
                    }
                }
            }
        }

        if(Strike == 3) {
            System.out.println(Strike + "스트라이크");

            return true;
        }

        else if(Strike == 0) {

            if(Ball == 0) {
                System.out.println("낫싱");
            }

            else{
                System.out.println(Ball + "볼");
            }
        }

        else{

            if(Ball == 0) {
                System.out.println(Strike + "스트라이크 ");
            }

            else{
                System.out.println(Ball + "볼 " + Strike + "스트라이크 " );
            }
        }
        return false;
    }
}
