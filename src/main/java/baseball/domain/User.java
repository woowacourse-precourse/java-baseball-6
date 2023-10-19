package baseball.domain;

import baseball.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {
    private static final String NUMBER_REGEXP = "^[1-9]{3}$";
    private static final String STRING_REGEXP = "^[a-zA-Z]$";
    private static final String RETRY_REGEXP = "[1|2]";
    private static final String RETRY = "1";

}
