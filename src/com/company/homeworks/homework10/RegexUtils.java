package com.company.homeworks.homework10;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {

    public RegexUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isMailingAddress(String mailingAddress) {
        if (Objects.nonNull(mailingAddress)) {
            return mailingAddress.matches("[a-zA-Z]\\w*@(mail|gmail)\\.(com|org)");
        }
        return false;
    }

    public static StringBuilder getHexadecimalNumbers(String stringWithHexadecimalNumbers) {
        if (Objects.nonNull(stringWithHexadecimalNumbers)) {
            Pattern hexadecimalPattern = Pattern.compile("0x[A-F1-9]+");
            Matcher matcher = hexadecimalPattern.matcher(stringWithHexadecimalNumbers);
            StringBuilder stringBuilder = new StringBuilder();
            while (matcher.find()) {
                stringBuilder.append(matcher.group());
                stringBuilder.append(" ");
            }
            return stringBuilder;
        }
        return null;
    }
}
