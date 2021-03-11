package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static blackjack.domain.BlackjackGame.BLACKJACK_NUMBER;
import static blackjack.domain.card.painting.Symbol.ACE;

public class Cards {
    private static final int ACE_ADDITIONAL_SCORE = 10;

    private final ArrayList<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public int calculateScore() {
        int score = sumScore();

        if (hasAce() && canAddAceScore(score)) {
            score -= ACE.getScore();
            score += ACE.getBiggerAceScore();
        }

        return score;
    }

    private boolean canAddAceScore(int score) {
        return score + ACE_ADDITIONAL_SCORE <= BLACKJACK_NUMBER;
    }

    private int sumScore() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(card -> card.isSameSymbol(ACE));
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public Stream<Card> stream() {
        return cards.stream();
    }
}