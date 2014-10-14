package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("/n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
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