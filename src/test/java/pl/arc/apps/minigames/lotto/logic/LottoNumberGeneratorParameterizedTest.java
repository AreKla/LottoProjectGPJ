package pl.arc.apps.minigames.lotto.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberGeneratorParameterizedTest {
    @ParameterizedTest
    @MethodSource("provideValidRangesAndCounts")
    void shouldGenerateSetWithExpectedCount(int min, int max, int count) {
        // When
        Set<Integer> lottoNumbers = LottoNumbersGenerator.generateLottoNumbers(min, max, count);
        // Then
        assertEquals(count, lottoNumbers.size(), "Set should contain the expected count of numbers");
    }

    static Stream<Arguments> provideValidRangesAndCounts() {
        return Stream.of(
                Arguments.of(1, 99, 6),
                Arguments.of(10, 50, 5),
                Arguments.of(100, 200, 50),
                Arguments.of(0, 10, 5),
                Arguments.of(5, 7, 1)
        );
    }
}