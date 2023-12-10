package pl.arc.apps.minigames.lotto.logic;

import java.util.Set;

public interface NumberGenerator {
    Set<Integer> generateNumbers(int min, int max, int count);
}