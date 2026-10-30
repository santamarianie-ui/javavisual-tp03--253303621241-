
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

        private final CharacterManager characterManager;
        private final JPanel characterPanel;
        private final JLabel averageLevelLabel;

        public MainWindow(CharacterManager characterManager) {
                this.characterManager = characterManager;

                setTitle("Character Manager - Sprint #4 v0.4");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                characterPanel = new JPanel();
                characterPanel.setLayout(
                                new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
                characterPanel.setBackground(AppTheme.BACKGROUND);
                characterPanel.setOpaque(true);

                JLabel titleLabel = new JLabel("DAFTAR KARAKTER");
                titleLabel.setFont(AppTheme.TITLE_FONT);
                titleLabel.setForeground(AppTheme.TEXT);

                averageLevelLabel = new JLabel();
                averageLevelLabel.setFont(AppTheme.EMPHASIS_FONT);
                averageLevelLabel.setForeground(AppTheme.TEXT);
                averageLevelLabel.setBorder(AppTheme.CARD_BORDER);
                averageLevelLabel.setOpaque(true);
                averageLevelLabel.setBackground(AppTheme.BACKGROUND);

                JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
                mainPanel.setBackground(AppTheme.BACKGROUND);
                mainPanel.setBorder(AppTheme.PANEL_BORDER);
                mainPanel.setOpaque(true);

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(characterPanel, BorderLayout.CENTER);
                mainPanel.add(averageLevelLabel, BorderLayout.SOUTH);

                add(mainPanel);

                refreshCharacters();

                pack();
                setMinimumSize(new Dimension(500, 350));
                setLocationRelativeTo(null);
        }

        public void refreshCharacters() {
                characterPanel.removeAll();

                List<Character> characters = characterManager.getAllCharacters();

                for (Character character : characters) {

                        JLabel characterLabel = new JLabel(
                                        character.getName()
                                                        + " | Tipe: " + character.getType()
                                                        + " | Level: " + character.getLevel());

                        characterLabel.setFont(AppTheme.NORMAL_FONT);
                        characterLabel.setForeground(AppTheme.TEXT);

                        // Properti tambahan 1: tooltip HP dan ATK
                        characterLabel.setToolTipText(
                                        "HP: " + character.getHitPoints()
                                                        + " | ATK: " + character.getAttackPower());

                        JPanel card = new JPanel(new BorderLayout());
                        card.setBackground(
                                        AppTheme.colorFor(character.getType()));
                        card.setOpaque(true);
                        card.setBorder(AppTheme.CARD_BORDER);

                        // Mini-Challenge: level minimal 5
                        if (character.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {

                                characterLabel.setForeground(AppTheme.GOLD);
                                characterLabel.setFont(AppTheme.EMPHASIS_FONT);

                                // Properti tambahan 2: border emas
                                card.setBorder(AppTheme.HIGH_LEVEL_BORDER);
                        }

                        card.add(characterLabel, BorderLayout.CENTER);

                        characterPanel.add(card);
                        characterPanel.add(Box.createVerticalStrut(8));
                }

                averageLevelLabel.setText(
                                String.format(
                                                "Rata-rata Level: %.2f (%d karakter)",
                                                characterManager.getAverageLevel(),
                                                characters.size()));

                characterPanel.revalidate();
                characterPanel.repaint();

                pack();
        }
}
