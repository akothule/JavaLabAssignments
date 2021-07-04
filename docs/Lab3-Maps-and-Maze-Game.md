# Lab3: Maps and Maze Game

**Terminology:**

A Map is going to be represented by a 2d array of ints where 0 represents an empty spot, 1 represents you, 2 represents the finish line or goal, and 3 represents a wall or obstacle.

**Task 1: Create the following Map constructor functions:**

`// Creates an empty map with r rows and c columns.`

`public static int[][] createMap(int r, int c);`

```java
public static int[][] createMap(int r, int c){
   //return a new 2D array with r rows and c columns
   return new int[r][c];
}
```
---

```java
// Creates a map with the following layout, where "Y" = you, "F" = 
// finish line, and * represents wall, and _ represents empty:
//    Y * _ _ _ _ _ _ _ _
//    _ * _ * _ * _ * * _
//    _ _ _ * _ _ _ * _ _
//    * _ * _ * * * _ _ *
//    _ _ _ _ _ _ * _ * _
//    _ * * * _ _ _ * _ _
//    _ _ _ _ * * _ _ _ *
//    _ * _ _ * _ * _ * _
//    _ _ _ * _ _ _ _ _ _
//    _ * _ _ * _ _ * _ F
```
`public static int[][] createMap();`
```java
public static int[][] createMap(){
   //create a 10x10 2D array
   int[][] map = new int[10][10];
   //define the constants
   int SPACE = 0;  //"SPACE" = "0" = empty spot
   int YOU = 1;    //"YOU" = "1" = you
   int GOAL = 2;   //"GOAL" = "2" = finish line
   int WALL = 3;   //"WALL" = "3" = wall
   //first row
   map[0][0] = YOU;
   map[0][1] = WALL;
   for(int i = 2; i < 10; i++){
       map[0][i] = SPACE;
   }
   //second row
   //if i is even, put a space. else, put a wall except for 8 and 9 element
   for(int i = 0; i < 10; i++){
       boolean even = (i % 2 == 0);
       if(i >= 8) {
           //using a ternary operator to flip the value of even variable
           even = (even?false:true);
       }
       //if i is even, put a space. else, put a wall
       if (even) {
           map[1][i] = SPACE;
       } else {
           map[1][i] = WALL;
       }
   }
   //third row
   //put 3 spaces followed by a wall
   int spaceCount = 0;
   for(int i = 0; i < 10; i++){
       if(spaceCount < 3){
           map[2][i] = SPACE;
           spaceCount++;
       } else {
           map[2][i] = WALL;
           spaceCount = 0; //reset the space counter
       }
   }
   //fourth row
   //divide row into 2 parts, one which alternates between wall and space,
   // and another which alternates between 2 walls and 2 spaces
   for(int i = 0; i < 5; i++){
       if(i % 2 == 0){
           map[3][i] = WALL;
       } else {
           map[3][i] = SPACE;
       }
   }
   for(int i = 5; i < 10; i++){
       //if i % 4 is 1 or 2, put wall. else, put space
       //this makes sure it alternates every 2 elements
       if(i % 4 > 0 && i % 4 < 3){
           map[3][i] = WALL;
       } else {
           map[3][i] = SPACE;
       }
   }
   //fifth row
   //start from the back and alternate between space and wall until 6th element
   //for the rest, put spaces
   for(int i = 9; i >= 0; i--){
       if(i > 5){
           if(i % 2 == 1){
               map[4][i] = SPACE;
           } else {
               map[4][i] = WALL;
           }
       } else {
           map[4][i] = SPACE;
       }
   }
   //sixth row
   //split row into 2 parts
   //put space for first and last element and put walls for rest in the first part
   for(int i = 0; i < 5; i++){
       if(i % 4 == 0){
           map[5][i] = SPACE;
       } else {
           map[5][i] = WALL;
       }
   }
   //put spaces for all of them except the 8th element
   for(int i = 5; i < 10; i++){
       if(i == 7){
           map[5][i] = WALL;
       } else {
           map[5][i] = SPACE;
       }
   }
   //seventh row
   //put spaces for the first 4 elements
   for(int i = 0; i < 4; i++){
       map[6][i] = SPACE;
   }
   //put a wall for the 5th element
   map[6][4] = WALL;
   //put walls for the 6th and 10th element
   //for the rest, put spaces
   for(int i = 5; i < 10; i++){
       if(i % 4 == 1){
           map[6][i] = WALL;
       } else {
           map[6][i] = SPACE;
       }
   }
   //eighth row
   //put space, wall, space and then alternate between space and wall
   for(int i = 0; i < 3; i++){
       if(i % 2 == 0){
           map[7][i] = SPACE;
       } else {
           map[7][i] = WALL;
       }
   }
   for(int i = 3; i < 10; i++){
       if(i % 2 == 1){
           map[7][i] = SPACE;
       } else {
           map[7][i] = WALL;
       }
   }
   //ninth row
   //put spaces for all of them except the 4th element
   //for the 4th element, put a wall
   for(int i = 0; i < 10; i++){
       if(i == 3){
           map[8][i] = WALL;
       } else {
           map[8][i] = SPACE;
       }
   }
   //tenth row
   //alternate between 2 spaces and wall for all elements except last one
   //for the last element, put goal
   int counter = 1;
   for(int i = 0; i < 9; i++){
       if(counter < 2){
           map[9][i] = SPACE;
           counter++;
       } else {
           map[9][i] = WALL;
           counter = 0;
       }
   }
   map[9][9] = GOAL;
   return map;
}
```
---
<pre>
// Creates a 10x10 map where you and the finish line are randomly placed,
// and there are exactly n walls placed randomly throughout the map.
// If this is too hard, you may place you in the upper left, and the finish
// in the bottom right.
</pre>
`public static int[][] createMap(int n);`

```java
public static int[][] createMap(int n){
   int[][] map = createMap(10, 10);
   //"_" = "0" = empty spot
   //"Y" = "1" = you
   //"F" = "2" = finish line
   //"*" = "3" = wall
   //put Y in the first position
   map[0][0] = 1;
   //put F in the last position
   map[9][9] = 2;
   //make a variable which counts the number of walls placed
   int wallCount = 0;
   while(wallCount < n){
       //get random coordinates between 0 and 9
       int i = (int) (Math.random() * 10);
       int j = (int) (Math.random() * 10);
       //if there is nothing there, put a wall and increment wallCount
       if(map[i][j] == 0){
           map[i][j] = 3;
           wallCount++;
       }
   }
   return map;
}
```
---

**Task 2: Create the following utility functions:**

<pre>
// Returns the String representation of the int map element.
// IE, symbol(0) => "_", symbol(1) => "Y", symbol(2) => "F", and symbol(3) => "*"
</pre>
`public static String getSymbol(int value);`
```java
public static String getSymbol(int value){
   //"_" = "0" = empty spot
   //"Y" = "1" = you
   //"F" = "2" = finish line
   //"*" = "3" = wall
   //"U" = "4" = ladder up
   //"D" = "5" = ladder down
   String[] mapSymbols = new String[]{"_", "Y", "F", "*", "U", "D"};
   return mapSymbols[value];
}
```
---
<pre>
// Prints a nice looking map such as the following, with 2 space indentation:
  Y * _ _ _ _ _ _ _ _
  _ * _ * _ * _ * * _
  _ _ _ * _ _ _ * _ _
  * _ * _ * * * _ _ *
  _ _ _ _ _ _ * _ * _
  _ * * * _ _ _ * _ _
  _ _ _ _ * * _ _ _ *
  _ * _ _ * _ * _ * _
  _ _ _ * _ _ _ _ _ _
  _ * _ _ * _ _ * _ F
</pre>
`public static void printMap(int[][] m);`
```java
public static void printMap(int[][] m){
   StringBuffer map = new StringBuffer("");
   for(int i = 0; i < m.length; i++){
       map.append(" ");
       for(int j = 0; j < m[i].length; j++){
           map.append(" " + getSymbol(m[i][j]));
       }
       map.append("\n");
   }
   System.out.println(map);
}
```
---

**// Returns a nice looking map as a String.**

`public static String mapToString(int[][] m);`
```java
public static String mapToString(int[][] m){
   StringBuffer map = new StringBuffer("");
   for(int i = 0; i < m.length; i++){
       map.append(" ");
       for(int j = 0; j < m[i].length; j++){
           map.append(" " + getSymbol(m[i][j]));
       }
       map.append("\n");
   }
   return map.toString();
}
```
---
<pre>
// Returns the coordinates of any instance of value in the Map m.
// Return null if the value cannot be found on the map.
// This function is intended to find unique values only.
// Ex, find( {{0,0,3},{3,3,2},{1,3,0}} , 1) => {2,0}
// Ex, find( {{0,0,3},{3,3,2},{1,3,0}} , 4) => null
</pre>
`public static int[] find(int[][] m, int value);`
```java
public static int[] find(int[][] m, int value){
   //go through entire map and find the value
   for(int i = 0; i < m.length; i++){
       for(int j = 0; j < m[i].length; j++){
           //if you find the value, return the coordinates in an array
           if(value == m[i][j]){
               return new int[]{i, j};
           }
       }
   }
   //the value isnt found, return null
   return null;
}
```
---

// Returns true if you can move north/south/east/west, false otherwise.\
**public static boolean canGoN(int[][] m);**\
**public static boolean canGoS(int[][] m);**\
**public static boolean canGoE(int[][] m);**\
**public static boolean canGoW(int[][] m);**

```java
//Insert Code with comments here:
public static boolean canGoN(int[][] m){
   //initialize an array with coordinates of You
   int[] coord = find(m, 1);

   return  (coord != null) && //make sure coordinates are not null
           (coord[0] != 0) && //Y is not at the first row
           (m[coord[0] - 1][coord[1]] == 0);  //element above Y is an empty space
}
public static boolean canGoS(int[][] m){
   //initialize an array with coordinates of You
   int[] coord = find(m, 1);

   return  (coord != null) && //make sure coordinates are not null
           (coord[0] != 9) && //Y is not at the last row
           (m[coord[0] + 1][coord[1]] == 0);  //element below Y is an empty space
}
public static boolean canGoE(int[][] m){
   //initialize an array with coordinates of You
   int[] coord = find(m, 1);

   return  (coord != null) && //make sure coordinates are not null
           (coord[1] != 9) && //Y is not at the last column
           (m[coord[0]][coord[1] + 1] == 0);  //element right of Y is an empty space
}
public static boolean canGoW(int[][] m){
   //initialize an array with coordinates of You
   int[] coord = find(m, 1);

   return  (coord != null) && //make sure coordinates are not null
           (coord[1] != 0) && //Y is not at the first column
           (m[coord[0]][coord[1] - 1] == 0);  //element left of Y is an empty space
}
```

**Challenge #7:**

Create a function that returns a minimal path from you to finish. A minimal path is any path from you to finish where any other path is the same number of steps or longer. Minimal paths may not exist, and are not guaranteed to be unique. The function interface is left to you.
```java
public static String minPath(int[][] m){
   //string buffer for the path
   StringBuffer path = new StringBuffer("");
   //coordinates for you and the finish line
   int[] coords = find(m, 1);
   int[] finish = find(m, 2);
   //repeat until you are at finish line
   while(coords != finish){
       //if possible, go south
       if(canGoS(m)){
           //moves you south
           m[coords[0] + 1][coords[1]] = 1;
           m[coords[0]][coords[1]] = 0;
           path.append("S");
       } else if(canGoE(m)){ //if south doesnt work, try east
           //moves you east
           m[coords[0]][coords[1] + 1] = 1;
           m[coords[0]][coords[1]] = 0;
           path.append("E");
       } else if(canGoN(m)){ //if east doesnt work, try north
           //moves you north
           m[coords[0] - 1][coords[1]] = 1;
           m[coords[0]][coords[1]] = 0;
           path.append("N");
       } else if(canGoW(m)){ //if north doesnt work, try west
           //moves you west
           m[coords[0]][coords[1] - 1] = 1;
           m[coords[0]][coords[1]] = 0;
           path.append("W");
       }
       //update coordinates
       coords = find(m, 1);
       //if finish line is right of you, add "E" to string and return it
       if(coords[0] == 9 && coords[1] == 8){
           path.append("E");
           return path.toString();
       }
       //if finish line is below you, add "S" to string and return it
       if(coords[0] == 8 && coords[1] == 9){
           path.append("S");
           return path.toString();
       }
   }
   return path.toString();
}
```

---

**Challenge #8:**

Create the groundwork to implement a 3d Maze Game. 4 should represent a ladder up, denoted as &quot;U&quot; when printing, and 5 should represent a ladder down, denoted as &quot;D&quot; when printing.

// Create a blank 3d Map with the given sizes.

**public static int[][][] create3dMap(int r, int c, int numFloors);**

```java
public static int[][][] create3dMap(int r, int c, int numFloors){
   //return a new 3D array with r rows, c columns, and numFloors levels
   return new int[numFloors][r][c];
}
```

// Create an interesting 3d Map with walls and ladders prefabricated, 19x19 base.

**public static int[][][] create3dMap();**
```java
//Insert Code with comments here:
public static int[][][] create3dMap(){
   //create the 3D array
   int[][][] map = new int[10][19][19];
   //put the walls around the edges as you go up
   for(int i = 1; i < map.length; i++){
       for(int j = 0; j < map[i].length; j++){
           for(int k = i; k < map.length; k++) {
               //put walls on the perimeter
               map[k][j][i - 1] = 3;
               map[k][i - 1][j] = 3;
               map[k][map[i].length - i][j] = 3;
               map[k][j][map[i].length - i] = 3;
           }
       }
   }
   //put you in top left corner
   map[0][0][0] = 1;
   //put ladders on each floor
   map[0][3][5] = 4;
   map[1][3][5] = 5;
   map[1][4][7] = 4;
   map[2][4][7] = 5;
   map[2][15][13] = 4;
   map[3][15][13] = 5;
   map[3][4][9] = 4;
   map[4][4][9] = 5;
   map[4][5][6] = 4;
   map[5][5][6] = 5;
   map[5][7][8] = 4;
   map[6][7][8] = 5;
   map[6][11][10] = 4;
   map[7][11][10] = 5;
   map[7][10][8] = 4;
   map[8][10][8] = 5;
   map[8][9][9] = 4;
   //put the finish line
   map[9][9][9] = 2;
   return map;
}
```
---
<pre>
// Create a pyramid with randomized ladders, but no walls, and no finish.
// You always start on the bottom floor in the upper left.
// We will assume the goal is always to get the the very top of the pyramid.
// Ex, the floors of the pyramid might look like this:
Level 1:
  Y _ _ _ _
  _ _ _ _ _
  _ _ _ _ _
  _ _ _ U _
  _ _ _ _ _
Level 2:
  * * * * *
  * _ _ _ *
  * _ U _ *
  * _ _ D *
  * * * * *
Level 3:
  * * * * *
  * * * * *
  * * F * *
  * * * * *
  * * * * *

</pre>

**public static int[][][] create3dMap(int numFloors);**

```java
//Insert Code with comments here:
public static int random(int min, int max){
   //generate values with the min value inclusive and the max exclusive…
   return (int)(Math.random() * (max - min + 1) + min);
}
public static int[][][] create3dMap(int numFloors){
   int[][][] map = new int[numFloors][(2 * numFloors) - 1][(2 * numFloors) - 1];
   int floor = 0;
   //put the walls around the edges as you go up
   for(int i = 1; i < map.length; i++){
       for(int j = 0; j < map[i].length; j++){
           for(int k = i; k < map.length; k++) {
               //put walls on the perimeter
               map[k][j][i - 1] = 3;
               map[k][i - 1][j] = 3;
               map[k][map[i].length - i][j] = 3;
               map[k][j][map[i].length - i] = 3;
           }
       }
   }
   //find the location of the down ladder
   int[] location = find(map[floor], 5);
   while(floor < map.length - 1){
       //random coordinates
       int i = random(floor + 1, map[floor].length - 2 - floor);
       int j = random(floor + 1, map[floor].length - 2 - floor);
       //checks if there is a ladder already there so that they dont overlap
       if(location == null || (location[0] != i && location[1] != j)) {
           map[floor][i][j] = 4;   //"4" = ladder up
           map[floor + 1][i][j] = 5;   //"5" = ladder down
           floor++;
           //update location of down ladder
           location = find(map[floor], 5);
       }
       System.out.println("\tfloor = "+ floor);
   }
   if(location != null) {
       map[map.length - 1][location[0]][location[1]] = 2;
   }
   map[0][0][0] = 1;
   return map;
}

```

**public static boolean canGoU(int[][][] m);**

**public static boolean canGoD(int[][][] m);**

```java
//Insert Code with comments here:
public static boolean canGoU(int[][][] m){
   int floor = 0;
   int[] coords = null;
   int[] downCoords = null;
   for(int i = 0; i < m.length; i++){
       coords = find(m[i], 1);
       if(coords != null){
           //save the floor number
           floor = i;
           break;
       }
   }
   //check if we have a coordinates
   if(coords != null && floor != m.length - 1) {
       //find down coordinates
       downCoords = find(m[floor + 1], 5);
   }
   return (coords != null && downCoords!= null && coords[0] == downCoords[0] && coords[1] == downCoords[1]);
}
public static boolean canGoD(int[][][] m){
   int floor = 0;
   int[] coords = null;
   int[] upCoords = null;
   for(int i = 0; i < m.length; i++){
       coords = find(m[i], 1);
       if(coords != null){
           //save the floor number
           floor = i;
           break;
       }
   }
   //check if we have a coordinates
   if(coords != null && floor > 0) {
       //find up coordinates
       upCoords = find(m[floor - 1], 4);
   }
   return (coords != null && upCoords!= null && coords[0] == upCoords[0] && coords[1] == upCoords[1]);
}


```
---
<pre>
// mapToString() should return a String with that looks like this:
Level 1:
  Y * _ U 
  _ * _ * 
  _ _ _ * 
Level 2:
  _ F * D 
  _ * * _ 
  _ _ _ _ 

</pre>


**public static String mapToString(int[][][] m);**

```java
//Insert Code with comments here:
public static String mapToString(int[][][] m){
   StringBuffer sb = new StringBuffer("");
   for(int i = 0; i < m.length; i++){
       sb.append("Level " + (i + 1) + ":\n");
       sb.append(mapToString(m[i]));
   }
   return sb.toString();
}
```