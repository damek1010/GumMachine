package com.company;

import java.util.Random;

public class Machine {
    private float coin;
    private boolean isCoinInserted;

    /**
     * @param coin Float value of coin. Acceptable: {0.1, 0.2, 0.5, 1.0, 2.0}
     * @return true if coin has been successfully inserted
     */
    public boolean insertCoin(float coin) {
        if (this.isCoinInserted) return false;
        if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0) {
            Random gen = new Random();
            if (gen.nextBoolean()) {
                this.coin = coin;
                this.isCoinInserted = true;
                return true;
            }
        }
        return false;
    }

    /**
     * Function that returns inserted coin and resets its value
     * @return inserted coin
     */
    public float getCoinBack() {
        float tmp = this.coin;
        this.coin = 0.0f;
        this.isCoinInserted = false;
        return tmp;
    }
}
