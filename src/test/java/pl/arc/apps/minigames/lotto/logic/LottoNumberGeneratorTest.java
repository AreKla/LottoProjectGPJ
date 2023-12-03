package pl.arc.apps.minigames.lotto.logic;

import org.junit.jupiter.api.Test;
import pl.arc.apps.minigames.lotto.common.LottoConstants;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @Test
    void shouldGenerateSetWithSixNumbers() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, LottoConstants.NUMBERS_TO_PICK);
        // Then
        assertEquals(LottoConstants.NUMBERS_TO_PICK, lottoNumbers.size(), "Set should contain 6 numbers");
    }

    @Test
    void shouldGenerateNumbersWithinSpecifiedRange() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, LottoConstants.NUMBERS_TO_PICK);
        // Then
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= min && num <= max),
                "All numbers should be within the specified range");
    }

    @Test
    void shouldGenerateSetWithUniqueNumbers() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, LottoConstants.NUMBERS_TO_PICK);
        // Then
        assertEquals(LottoConstants.NUMBERS_TO_PICK, new HashSet<>(lottoNumbers).size(),
                "All numbers should be unique");
    }
}