# Lab1: String Functions

**Vocabulary** :

**method-** A function of a specific class. Use methods by calling the object name, the dot operator, then the method name. Ex, str.length().

String methods that you will use in this project:
```Java
String s = "Hello World"; // Use this string for the examples below.
```

| Method Syntax | Example | Notes |
| --- | --- | --- |
| length() | s.length() | Returns a value of 12. Note the difference between length and indexes. |
| substring(int start) | s.substring(6) | Returns the string starting at index start and ending at the end of the string.Returns a value of &quot;World!&quot; Can remove a part of a string (cuts off) |
| substring(int start,int end) | s.substring(4,7) | Returns the string starting at start, and ending BEFORE (ie, it does not include) end.Returns &quot;o W&quot; |
| indexOf(String str) | s.indexOf(&quot;r&quot;) | Returns the index of the first occurrence of the argument.If the argument is not found in the string, the method returns -1.Returns 4 |
| compareTo(String str) | a.compareTo(b) | Returns:neg if a \&lt; b0 if a == bpos if a \&gt; b |
| toUpperCase()toLowerCase() | s.toUpperCase()s.toLowerCase() | Returns &quot;HELLO WORLD!&quot; and &quot;hello world!&quot; |

### Create the following functions:

**Task 1:**
<pre>
int spaceCount(String s); // Given a string s, returns the number of spaces in s.
</pre>
```Java
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
```


**Task 2:**

<pre>
int vowelCount(String s); // Given a string s, returns the number of vowels in s.
</pre>

```Java
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

```

**Task 3:**

<pre>
int letterCount(String s, String letter); // Given a string s and a letter, return the number of times letter appears in s.
</pre>

```java
//Insert Code with comments here:
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
```


####Task 4:
<pre>
String duplicate(String s, String letter);//Hello, e => Heello, Hello, l => Hellllo
</pre>

```java
//Insert Code with comments here:
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
```

####Task 5:
<pre>
String beforeString(String s, String substr); // Given a string s, return the portion of the string that comes before substr. If substr is not found, return the entire string s. Ex, beforeString("Hello World!","Wo") => "Hello "
</pre>

```java
//Insert Code with comments here:
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

```

####Task 6:
<pre>
String afterString(String s, String substr); // Given a string s, return the portion of the string that comes after substr. If substr is not 
found, return an empty string "". Ex,  afterString("Hello World!","Wo") => "rld!"
</pre>
```java
//Insert Code with comments here:
public static String afterString(String s, String substr){
   //empty string to add on characters to
   String copy = "";

   //empty string for current character
   String character = "";

   //finds where it is in the string
   int index = s.indexOf(substr) + substr.length();
   /*
   if it doesnt exist, make index equal to length of the string so that
   it will be able to return an empty string
   condition is -1 + substr.length() because it is checking if s.indexOf(substr) is -1
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

```
####Task 7:
<pre>
String capVowel(String s); // Given a string s, return the string with all vowels capitalized.
</pre>
```java
//Insert Code with comments here:
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
```

####Task 8:
<pre>
String capFirstWord(String s); // Given a string s that contains multiple sentences,return the same string except the first word of each sentence is capitalized. You may assume the only characters in the string are letters, numbers, spaces, and periods. Ex, capFirstWord("hello. my name is dave. goodbye.") => "Hello. My name is dave. Goodbye."
</pre>

```java
//Insert Code with comments here:
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

```
####Task 9:
<pre>
boolean isVowel(String s); // Assume s is a single letter. Returns true if it's a vowel, false if it's not.
</pre>
```java
//Insert Code with comments here:
public static boolean isVowel(String s){
   //String of vowels
   String vowels = "aeiou";
   return(vowels.indexOf(s) != -1);
}
```

####Task 10:
<pre>
String reverse(String s); // Given a string s, return the string backwards. "Hello" => "olleH".
</pre>
```java
//Insert Code with comments here:
public static String reverse(String s){
   //empty string to add on to
   String output = "";

   //starts at end of string and adds each character to output
   for(int i = s.length(); i > 0; i--){
       output += s.substring(i-1, i);
   }
   return output;
}
```