//import java.util.Scanner;

public class Main {
    // 1. parenthesesCheck
    public static Boolean parenthesesCheck(String s) {
        int len = s.length();
        int openBracket = 0;
        int closeBracket = 0;
        for (int i = 0; i < len; i++){
            Character currentChar = s.charAt(i);
            if (currentChar == '('){
                openBracket++;
            }
            if (currentChar == ')'){
                closeBracket++;
            }
        }
        if (openBracket == closeBracket){
            return true;
        }
        else{
            return false;
        }
    }


    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String tempStr = "";
        while (n > 0){
            int currentDigit = n % 10;
            tempStr = tempStr + currentDigit;
            n = n/10;
        }
        return tempStr;
    }


    // 3. encryptThis
    public static String encryptWord(String word){
        int asciiFirstInt = (int) word.charAt(0);
        String asciiFirst = Integer.toString(asciiFirstInt);
        if (word.length() < 3){
            return asciiFirst + String.valueOf(word.charAt(1));
        }

        else if (word.length() == 3){
            String secondChar = String.valueOf(word.charAt(1));
            String lastChar = String.valueOf(word.charAt(word.length() - 1));
            return asciiFirst + lastChar + secondChar;
        }

        else if (word.length() == 4){
            String secondChar = String.valueOf(word.charAt(1));
            String thirdChar = String.valueOf(word.charAt(2));
            String lastChar = String.valueOf(word.charAt(word.length() - 1));
            return asciiFirst + lastChar + thirdChar + secondChar;

        }
        else{
            String secondChar = String.valueOf(word.charAt(1));
            String middle = word.substring(2, word.length() - 1);
            String lastChar = String.valueOf(word.charAt(word.length() - 1));
            return asciiFirst + lastChar + middle + secondChar;
        }
    }

    public static String encryptThis(String input) {
        String[] indWords = input.split("\\s+");
        String encrypted = "";
        for (String s : indWords){
            encrypted += " " + encryptWord(s);
        }
        return encrypted.substring(1);
    }


    // 4. decipherThis
	public static String decipherWord(String word){
        if (Character.isDigit(word.charAt(2))){
            int firstNumbers = Integer.parseInt(word.substring(0,3));
            char firstChar = (char) firstNumbers;
            String firstCharStr = String.valueOf(firstChar);
            String secondChar = String.valueOf(word.charAt(word.length() - 1));
            String lastChar = String.valueOf(word.charAt(3));
            
            if (word.length() < 5){
                return firstCharStr + secondChar;
            }
            else if (word.length() == 5){
                return firstCharStr + secondChar + lastChar;
            }
            else if (word.length() == 6){
            	String middle = String.valueOf(word.charAt(4));
                return firstCharStr + secondChar + middle + lastChar;
            }
            else{
                String middle = word.substring(3, word.length() - 1);
                return firstCharStr + secondChar + middle + lastChar;
            }
        }
        else{
        	int firstNumbers = Integer.parseInt(word.substring(0,2));
            char firstChar = (char) firstNumbers;
            String firstCharStr = String.valueOf(firstChar);
            String secondChar = String.valueOf(word.charAt(word.length() - 1));
            String lastChar = String.valueOf(word.charAt(2));
			
           	if (word.length() < 5){
                return firstCharStr + secondChar;
            }
            else if (word.length() == 5){
                return firstCharStr + secondChar + lastChar;
            }
            else{
                String middle = word.substring(3, word.length() - 1);
                return firstCharStr + secondChar + middle + lastChar;
        }
    	}
    }
    public static String decipherThis(String input) {
        String[] indWordsD = input.split("\\s+");
        String deciphered = "";
        for (String s : indWordsD){
            deciphered += " " + decipherWord(s);
        }
        return deciphered.substring(1);
    }

}
