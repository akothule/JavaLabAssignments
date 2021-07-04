/*
 * Copyright (c) 2021. Ayush Kothule
 */

package com.kothule.lab2;

public class Poker {
    /**
     * takes an int card (1-52), and returns its face. You should return an int from 1-13 where:
     *  1 = A, 2 = 2, 3 = 3, ... , 10 = 10, 11 = J, 12 = Q, 13 = K.
     * @param card
     * @return
     */
    public static int face(int card){
        //check if card is out of bounds
        if(card < 1 || card > 52){
            return 0;
        }
        //subtract 1 from card to include multiples of 13
        //add 1 so that it matches up with the desired output
        return (card - 1) % 13 + 1;
    }
}
