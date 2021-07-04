# Lab6: Date Class

### Part 1: 
Create a Date class that has int month, day, year. Include 2 constructors.
```java
//Insert Code with comments here:
//instance variables
public int month, day, year;
//constructors
public Date(){
   month = 0;
   day = 0;
   year = 0;
}
public Date(int m, int d, int y){
   month = m;
   day = d;
   year = y;
}
```

### Part 2:
In the Date class, create the following functions:
```java
public static String monthName(Date d);
public static String dateToString(Date d); // January 1, 2020
```

```java
//Insert Code with comments here:
public static String monthName(Date d){
   //create a string array of months
   String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
           "September", "October", "November", "December"};
   //return the month. subtract by 1 because index goes from 0-11 and months go from 1-12
   return months[d.month - 1];
}
public static String dateToString(Date d){
   //create a string buffer
   StringBuffer sb = new StringBuffer("");
   //create a string array of months
   String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
           "September", "October", "November", "December"};
   //add months
   sb.append(months[d.month - 1]);
   //add days
   sb.append(" " + d.day);
   //add years
   sb.append(", " + d.year);
   return sb.toString();
}
```

###Part 3: 
In the Main class, create a `main()` function that creates and prints your birthday by using the dateToString function like this:
    `System.out.println(Date.dateToString(d));`

```java
//Insert Code with comments here:
Date d = new Date(9, 14, 2004);
System.out.println("Partner's birthday: " + Date.dateToString(d));

```
###Part 4: 
In the Main class, create the following 2 functions:
```java
// Every year that is exactly divisible by four is a leap year, except for years that are exactly 
// divisible by 100, but these centurial years are leap years if they are exactly divisible by 400.
public static boolean isLeapYear(Date d);
```
```java
//Insert Code with comments here:
public static boolean isLeapYear(Date d){
   // Every year that is exactly divisible by four is a leap year, except for years that are exactly
   // divisible by 100, but these centurial years are leap years if they are exactly divisible by 400.
   //checks if divisible by 400 so it can return true right away
   boolean leap = d.year % 400 == 0;
   if(leap){
       return leap;
   } else {
       //true if divisible by 4 and not divisible by 100
       leap = d.year % 4 == 0 && d.year % 100 != 0;
   }
   return leap;
}

```

// Do account for leap years. Ex, daysBetween(Jan 1 2019, Jan 3 2019) => 2.
`public static int daysBetween(Date d1, Date d2);`

```java
//Insert Code with comments here:
public static int daysBetween(Date d1, Date d2){
   //initialize the number of days as a variable
   int days = 0;
   //number of days in each month
   int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   //find how many days passed since the beginning of that year to d1
   int start = 0;
   if(d1.month == 1) {
       for (int i = 0; i < d1.month - 1; i++) {
           start += daysInMonth[i];
       }
   }
   start += d1.day;
   //add the leap year if it already passed
   if(d1.month > 2 && isLeapYear(d1)){
       start++;
   }
   //find how many days passed since beginning of that year to d2
   int end = 0;
   if(d1.month == 1) {
       for (int i = 0; i < d2.month - 1; i++) {
           end += daysInMonth[i];
       }
   }
   //subtract the extra 31 days if necessary
   if(d2.month < d1.month){
       end -= 31;
   }
   end += d2.day;
   //add the previous years
   end += (d2.year - d1.year) * 365;
   //add the leap years in between if any
   //placeholder variable for year
   Date y = d1;
   for(int i = d1.year; i < d2.year; i++){
       d1.year++;
       if(isLeapYear(y)){
           end++;
       }
   }
   //add the leap year if it already passed
   if(d2.month > 2 && isLeapYear(d2)){
       end++;
   }
   //subtract end from start to get whats in between
   days = end - start;
   return days;
}
```

###Part 5: 
In the Main class, create test code for daysBetween that tests for:

a. The second month comes before the first month.\
b. Two dates within the same year that happens to be a leap year.\
c. 2 dates at least 5 years apart.
```java
//Insert Code with comments here:
//a.
Date d1 = new Date(4, 1, 2019);
Date d2 = new Date(3, 3, 2020);
System.out.println(Date.dateToString(d1));
System.out.println(Date.dateToString(d2));
System.out.println("Days in between: " + daysBetween(d1, d2));

//b.
Date d1 = new Date(3, 1, 2020);
Date d2 = new Date(3, 3, 2020);
System.out.println(Date.dateToString(d1));
System.out.println(Date.dateToString(d2));
System.out.println("Days in between: " + daysBetween(d1, d2));

//c.
Date d1 = new Date(1, 1, 2010);
Date d2 = new Date(3, 3, 2020);
System.out.println(Date.dateToString(d1));
System.out.println(Date.dateToString(d2));
System.out.println("Days in between: " + daysBetween(d1, d2));

```

###Part 6: 
Compute how old you are in minutes.
```java
//Insert Code with comments here:
Date d = new Date(12, 4, 2004);
//get days
int minutes = daysBetween(d, new Date());
//convert to minutes
minutes *= 60 * 24;
System.out.println("My partner is " + minutes + " minutes old.");
```