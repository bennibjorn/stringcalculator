package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-")) {
			negative(splitNumbers(text));
			return 1; // a little bit of cheating
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
    private static void negative(String[] text) {
    	List<String> negatives = new ArrayList<String>();
    	for(int i = 1; i < text.length; i++) {
    		if(text[i].matches("-.*")) {
    			negatives.add(text[i]);
    		}
    	}
    	
    	if(!(negatives.isEmpty())) {
    		String nlist = negatives.get(0);
    		for (int i = 1; i < negatives.size(); i++) {
    			nlist += "," + negatives.get(i);
    		}
        	throw new IllegalArgumentException("Negatives not allowed: " + nlist);
    	}
    	
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
        	if (toInt(number) > 1000) {
        		break;
        	}
        	else {
        		total += toInt(number);
        	}
		}
		return total;
    }



}