package blackjack.domain.participant;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 8;

    public static Players from(List<String> names) {
        validateLength(names);
        return createPlayers(names);
    }

    private static void validateLength(List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT || names.size() > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참가자의 수는 최소 2명에서 최대 8명이어야 합니다.");
        }
    }

    private static Players createPlayers(final List<String> names) {
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }
}
