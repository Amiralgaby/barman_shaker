package com.example.projet_barman;

public interface OnGameUpdatedListener {
    void updateScore(String score);
    void updateTemps(String temps);
    void victoire();
    void defaite();
}
