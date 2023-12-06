package pl.arc.apps.minigames.lotto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoGame lottoGame = new LottoGame(scanner);
        lottoGame.play();
    }
}