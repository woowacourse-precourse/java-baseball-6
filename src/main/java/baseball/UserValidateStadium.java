package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserValidateStadium {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return Console.readLine();
    }

    public int getLeaveGameType(boolean isGameOver) {
        boolean shouldExit = false;
        int leaveGameType = Constant.Input_Restart_Number;

        do {
            if (isGameOver) {
                displayMessage(Constant.Restart_or_Exit);
            } else {
                if (shouldExit) {
                    displayMessage(Constant.Exit_Game);
                }
                displayMessage(Constant.Restart_or_Exit);
            }

            String leaveGameInput = getUserInput(Constant.Restart_or_Exit);
            try {
                leaveGameType = validateLeaveGameInput(leaveGameInput);

                if (leaveGameType == Constant.Input_Restart_Number) {
                    displayMessage(Constant.Brandnew_Game);
                    shouldExit = false;
                } else if (leaveGameType == Constant.Input_Exit_Number) {
                    shouldExit = true;
                } else {
                    throw new IllegalArgumentException(Constant.Input_Wrong);
                }
            } catch (IllegalArgumentException e) {
                // 예외가 발생한 경우 메시지 출력 또는 다른 처리를 수행
                System.out.println(e.getMessage());
            }
        } while (!shouldExit);

        return leaveGameType;
    }

    private int validateLeaveGameInput(String leaveGameInput) {
        if (leaveGameInput == null || leaveGameInput.isEmpty()) {
            throw new IllegalArgumentException(Constant.Input_Nothing);
        }

        if (!isNumberString(leaveGameInput)) {
            throw new IllegalArgumentException(Constant.Input_Type_Exception);
        }

        int leaveGameType = Integer.parseInt(leaveGameInput);

        if (leaveGameType != Constant.Input_Restart_Number && leaveGameType != Constant.Input_Exit_Number) {
            throw new IllegalArgumentException(Constant.Input_Wrong);
        }

        return leaveGameType;
    }

    private boolean isNumberString(String uncheckedString) {
        if (uncheckedString == null || uncheckedString.isEmpty()) {
            return false;
        }

        for (char uncheckedCharacter : uncheckedString.toCharArray()) {
            if (!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }
}
