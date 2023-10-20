package input;

import camp.nextstep.edu.missionutils.Console;

public class InputModule {
    private int[] inputArr;

    public InputModule() {
        String[] arr = Console.readLine().split("");
        inputArr = new int[arr.length];
        extract_arr(arr);
    }

    public int[] getInputArr() {
        return inputArr.clone();
    }

    private void extract_arr(String[] arr) {
        for(int i = 0; i < arr.length; i++){
            inputArr[i] = Integer.parseInt(arr[i]);
        }
    }


}