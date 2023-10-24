package baseball.service;

import baseball.constant.ServiceMessage;

public class ServiceMessagePrinter {
    public static void getServiceMessage(String input) {
        System.out.print(ServiceMessage.valueOf(input).serviceMessage);
    }
}
