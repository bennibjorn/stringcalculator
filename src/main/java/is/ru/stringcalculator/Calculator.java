package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//")) {
			return sum(specificDelimiter(text));
		}
		else if(text.contains(",") || text.contains("/n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}
    // If there is a specific delimiter, determine the delimiter using regex
    // and split using that specific delimiter
    private static String[] specificDelimiter(String specific) {        
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(specific);
        m.matches();
        String delimiter = m.group(1);
        String numbers = m.group(2);
        return numbers.split(delimiter);
    }

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String[] split = null;
        if (numbers.contains(",") && numbers.contains("/n")) split = numbers.split(("/n|\\,"));
        else if (numbers.contains(",") && !(numbers.contains("/n"))) split = numbers.split(",");
        else if (numbers.contains("/n") && !(numbers.contains(","))) split = numbers.split("/n");
        return split;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}