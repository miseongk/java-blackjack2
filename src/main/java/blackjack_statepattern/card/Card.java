package blackjack_statepattern.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Card {

    private static final Map<String, Card> CACHE = new HashMap<>(52);

    static {
        Arrays.stream(Suit.values())
                .forEach(suit -> Arrays.stream(Denomination.values())
                        .forEach(denomination -> CACHE.put(toKey(suit, denomination), new Card(suit, denomination))));
    }

    private final Suit suit;
    private final Denomination denomination;

    private Card(final Suit suit, final Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(final Suit suit, final Denomination denomination) {
        return CACHE.get(toKey(suit, denomination));
    }

    private static String toKey(final Suit suit, final Denomination denomination) {
        return suit.name() + denomination.name();
    }

    public static List<Card> getAllCard() {
        return new ArrayList<>(CACHE.values());
    }

    public int score() {
        return denomination.getScore();
    }

    public boolean isAce() {
        return denomination == Denomination.ACE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && denomination == card.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }

    public String getSuitName() {
        return suit.getName();
    }

    public String getDenominationName() {
        return denomination.getName();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", denomination=" + denomination +
                '}';
    }
}