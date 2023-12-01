package pl.arc.apps.minigames.lotto.logic;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @Test
    void shouldReturnSetWithSixUniqueNumbers() {
        // Given
        int min = 1;
        int max = 99;

        // When
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(min, max, 6);

        // Then
        assertEquals(6, lottoNumbers.size(), "Set should contain 6 numbers");
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= min && num <= max), "All numbers should be within the specified range");
        assertEquals(6, new HashSet<>(lottoNumbers).size(), "All numbers should be unique");
    }
}