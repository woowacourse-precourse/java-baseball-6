package baseball.controller;

import baseball.service.UserService;

public class UserController {
    private final UserService userService =  new UserService();

    public String numberInput(){
        String number = userService.readUserNumber();
        return number;
    }

    public String endTypeInput(){
        String type = userService.readTypeNumber();
        return type;
    }


}
