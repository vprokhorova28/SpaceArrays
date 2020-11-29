package ru.samsung.itschool.spacearrays;

import android.graphics.Color;

public enum StarColour {
    YELLOW(Color.YELLOW), LIGHT_YELLOW(Color.parseColor("#FFFA91")), WHITE(Color.WHITE), DARK_YELLOW(Color.parseColor("#FFCC00"));
    private int colour;

    StarColour(int colour) {
        this.colour = colour;
    }

    public int getColour() {
        return colour;
    }
}
