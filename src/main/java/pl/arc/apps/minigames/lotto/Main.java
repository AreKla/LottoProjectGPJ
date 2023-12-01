package pl.arc.apps.minigames.lotto;

import pl.arc.apps.minigames.lotto.logic.LottoNumberGenerator;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(1, 99, 6);
        System.out.println(lottoNumbers);
    }
}