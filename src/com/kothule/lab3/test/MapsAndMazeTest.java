/*
 * Copyright (c) 2021. Ayush Kothule
 */

package com.kothule.lab3.test;

import com.kothule.lab3.MapsAndMaze;

public class MapsAndMazeTest {
    public static void main(String[] args) {
        testCreateMap1();
        testCreateMap2();
        testCreateMapWalls();
        testGetSymbol();
        testMapToString();
        testFind();
        testCanGoN();
        testCanGoS();
        testCanGoE();
        testCanGoW();
        testMinPath();
        testCreate3dMap1();
        testCreate3dMap2();
    }

    public static void testCreateMap1(){
        MapsAndMaze.printMap(MapsAndMaze.createMap(10, 10));
    }

    public static void testCreateMap2(){
        MapsAndMaze.printMap(MapsAndMaze.createMap());
    }

    public static void testCreateMapWalls(){
        MapsAndMaze.printMap(MapsAndMaze.createMap(10));
    }

    public static void testGetSymbol(){
        for(int i = 0; i <= 5; i++) {
            System.out.println(MapsAndMaze.getSymbol(i));
        }
    }

    public static void testMapToString(){
        System.out.println(MapsAndMaze.mapToString(MapsAndMaze.createMap()));
    }

    public static void testFind(){
        System.out.println("find(createMap(), 2) = " + MapsAndMaze.find(MapsAndMaze.createMap(), 2));
    }

    public static void testCanGoN(){
        System.out.println("canGoN(createMap()) = " + MapsAndMaze.canGoN(MapsAndMaze.createMap()));
    }

    public static void testCanGoS(){
        System.out.println("canGoS(createMap()) = " + MapsAndMaze.canGoS(MapsAndMaze.createMap()));
    }

    public static void testCanGoE(){
        System.out.println("canGoE(createMap()) = " + MapsAndMaze.canGoE(MapsAndMaze.createMap()));
    }

    public static void testCanGoW(){
        System.out.println("canGoW(createMap()) = " + MapsAndMaze.canGoW(MapsAndMaze.createMap()));
    }

    public static void testMinPath(){
        System.out.println("minPath(createMap()) = " + MapsAndMaze.minPath(MapsAndMaze.createMap()));
    }

    public static void testCreate3dMap1(){
        System.out.println(MapsAndMaze.mapToString(MapsAndMaze.create3dMap(5, 5, 5)));
    }

    public static void testCreate3dMap2(){
        System.out.println(MapsAndMaze.mapToString(MapsAndMaze.create3dMap()));
    }

    public static void testCreate3dMapFloors(){
        System.out.println(MapsAndMaze.mapToString(MapsAndMaze.create3dMap(10)));
    }

    public static void testCanGoU(){
        System.out.println("canGoU(create3dMap(10) = " + MapsAndMaze.canGoU(MapsAndMaze.create3dMap(10)));
    }

    public static void testCanGoD(){
        System.out.println("canGoD(create3dMap(10) = " + MapsAndMaze.canGoD(MapsAndMaze.create3dMap(10)));
    }
}
