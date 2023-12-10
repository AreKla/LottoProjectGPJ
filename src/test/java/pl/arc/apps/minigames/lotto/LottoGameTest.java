package pl.arc.apps.minigames.lotto;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LottoGameTest {

    @Mock
    private Scanner scanner;

    @Test
    void shouldPlayLottoGame() {
        MockitoAnnotations.openMocks(this);

        when(scanner.nextInt()).thenReturn(1, 2, 3, 4, 5, 6);

        LottoGame lottoGame = new LottoGame(scanner);

        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        lottoGame.play();

        verify(scanner, times(6)).nextInt();
        assertEquals(lottoNumbers, lottoGame.getUserNumbers().getUserNumbers(), "User numbers should match expected numbers");
    }
}