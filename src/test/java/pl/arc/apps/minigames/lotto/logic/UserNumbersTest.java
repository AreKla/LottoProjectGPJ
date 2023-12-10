package pl.arc.apps.minigames.lotto.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import pl.arc.apps.minigames.lotto.common.LottoConstants;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class UserNumbersTest {

    @Mock
    private Scanner scanner;

    @Test
    void shouldEnterUserNumbers() {
        MockitoAnnotations.openMocks(this);

        when(scanner.nextInt()).thenReturn(1, 2, 3, 4, 5, 6);

        UserNumbers userNumbers = new UserNumbers();
        Set<Integer> expectedNumbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            expectedNumbers.add(i);
        }

        userNumbers.enterUserNumbers(scanner, LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.NUMBERS_TO_PICK);

        assertEquals(expectedNumbers, userNumbers.getUserNumbers(), "User numbers should match expected numbers");

        verify(scanner, times(6)).nextInt();
    }
}