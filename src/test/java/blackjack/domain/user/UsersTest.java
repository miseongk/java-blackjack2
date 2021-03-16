package blackjack.domain.user;

import blackjack.domain.card.Cards;
import blackjack.domain.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    private Users users;

    @BeforeEach
    public void setUp() {
        users = new Users(new Dealer(), new Players(Arrays.asList(
                new Player("amazzi", 10000.0),
                new Player("dani", 10000.0),
                new Player("pobi", 20000.0))));
    }

    @DisplayName("이름별로 참여자들을 생성한다.")
    @Test
    void createPlayers() {
        assertThat(users).isInstanceOf(Users.class);
    }

    @DisplayName("플레이어 이름들을 확인한다.")
    @Test
    void getNames() {
        List<String> namesGroup = users.getPlayerNames();

        assertThat(namesGroup).isEqualTo(Arrays.asList("amazzi", "dani", "pobi"));
    }

    @DisplayName("Players 일급 컬렉션을 반환한다.")
    @Test
    void getPlayers() {
        assertThat(users.getPlayers()).hasSize(3);
    }
}