package pl.arc.apps.minigames.lotto;

import lombok.Data;
import pl.arc.apps.minigames.Game;
import pl.arc.apps.minigames.lotto.common.LottoConstants;
import pl.arc.apps.minigames.lotto.logic.LottoNumberGenerator;
import pl.arc.apps.minigames.lotto.logic.UserNumbers;

import java.util.Scanner;
import java.util.Set;

@Data
public class LottoGame implements Game {

    private final UserNumbers userNumbers;
    private final Scanner scanner;
    private final LottoNumberGenerator lottoNumberGenerator;


    public LottoGame(Scanner scanner) {
        this.scanner = scanner;
        this.userNumbers = new UserNumbers();
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Override
    public void play() {
        userNumbers.enterUserNumbers(
                scanner,
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.NUMBERS_TO_PICK);

        Set<Integer> lottoNumbers = lottoNumberGenerator.generateLottoNumbers(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.NUMBERS_TO_PICK);

        System.out.println("Drawn numbers: " + lottoNumbers);

        int matchedNumbers = countMatchedNumbers(userNumbers.getUserNumbers(), lottoNumbers);
        System.out.println("Number of matches: " + matchedNumbers);

        if (matchedNumbers == LottoConstants.NUMBERS_TO_PICK) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Unfortunately, try again.");
        }
    }

    private int countMatchedNumbers(Set<Integer> userNumbers, Set<Integer> lottoNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (lottoNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }
}