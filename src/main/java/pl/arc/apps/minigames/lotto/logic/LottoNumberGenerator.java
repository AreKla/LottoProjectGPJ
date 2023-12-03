package pl.arc.apps.minigames.lotto.logic;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class LottoNumberGenerator {

    public static Set<Integer> generateLottoNumbers(int min, int max, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }

        if (min > max) {
            throw new IllegalArgumentException("Invalid range: min is greater than max");
        }

        Set<Integer> lottoNumbers = new HashSet<>();
        SecureRandom secureRandom = new SecureRandom();

        while (count > 0) {
            int lottoNumber = secureRandom.nextInt(max - min + 1) + min;
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
                count--;
            }
        }
        return lottoNumbers;
    }
}