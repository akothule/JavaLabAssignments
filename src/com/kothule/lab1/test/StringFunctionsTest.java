package com.kothule.lab1.test;

import com.kothule.lab1.StringFunctions;

public class StringFunctionsTest {
    public static void main(String[] args){
        testSpaceCount();
        testVowelCount();
        testLetterCount();
        testDuplicate();
        testBeforeString();
        testAfterString();
        testCapVowel();
        testCapFirstWord();
        testIsVowel();
        testReverse();
    }
    public static void testSpaceCount(){
        System.out.println("spaceCount(`Hello World!`) = " + StringFunctions.spaceCount("Hello World!"));
    }
    public static void testVowelCount(){
        System.out.println("vowelCount(`Hello World!`) = " + StringFunctions.vowelCount("Hello World!"));
    }
    public static void testLetterCount(){
        System.out.println("letterCount(`Hello World!`, 'o') = " + StringFunctions.letterCount("Hello World!", "o"));
    }
    public static void testDuplicate(){
        System.out.println("duplicate(`Hello World!`, 'e') = " + StringFunctions.duplicate("Hello World!", "e"));
    }
    public static void testBeforeString(){
        System.out.printf("beforeString(`Hello World!`, 'Wo') = '%s'\n", StringFunctions.beforeString("Hello World!", "Wo"));
    }
    public static void testAfterString(){
        System.out.printf("afterString(`Hello World!`, 'Wo') = '%s'\n", StringFunctions.afterString("Hello World!", "Wo"));
    }
    public static void testCapVowel(){
        System.out.printf("capVowel(`Hello World!`) = '%s'\n", StringFunctions.capVowel("Hello World!"));
    }
    public static void testCapFirstWord(){
        System.out.printf("capFirstWord(\"hello. my name is ayush. goodbye.\") = '%s'\n", StringFunctions.capFirstWord("hello. my name is ayush. goodbye."));
    }
    public static void testIsVowel(){
        System.out.printf("isVowel(\"a\") = %b\n", StringFunctions.isVowel("a"));
    }
    public static void testReverse(){
        System.out.printf("reverse(\"Hello\") = %s\n", StringFunctions.reverse("Hello"));
    }

}
