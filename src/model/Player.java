package model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Player implements ICardPublisher {

    private List<Card> m_hand;
    protected final int g_maxScore = 21;
    private ArrayList<ICardObserver> subscribers;

    public Player() {
        m_hand = new LinkedList<Card>();
        subscribers = new ArrayList<>();
    }

    @Override
    public void Subscribe(ICardObserver subscriber) {
        if (subscribers.contains(subscriber) == false) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void Notify(Card card) {
        for (ICardObserver obs : subscribers) {
            obs.updateNewCard(card);
        }
    }

    public void DealCard(Card a_addToHand) {
        Notify(a_addToHand);
        m_hand.add(a_addToHand);
    }

    public Iterable<Card> GetHand() {
        return m_hand;
    }

    public void ClearHand() {
        m_hand.clear();
    }

    public void ShowHand() {
        for (Card c : GetHand()) {
            c.Show(true);
        }
    }

    public int CalcScore() {
        // the number of scores is dependant on the number of scorable values
        // as it seems there is no way to do this check at compile time in java ?!
        // cardScores[13] = {...};
        int cardScores[] = {
                2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11
        };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";


        int score = 0;

        for (Card c : GetHand()) {
            if (c.GetValue() != Card.Value.Hidden) {
                score += cardScores[c.GetValue().ordinal()];
            }
        }

        if (score > g_maxScore) {
            for (Card c : GetHand()) {
                if (c.GetValue() == Card.Value.Ace && score > g_maxScore) {
                    score -= 10;
                }
            }
        }

        return score;
    }

}
