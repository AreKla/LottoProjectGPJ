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

    @Test
    void shouldGenerateNumbersWithinCustomRange() {
        // Given
        int min = 100;
        int max = 500;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, LottoConstants.NUMBERS_TO_PICK);
        // Then
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= min && num <= max),
                "All numbers should be within the specified custom range");
    }

    @Test
    void shouldGenerateSetWithMinCount() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, 1);
        // Then
        assertEquals(1, lottoNumbers.size(), "Set should contain 1 number");
    }

    @Test
    void shouldGenerateSetWithMaxCount() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, max - min + 1);
        // Then
        assertEquals(max - min + 1, lottoNumbers.size(), "Set should contain maximum possible numbers");
    }

    @Test
    void shouldGenerateNumbersInLargeRange() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER - 1;
        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, LottoConstants.NUMBERS_TO_PICK);
        // Then
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= min && num <= max),
                "All numbers should be within the specified large range");
    }

    @Test
    void shouldThrowExceptionForNegativeCount() {
        // Given
        int min = LottoConstants.MIN_LOTTO_NUMBER;
        int max = LottoConstants.MAX_LOTTO_NUMBER;
        int negativeCount = -1;
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberGenerator.generateLottoNumbers(min, max, negativeCount);
        }, "Should throw IllegalArgumentException for negative count");
    }

    @Test
    void shouldThrowExceptionForInvalidRange() {
        // Given
        int invalidMin = 50;
        int invalidMax = 40;
        int count = 6;
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberGenerator.generateLottoNumbers(invalidMin, invalidMax, count);
        }, "Should throw IllegalArgumentException for invalid range");
    }
}