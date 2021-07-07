/*
 * Copyright (c) 2021. Ayush Kothule
 */

package com.kothule.lab2.test;

import com.kothule.lab2.Poker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PokerTest {
    public static void main(String[] args) {
        testFace();
        testSuit();
        testCardToString();
        testCardsToString();
        testShuffle();
        testCreateShuffledDeck();
        testNextCard();
    }
    public static void testFace(){
        System.out.println("face(51) = " + Poker.face(51));
    }

    public static void testSuit(){
        System.out.println("suit(27) = " + Poker.suit(27));
    }

    public static void testCardToString(){
        System.out.println("cardToString(16) = " + Poker.cardToString(16));
    }

    public static void testCardsToString(){
        System.out.println("cardsToString(new int[]{1, 32, 48}) = " + Poker.cardsToString(new int[]{1, 32, 48}));
    }

    public static void testShuffle(){
        int[] array = new int[]{1, 2, 3, 4, 5};
        Poker.shuffle(array);
        System.out.println("shuffle(array) = " + Arrays.toString(array));
    }

    public static void testCreateShuffledDeck(){
        System.out.println("createShuffledDeck() = " + Poker.cardsToString(Poker.createShuffledDeck()));
    }

    public static void testNextCard(){
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            if(i < 5) {
                array[i] = 0;
            } else {
                array[i] = i;
            }
        }
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("nextCard(array) = " + Poker.nextCard(array));
        System.out.println("array: " + Arrays.toString(array));
    }
}
