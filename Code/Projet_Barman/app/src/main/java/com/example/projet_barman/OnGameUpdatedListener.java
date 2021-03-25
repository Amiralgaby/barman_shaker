package com.example.projet_barman;

/**
 * Interface qui régie les update des score et temps
 * elle permet aussi de réalisé une action lorsque victoire ou défaite
 */
public interface OnGameUpdatedListener {
    void updateScore(String score);
    void updateTemps(String temps);
    void victoire();
    void defaite();
}
