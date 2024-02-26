package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Reply;
import com.example.top_trumps_start_code.models.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TopTrumpsService {
    private ArrayList<Card> deck = new ArrayList<>();
    public TopTrumpsService(){
    }

    public Reply startGame(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
        return new Reply("New game with a deck of " + deck.size() + " cards created!");
    }

    public Reply checkWinner(ArrayList<Card> cards){
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        int firstCardValue = card1.getCardValue();
        int secondCardValue = card2.getCardValue();
        int indexCard1 = -1;
        int indexCard2 = -1;

        
        for(Card card : deck){
            if ((card.getRank() == card1.getRank()) && (card.getSuit() == card1.getSuit())){
                indexCard1 = deck.indexOf(card);
            }
            if (card.getRank() == card2.getRank() && card.getSuit() == card2.getSuit()){
                indexCard2 = deck.indexOf(card);
            }

        }

        if(indexCard1 == -1 || indexCard2 == -1){
            return new Reply("Card already Played");
        } else{
            deck.remove(indexCard1);
            deck.remove(indexCard2);
        }



        if(firstCardValue == secondCardValue){
            return new Reply("It's a draw!");
        }
        else if(firstCardValue < secondCardValue){
            return new Reply(card2.getRank() + " of " + card2.getSuit() + " wins!");
        } else {
            return new Reply(card1.getRank() + " of " + card1.getSuit() + " wins!");
        }


    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
