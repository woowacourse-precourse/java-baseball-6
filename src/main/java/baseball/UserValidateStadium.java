package baseball;

import java.util.Scanner;

public class UserValidateStadium {
    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public boolean getLeaveGameType(boolean isGameOver) {
        boolean shouldExit = false;
        int leaveGameType = Constant.Input_Restart_Number;

        do {
            if (isGameOver) {
                displayMessage(Constant.Restart_or_Exit);
            } else {
                if (shouldExit) {
                    displayMessage(Constant.Exit_Game);
                } else {
                    displayMessage(Constant.Restart_or_Exit);
                }
            }

            String leaveGameInput = getUserInput(Constant.Restart_or_Exit);
            try {
                leaveGameType = validateLeaveGameInput(leaveGameInput);

                if (leaveGameType == Constant.Input_Restart_Number) {
                    shouldExit = false;
                } else if (leaveGameType == Constant.Input_Exit_Number) {
                    shouldExit = true;
                } else {
                    displayMessage(Constant.Input_Range_Exception);
                    shouldExit = getLeaveGameType(false);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                shouldExit = getLeaveGameType(false);
            }
        } while (!shouldExit);

        return leaveGameType == Constant.Input_Exit_Number;
    }

    private int validateLeaveGameInput(String leaveGameInput) {
        if (leaveGameInput == null || leaveGameInput.isEmpty()) {
            displayMessage(Constant.Input_Nothing);
            return Constant.Input_Restart_Number;
        }

        if (!isNumberString(leaveGameInput)) {
            displayMessage(Constant.Input_Type_Exception);
            return Constant.Input_Restart_Number;
        }

        int leaveGameType = Integer.parseInt(leaveGameInput);
        if (leaveGameType != Constant.Input_Restart_Number && leaveGameType != Constant.Input_Exit_Number) {
            displayMessage(Constant.Input_Range_Exception);
            return Constant.Input_Restart_Number;
        }

        return leaveGameType;
    }

    private boolean isNumberString(String str) {
        return str.matches("\\d+");
    }
}
