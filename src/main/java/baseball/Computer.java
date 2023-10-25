package baseball;

public class Computer{
    int[] arr = new int[3];

    public int[] makeList() {
        for(int i = 0; i < 3; i++) {
            int randomNum = (int)(Math.random() * 9) + 1;
            arr[i] = randomNum;
        }
        return arr;
    }
}
