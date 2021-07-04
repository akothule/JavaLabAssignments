/*
 * Copyright (c) 2021. Ayush Kothule
 */

package com.kothule.lab1;

public class StringFunctions {
    /**
     * Count number of spaces in given string.
     * @param s input string
     * @return number of spaces
     */
    public static int spaceCount(String s){
        //empty string for the substring
        String letter = "";

        //count for spaces
        int count = 0;

        //traverses entire string
        for(int i = 0; i < s.length(); i++){
            //takes one letter
            letter = s.substring(i, i+1);

            //if it is a space, add 1 to count
            if(letter.compareTo(" ") == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * Counts vowels in given string
     * @param s input string
     * @return number of vowels in the string
     */
    public static int vowelCount(String s){
        //String of vowels
        String vowels = "aeiou";

        //empty string for the substring
        String letter = "";

        //count for vowels
        int count = 0;

        //traverses entire string
        for(int i = 0; i < s.length(); i++){
            //takes one letter
            letter = s.substring(i, i+1);

            if(vowels.indexOf(letter) != -1){
                count++;
            }
        }
        return count;
    }

    /**
     * Given a string s and a letter, return the number of times letter appears in s.
     * @param s input string
     * @param letter letter
     * @return number of times the letter appears in a given string.
     */
    public static int letterCount(String s, String letter){
        //empty string for the substring
        String character = "";

        //count for letter
        int count = 0;

        //traverses through entire string
        for(int i = 0; i < s.length(); i++){
            //takes one letter
            character = s.substring(i, i+1);

            //if it is the letter, add 1 to count
            if(character.compareTo(letter) == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * Duplicates a given letter in a string
     * @param s input string
     * @param letter letter to be duplicated
     * @return returns a new string with a duplicate letter
     */
    public static String duplicate(String s, String letter){
        //empty string to add on characters to
        String copy = "";

        //empty string for current character
        String character = "";

        //traverses through entire string
        for(int i = 0; i < s.length(); i++){
            //takes one character of the string
            character = s.substring(i, i+1);

            //adds character to the copy
            copy += character;

            //if the character is the same as the given letter
            //add it again
            if(character.compareTo(letter) == 0){
                copy += character;
            }
        }
        return copy;
    }

    /**
     * Given a string s, return the portion of the string that comes before substr.
     * If substr is not found, return the entire string s. Ex, beforeString("Hello World!","Wo") => "Hello "
     * @param s
     * @param substr
     * @return
     */
    public static String beforeString(String s, String substr){
        //empty string to add on characters to
        String copy = "";

        //empty string for current character
        String character = "";

        //finds where it is in the string
        int index = s.indexOf(substr);

        //if it doesnt exist, make index equal to length of the string so that
        //it will be able to return the whole string
        if(index == -1){
            index = s.length();
        }
        //traverses through the entire string
        for(int i = 0; i < index; i++){
            character = s.substring(i, i+1);
            //adds character to empty string
            copy += character;
        }
        return copy;
    }

    /**
     * Given a string s, return the portion of the string that comes after substr. If substr is not
     * found, return an empty string "". Ex,  afterString("Hello World!","Wo") => "rld!"
     * @param s
     * @param substr
     * @return
     */
    public static String afterString(String s, String substr){
        //empty string to add on characters to
        String copy = "";

        //empty string for current character
        String character = "";

        //finds where it is in the string
        int index = s.indexOf(substr) + substr.length();

        /**
         * if it doesnt exist, make index equal to length of the string so that
         * it will be able to return an empty string
         * condition is -1 + substr.length() because it is checking if s.indexOf(substr) is -1
         */


        if(index == -1 + substr.length()){
            index = s.length();
        }

        //traverses through the entire string
        for(int i = index; i < s.length(); i++){
            character = s.substring(i, i+1);

            //adds character to empty string
            copy += character;
        }
        return copy;
    }

    /**
     * Given a string s, return the string with all vowels capitalized.
     * @param s input string
     * @return returns a new string with all vowels capitalized
     */
    public static String capVowel(String s){
        //define a string of vowels
        String vowels = "aeiou";

        //current character
        String character = "";

        //covert all string to lowercase
        String copy = s.toLowerCase();

        //create a variable for output string.
        String output = "";

        //read each character of a string to check for vowels
        for (int i=0; i < copy.length(); i++){
            //gets current character
            character = s.substring(i, i+1);
            //check if character is in list of vowels.

            if(vowels.indexOf(character) != -1){
                //character is a vowel. Make it uppercase
                output += character.toUpperCase();
            }else{
                //character is not a vowel
                output += character;
            }
        }
        return output;
    }

    /**
     * Given a string s that contains multiple sentences,return the same string except the first word of each sentence is capitalized.
     * You may assume the only characters in the string are letters, numbers, spaces, and periods.
     * Ex, capFirstWord("hello. my name is dave. goodbye.") => "Hello. My name is dave. Goodbye."
     * @param s
     * @return
     */
    public static String capFirstWord(String s){
        //find the position of dot to separate the sentences.
        int dotPos = s.indexOf(".");
        //define an output variable
        String output = "";
        while(dotPos != -1){
            //extract a sentence.
            String sentence = s.substring(0, dotPos + 1);
            //skip the white space if any to capitalize the first character
            int pos = 0;
            for(; pos < sentence.length(); pos++){
                char ch = sentence.charAt(pos);
                if(ch != ' '){
                    output += Character.toString(ch).toUpperCase();
                    //stop processing remaining characters of sentence.
                    break;
                }else{
                    output += ch;
                }
            }
            //add remaining sentence to output
            output += sentence.substring(pos+1);

            //remove first sentence from the input string
            s = s.substring(dotPos + 1);
            dotPos = s.indexOf(".");
        }
        return output;
    }

    /**
     * Assume s is a single letter. Returns true if it's a vowel, false if it's not.
     * @param s
     * @return
     */
    public static boolean isVowel(String s){
        //String of vowels
        String vowels = "aeiou";
        return(vowels.indexOf(s) != -1);
    }

    /**
     * Given a string s, return the string backwards. "Hello" => "olleH".
     * @param s input string
     * @return returns a new string in reverse order of input string.
     */
    public static String reverse(String s){
        //empty string to add on to
        String output = "";

        //starts at end of string and adds each character to output
        for(int i = s.length(); i > 0; i--){
            output += s.substring(i-1, i);
        }
        return output;
    }

}
