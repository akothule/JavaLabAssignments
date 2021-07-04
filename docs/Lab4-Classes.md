# Lab4:  Classes

### Objective: Learn to create descriptive well structured classes(data types)

### Vocabulary:
* Primitives: ints and doubles
* Naming convention for Classes are Upper Case for all words (ComplexNumber)


### Part 1: These classes use Primitives. Create classes for:

* Money
* ComplexNumber (a + bi, where you store a and b, but not the i)
* DateClass
* Fraction
* Point

**CreditCardAccount:** 
(What&#39;s included in creating a credit card account?)
* First Name
* Last Name 
* Account Number
* Bank Name
* Amount of $
* CVC number
* Expiration date
* Type (visa, mc)

```java
public class Money {
   int dollars;
   int cents;
   public Money(int d, int c){
       dollars = d;
       cents = c;
   }
}
public class ComplexNumber {
   int a;
   int b;
   public ComplexNumber(int constantA, int constantB){
       a = constantA;
       b = constantB;
   }
}
public class DateClass {
   int month;
   int day;
   int year;
   public DateClass(int m, int d, int y){
       month = m;
       day = d;
       year = y;
   }
}
public class Fraction {
   int numerator;
   int denominator;
   public Fraction(int n, int d){
       numerator = n;
       denominator = d;
   }
}
public class Point {
   double x;
   double y;
   public Point(double coordX, double coordY){
       x = coordX;
       y = coordY;
   }
}
public class CreditCardAccount{
   String firstName;
   String lastName;
   int accountNumber;
   String bankName;
   double amountOfMoney;
   int cvcNumber;
   DateClass expirationDate;
   String type;
}
```
---
### Part 2: Money functions.
In the Main class, create the following functions:
```java
public static String moneyToString(Money m); // Returns a nice looking String such as &quot;$1.23&quot;
public static Money add(Money m1, Money m2); // Returns the sum of 2 Money objects
public static Money payWith20(Money m);
public static Money applyInterest(Money m, double interestRate);
```
```java
// Returns a nice looking String such as "$1.23"
public static String moneyToString(Money m){
   //make a string buffer
   StringBuffer sb = new StringBuffer("$" + m.dollars + ".");
   //if cents are less than 10, then add a 0 before it
   if(m.cents < 10){
       sb.append("0" + m.cents);
   } else {    //else add cents normally
       sb.append(m.cents);
   }
   return sb.toString();
}
// Returns the sum of 2 Money objects
public static Money add(Money m1, Money m2){
   //null checks
   if(m1 == null && m2 == null){
       return new Money(0, 0);
   } else if(m1 == null && m2 != null){
       return m2;
   } else if(m1 != null && m2 == null){
       return m1;
   }
   //make a new money that contains the sum
   Money m3 = new Money(m1.dollars + m2.dollars, m1.cents+ m2.cents);
   //while cents is greater than or equal to 100, subtract 100 from cents and add 1 to dollars
   while (m3.cents >= 100){
       m3.cents -= 100;
       m3.dollars++;
   }
   return m3;
}
// Subtracts m from $20
public static Money payWith20(Money m){
   //subtract dollars from 19 and cents from 100
   Money change = new Money(19 - m.dollars, 100 - m.cents);
   //if there are too many cents, then subtract 100 from it and add 1 to dollars
   if(change.cents >= 100){
       change.cents -= 100;
       change.dollars++;
   }
   return change;
}
// Applies interest to m
public static Money applyInterest(Money m, double interestRate){
   //put money in cents
   int moneyInCents = m.dollars * 100 + m.cents;
   //add money times interest rate and divide whole thing by 100
   moneyInCents += (moneyInCents * interestRate)/100;
   //dollars is moneyInCents divided by 100
   //cents is moneyInCents modded by 100
   Money rv = new Money(moneyInCents/100, moneyInCents % 100);
   return rv;
}
```

---

### Part 3: Money tasks
Create a function in the Main class called testCodeMoney(), and do the following:

a. Create a 100 element array of Money objects with values $0.01 - $1.00, and compute the sum.

```java
//A. 
//make an array
Money[] array = new Money[100];
//for each element except the last, make the dollars 0 and the cents whatever the index of the element is plus 1
for(int i = 0; i < array.length - 1; i++){
   array[i] = new Money(0, i + 1);
}

//make the last element dollars 1 and cents 0
array[array.length - 1] = new Money(1, 0);

//add them up
//initialize a money sum variable
Money sum = new Money(0, 0);
//make sum the sum of each element plus the sum
for(int i = 0; i < array.length; i++){
   sum = add(sum, array[i]);
}
System.out.println("3a: Sum = " + moneyToString(sum));
```

b. Simulate a person depositing $10 per day over the course of a year into a bank account that pays 1% interest monthly (round down) at the end of each month. How much has the person saved?
```java
//B.
//the original amount you would have if you didnt deposit any money
Money originalAmount = new Money(3650, 0);
//bank account
Money bankAccount = new Money(0,0);
//January
for(int i = 0; i < 31; i++){
   bankAccount.dollars += 10;
}
bankAccount = applyInterest(bankAccount, 1);
//February
for(int i = 0; i < 28; i++){
   bankAccount.dollars += 10;
}
bankAccount = applyInterest(bankAccount, 1);
//March to December
//repeats 2 times
//first is for March to July
//second is for August to December
for(int i = 0; i < 2; i++){
   //for loop for each month
   for(int j = 1; j <= 5; j++){
       //deposit money in bank
       //j%2 lets for loop alternate between 30 and 31
       for(int k = 0; k < 30 + (j % 2); k++){
           bankAccount.dollars += 10;
       }
       //apply interest at end of month
       bankAccount = applyInterest(bankAccount, 1);
   }
}
Money moneySaved = subtract(bankAccount, originalAmount);
System.out.println("3b: Money Saved = " + moneyToString(moneySaved));
//helper function for testCodeMoney()
// Returns the difference of 2 Money objects
public static Money subtract(Money m1, Money m2){
   //make a new money that contains the difference
   Money m3 = new Money(m1.dollars - m2.dollars, m1.cents - m2.cents);
   //while cents is greater than or equal to 100, subtract 100 from cents and add 1 to dollars
   while (m3.cents < 0){
       m3.cents += 100;
       m3.dollars--;
   }
   return m3;
}
```


c. Go to safeway.com, pick 5 items to purchase, and compute the change if you pay with $20. Remember to apply San Ramon&#39;s city sales tax rate which you can find on bing.com.

```java
//C.
//what im buying
Money avocado = new Money(2,50);
Money strawberries = new Money(4,99);
Money apple = new Money(1,50);
Money potato = new Money(1,11);
Money broccoli = new Money(2,2);
Money[] items = new Money[]{avocado, strawberries, apple, potato, broccoli};
//add the cost up
Money price = new Money(0, 0);
for(int i = 0; i < items.length; i++){
   price = add(price, items[i]);
}
//calculate cost with tax
Money cost = applyInterest(price, 8.25);
//change
Money change = payWith20(cost);
System.out.println("My change: " + moneyToString(change));

```
---
### Part 4: Point functions

In the Main class, create the following functions:
```java
public static String pointToString(Point p); // Returns a nice looking String such as &quot;(1,2)&quot;
public static Point midpoint(Point p1, Point p2); // Returns the midpoint between 2 Points
public static boolean isEqual(Point p1, Point p2);
public static int quadrant(Point p);
public static void verticalStretch(Point p, double a); // Stretch up and down
public static void horizontalStretch(Point p, double a); // Stretch left and right
public static void verticalShift(Point p, double a); // Shift up and down
public static void horizontalShift(Point p, double a); // Shift left and right
```

```java
// Returns a nice looking String such as "(1,2)"
public static String pointToString(Point p){
   return "(" + p.x + ", " + p.y + ")";
}
// Returns the midpoint between 2 Points
public static Point midpoint(Point p1, Point p2){
   double x = (p1.x + p2.x) / 2;
   double y = (p1.y + p2.y) / 2;
   return new Point(x, y);
}
//returns whether or not the 2 points are equal
public static boolean isEqual(Point p1, Point p2){
   return (p1.x == p2.x && p1.y == p2.y);
}
//returns which quadrant Point p is in
public static int quadrant(Point p){
   if(p.x > 0 && p.y > 0){
       //if both x and y are positive, then point is in first quadrant
       return 1;
   } else if(p.x < 0 && p.y > 0){
       //if x is negative and y is positive, then point is in second quadrant
       return 2;
   } else if(p.x < 0 && p.y < 0){
       //if both x and y are negative, then point is in third quadrant
       return 3;
   } else if(p.x > 0 && p.y < 0){
       //if x is positive and y is negative, then point is in fourth quadrant
       return 4;
   } else {
       //if the point is the center (0, 0)
       return 0;
   }
}
// Stretch up and down
public static void verticalStretch(Point p, double a){
   //stretch the point vertically by a
   p.y *= a;
}
// Stretch left and right
public static void horizontalStretch(Point p, double a){
   //stretch the point horizontally by a
   p.x *= a;
}
// Shift up and down
public static void verticalShift(Point p, double a){
   //shift the point vertically by a
   p.y += a;
}
// Shift left and right
public static void horizontalShift(Point p, double a){
   //Shift the point horizontally by a
   p.x += a;
}


```
---
### Part 5: Point tasks

Create a function in the Main class called testCodePoint(), and do the following:

a. Create a 5 element array of Points where the domain are the even integers between 2-10, and the mapping to the range is $f(x) = 2x+3$ 

```java
//A.

//create an array
Point[] line = new Point[5];
//add the points
for(int i = 0; i < line.length; i++){
   //gets even numbers from 2-10
   line[i] = new Point(2 * i + 2, 2 * (2 * i + 2) + 3);
}
System.out.println("A: " + pointArrayToString(line));
```

b. Perform a vertical stretch by a factor of 3 to each point (using a for loop) and print the results.
```java
//B.

for(int i = 0; i < line.length; i++){
   //vertically stretch each point by 3
   verticalStretch(line[i], 3);
}
System.out.println("B: " + pointArrayToString(line));

```

c. Perform a horizontal stretch by a factor of 2 to each point (using a for loop) and print the results.

```java
//C.

for(int i = 0; i < line.length; i++){
   //horizontally stretch each point by 2
   horizontalStretch(line[i], 2);
}
System.out.println("C :" + pointArrayToString(line));
```

d. Perform a vertical shift down 1 unit and print the results.

```java
//D.

for(int i = 0; i < line.length; i++){
   //vertically shift each point 1 unit down
   verticalShift(line[i], -1);
}
System.out.println("D: " + pointArrayToString(line));
```

e. Perform a horizontal shift right 2 units and print the results.

```java
//E.

for(int i = 0; i < line.length; i++){
   //horizontally shift each point 2 units to the right
   horizontalShift(line[i], 2);
}
System.out.println("E: " + pointArrayToString(line));
```

f. Simulate sine by an array of Points (0,?), (1.57,?),(3.14,?),(4.71,?),(6.28,?)
```java
//F.

//create the array
Point[] sin = new Point[5];
//plot the points
sin[0] = new Point(0,0);
sin[1] = new Point(1.57, 1);
sin[2] = new Point(3.14, 0);
sin[3] = new Point(4.71, -1);
sin[4] = new Point(6.28, 0);
System.out.println("F: " + pointArrayToString(sin));

```

g. Perform a vertical shift by 2, then a stretch by 2, and print the results.
```java
//G.

for(int i = 0; i < sin.length; i++){
   verticalShift(sin[i], 2);
   verticalStretch(sin[i], 2);
}
System.out.println("G: " + pointArrayToString(sin));
```

h. Perform a vertical stretch by 2, then a shift by 2, and print the results.

```java
//H.

for(int i = 0; i < sin.length; i++){
   verticalStretch(sin[i], 2);
   verticalShift(sin[i], 2);
}
System.out.println("H: " + pointArrayToString(sin));

```

Helper function for printing a Point array

```java
public static String pointArrayToString(Point[] p){
   StringBuffer sb = new StringBuffer("");
   for(int i = 0; i < p.length; i++){
       sb.append(pointToString(p[i]));
       if(i != p.length - 1){
           sb.append(", ");
       }
   }
   return sb.toString();
}

```