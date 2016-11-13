package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
    final int g_hitLimit = 17;
}