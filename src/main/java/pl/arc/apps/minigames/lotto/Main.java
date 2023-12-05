package pl.arc.apps.minigames.lotto;

import pl.arc.apps.minigames.lotto.common.LottoConstants;
import pl.arc.apps.minigames.lotto.logic.LottoNumbersGenerator;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> lottoNumbers = LottoNumbersGenerator.generateLottoNumbers(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.NUMBERS_TO_PICK);
        System.out.println(lottoNumbers);
    }
}