package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    // Warna utama
    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color TEXT = new Color(45, 50, 60);
    public static final Color GOLD = new Color(212, 160, 23);

    // Warna berdasarkan role
    public static final Color WARRIOR = new Color(255, 225, 225);
    public static final Color MAGE = new Color(225, 230, 255);
    public static final Color ARCHER = new Color(225, 245, 230);
    public static final Color HEALER = new Color(255, 245, 215);

    // Font
    public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 20);
    public static final Font NORMAL_FONT = new Font("SansSerif", Font.PLAIN, 14);
    public static final Font EMPHASIS_FONT = new Font("SansSerif", Font.BOLD, 14);

    // Border
    public static final Border CARD_BORDER = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(
                    new Color(210, 215, 225)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10));

    public static final Border HIGH_LEVEL_BORDER = BorderFactory.createLineBorder(GOLD, 2);

    public static final Border PANEL_BORDER = BorderFactory.createEmptyBorder(15, 15, 15, 15);

    // Batas level tinggi
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return BACKGROUND;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR;
            case MAGE:
                return MAGE;
            case ARCHER:
                return ARCHER;
            case HEALER:
                return HEALER;
            default:
                return BACKGROUND;
        }
    }
}
