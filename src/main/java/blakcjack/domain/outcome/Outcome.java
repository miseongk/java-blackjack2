package blakcjack.domain.outcome;

import blakcjack.domain.participant.Dealer;
import blakcjack.domain.participant.Player;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Outcome {
	BLACKJACK_WIN(1.5f, Outcome::isWinningByBlackjack),
	WIN(1f, Outcome::isWinningByScoreOrDealerBust),
	DRAW(0f, Outcome::isDrawByScore),
	LOSE(-1f, (dealer, player) -> true);

	private final float earningRate;
	private final BiPredicate<Dealer, Player> expression;

	Outcome(final float earningRate, final BiPredicate<Dealer, Player> expression) {
		this.earningRate = earningRate;
		this.expression = expression;
	}

	private static boolean isWinningByBlackjack(final Dealer dealer, final Player player) {
		return player.isBlackJack() && !dealer.isBlackJack();
	}

	private static boolean isWinningByScoreOrDealerBust(final Dealer dealer, final Player player) {
		return !player.isBust() && (dealer.isBust() || player.getScore() > dealer.getScore());
	}

	private static boolean isDrawByScore(final Dealer dealer, final Player player) {
		return !player.isBust() && player.getScore() == dealer.getScore();
	}

	static Outcome of(final Dealer dealer, final Player player) {
		return Arrays.stream(values())
				.filter(outcome -> outcome.expression.test(dealer, player))
				.findFirst()
				.orElseThrow(NoSuchOutcomeException::new);
	}

	public float getEarningRate() {
		return earningRate;
	}
}