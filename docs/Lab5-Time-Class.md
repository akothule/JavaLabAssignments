# Lab5: Time Class

**Notes:** 12AM is midnight. You decide whether hours will be 0-11 or 1-12.


1. Create a Time class with int h,m,s, boolean isAM (where if isAM is false, then it is PM), and 2 constructors (you may assume all arguments will be proper, within their respective ranges), 1 empty constructor, and 1 four argument constructor.
Include the following comments:
```java
// Instance Variables
// Constructors
```

```java
//Insert Code with comments here:
//1-12
public class Time {
   //instance variables
   public int h, m, s;
   public boolean isAM;
   
   //constructors
   public Time(){
       h = 0;
       m = 0;
       s = 0;
       isAM = true;
   }
   public Time(int hour, int minute, int second, boolean am){
       h = hour;
       m = minute;
       s = second;
       isAM = am;
   }
}
```

**In Main class:**

2. Create a timeToString() function in the Main class. Sample return: "12:01:23 AM"

```java
//Insert Code with comments here:
public static String timeToString(Time t){
   StringBuffer sb = new StringBuffer("");
   //add hours
   sb.append(t.h);
   sb.append(":");
   //add minutes
   //add the 0 if its less than 10
   if(t.m < 10){
       sb.append("0");
   }
   sb.append(t.m);
   sb.append(":");
   //add seconds
   //add the 0 if its less than 10
   if(t.s < 10){
       sb.append("0");
   }
   sb.append(t.s);
   //add AM or PM
   if(t.isAM){
       sb.append("AM");
   } else {
       sb.append("PM");
   }
   return sb.toString();
}
```

3. Create an int timeToSeconds() function that takes a Time and returns how many seconds into the day it is, where midnight = 0, 12:01:01AM = 61, etc.

```java
//Insert Code with comments here:
public static int timeToSeconds(Time t){
   int seconds = 0;
   //first add the hours but not if its 12
   //mod by 12 so that it acts normally except for 12, where it adds 0;
   seconds += (t.h % 12) * 3600;
   //next add the minutes
   seconds += t.m * 60;
   //then add the seconds
   seconds += t.s;
   //if it is pm, add 12 more hours or 3600 more seconds
   if(!t.isAM){
       seconds += 3600;
   }
   return seconds;
}
```

4. In the main() function, write code that answers the question, if school starts at 8:30:00 AM and ends at 3:06:00 PM, how many seconds are there in the school day?

```java
//Insert Code with comments here:
public static void main(String[] args) {
   //initialize the times
   //8:30:00 AM
   Time start = new Time(8, 30, 0, true);
   //3:06:00 PM
   Time end = new Time(3, 6, 0, false);
   //convert them in seconds
   int startSeconds = timeToSeconds(start);
   int endSeconds = timeToSeconds(end);
   //subtract start from end to get amount of time in between
   int rv = endSeconds - startSeconds;
   System.out.println("The amount of time between 8:30:00 AM and 3:06:00 PM is " + rv + "seconds.");
}

```