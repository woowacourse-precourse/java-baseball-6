package baseball;

public class ValidCheckNumber {
    public static void duplicationAndZeroCheck(int num){
        boolean check = true;
        int[] arr = new int[10];
        for (int i=0; i<3; i++){
            arr[num%10]+=1;
            if (num%10==0){
                check = false;
            }
            num/=10;
        }
        for (int i : arr){
            if (i > 1) {
                check = false;
                break;
            }
        }
        if(!check){
            throw new IllegalStateException();
        }
    }
    public static int validCheckPlayer(String s){
        try{
            int i = Integer.parseInt(s);
            if (i>987 || i<123){
                throw new IllegalArgumentException();
            }
            return i;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    public static int validCheckRestart(String s){
        try{
            int i = Integer.parseInt(s);
            if (i!=1 && i!=2){
                throw new IllegalArgumentException();
            }
            return i;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
