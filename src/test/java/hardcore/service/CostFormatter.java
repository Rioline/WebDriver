package hardcore.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostFormatter {
    public static final String COST_REGEX = "USD\\s(\\d+\\,*\\.*)+";

    public static String receiveCostFromString(String inputString) {
        String cost = "";

        Pattern pattern = Pattern.compile(COST_REGEX);
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            cost = matcher.group();
        }
        return cost;
    }
}
