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

    /**
     * takes an int card (1-52), and returns its suit. You should return an int from 1-4 where:
     * 1 = Spade, 2 = Heart, 3 = Clover, 4 = Diamond
     * @param card
     * @return
     */
    public static int suit(int card){
        //check if card is out of bounds
        if(card < 1 || card > 52){
            return 0;
        }
        //subtract 1 from card to include multiples of 13
        //add 1 so that it matches up with the desired output
        return (card - 1) / 13 + 1;
    }

    /**
     *
     * takes an int card (1-52), and returns a nice looking String.
     * Used A, J, Q, K for face.
     * Used X instead of 10.
     * @param card
     * @return
     */
    public static String cardToString(int card){
        StringBuffer sb = new StringBuffer("");
        //add the suit of the card
        //convert the suit number into letter
        //create an array of suits
        String[] suits = {"S", "H", "C", "D"};
        sb.append(suits[suit(card) - 1]);
        //add the face of the card
        //convert 1, 10, 11, 12, 13 face numbers into letters
        //create an array of special faces
        String[] faces = {"X", "J", "Q", "K"};
        if(face(card) == 1){
            sb.append("A");
        } else if(face(card) >= 10){
            sb.append(faces[face(card) - 10]);
        } else {
            sb.append(face(card));
        }
        return sb.toString();
    }

    /**
     * takes an int[] of cards, and returns a nice looking String.
     * @param cards
     * @return
     */
    public static String cardsToString(int[] cards){
        //check for null array
        if(cards == null){
            return "[]";
        }
        //string buffer with open brackets
        StringBuffer sb = new StringBuffer("[");
        //add the individual string cards to the string buffer
        for(int i = 0; i < cards.length; i++){
            sb.append(cardToString(cards[i]));
            //add a comma after all of the cards except the last one
            if(i != cards.length - 1){
                sb.append(", ");
            }
        }
        //add close bracket
        sb.append("]");
        return sb.toString();
    }

    /**
     * takes a 52 element int[] of cards called deck, and shuffles it.
     * @param deck
     */
    public static void shuffle(int[] deck){
        //temporary variable for swapping the values
        int storage = 0;
        //random integer
        int randomInt;
        for(int i = 0; i < deck.length; i++){
            //set the variable equal to a random integer every time
            randomInt = (int) (Math.random() * (deck.length));
            //store the original deck[i] in storage
            //swap deck[i] and deck[randomInt]
            storage = deck[i];
            deck[i] = deck[randomInt];
            deck[randomInt] = storage;
        }
    }

    /**
     * creates a 52 element shuffled int[] of cards.
     * @return
     */
    public static int[] createShuffledDeck(){
        //create a deck
        int[] deck = new int[52];
        //make each item their respective index + 1 to avoid repetition
        for(int i = 0; i < deck.length; i++){
            deck[i] = i+1;
        }
        //shuffle deck
        shuffle(deck);
        return deck;
    }

    /**
     * returns the next card in the deck.
     * set their spot in the deck to 0
     * @param deck
     * @return
     */
    public static int nextCard(int[] deck){
        int rv = 0;
        //go through deck looking for nonzero element
        for(int i = 0; i < deck.length; i++){
            if(deck[i] != 0){
                //set rv equal to first nonzero element
                rv = deck[i];
                //set that nonzero element to 0
                deck[i] = 0;
                break;
            }
        }
        return rv;
    }
}
