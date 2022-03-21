package com.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge1 {
    public static void main(String[] args) {
        //Write the string literal regExp that will match the following String. Use the String.matches() method to verify your answer.
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        //Now write regExp that will match "I want a bike." and "I want a ball.". verify your answer using the matches() method.
        String regExp = "I want a \\w+.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));
        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        //Use the Matcher.matches() method to check for matches, for the regExp that uses \w+.
        String regExp3 = "I want a \\w+.";
        Pattern pattern1 = Pattern.compile(regExp3);
        Matcher matcher1 = pattern1.matcher(challenge1);
        System.out.println(matcher1.matches());

        matcher1 = pattern1.matcher(challenge2);
        System.out.println(matcher1.matches());


        //Replace all occurrences of blank with an underscore for the following string. Print out the resulting string.
        String challenge4 = "Replace all blanks with underscore.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        //Write a regExp that will match the following string in its entirety.
        String challenge5 = "aaabccccccccdddefffg";
//        String regExp5 = "[abcdefg]+";
        String regExp5 = "[a-g]+";
        System.out.println(challenge5.matches(regExp5));

        //Write a regExp that will only match the challenge5 string in its entirety.
        String regExp6 = "^a{3}bc{8}d{3}ef{3}g$";
        System.out.println(challenge5.matches(regExp6));

        //Write a regExp that will match a string that starts with a series of letters. The letters must be followed by a period. After the period, there must be a series of digits.
        //The string "kjisl.22" would match. The string "f5.12a" would not.
        String challenge7 = "abcd.135";
        String regExp7 = "^\\w+\\.\\d+$"; //  "^[A-Z][a-z]+\\.\\d+$"
        System.out.println(challenge7.matches(regExp7));

        //Modify the regExp in challenge7 to use a group, so that we can print all the digits that occur in a string that contains multiple occurrences of the pattern.
        //Write all the code required to accomplish this. Use the following string to test your code : String challenge8 = "abcd.135uvqz.7tzik.999";.
        //There are three occurrences of the pattern we looked for in challenge7. When you run your code, you should see 135, 7 and 999 printed to the console.
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String regExp8 = "[A-Za-z]+\\.(\\d+)"; // "(\\w+)\\.(\\d+)"
        Pattern pattern8 = Pattern.compile(regExp8);
        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()) {
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        //Let's suppose that we're reading strings that match the patterns were used in challenge 7 and 8 from a file. Tabs are used to separate the matches, with one exception.
        //The last match is followed by a new line. Our revised challenge 8 string is going to look like this :
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regExp9 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern9 = Pattern.compile(regExp9);
        Matcher matcher9 = pattern9.matcher(challenge9);
        while (matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        //instead of printing out the numbers themselves, print out their start and end indices. So, use the same string we used for challenge nine here, you want to make those indices inclusive.
        //So, for example, the start index printed for 135 should be five,and the index should be seven.
        //That's a hint here, you'll need to look at the documentation for the matcher dot start and matcher.in methods.
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regExp10 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern10 = Pattern.compile(regExp10);
        Matcher matcher10 = pattern10.matcher(challenge10);
        while (matcher10.find()) {
            System.out.println("Occurrence: start= " + matcher10.start(1) + ", end= " + (matcher10.end(1)-1));
        }

        //Suppose we have the following string containing points on a graph within curly braces. Extract what's in the curly braces.
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";
        String regExp11 = "\\{(\\d+, \\d+)\\}";
//        String regExp11 = "\\{(.+?)\\}";
        Pattern pattern11 = Pattern.compile(regExp11);
        Matcher matcher11 =  pattern11.matcher(challenge11);
        while (matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(1));
        }

        //Write a regExp that will match a 5-digit US zip code. Use "11111" as your test string.
        String challenge12 = "11111";
        String regExp12 = "^\\d{5}$";
        System.out.println(challenge12.matches(regExp12));

        //US zip code can be followed by a dash and another four numbers. Write a regExp that will match those zip codes.
        String challenge13 = "11111-1111";
        String regExp13 = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge13.matches(regExp13));

    }
}


























