
package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan encapsulation melalui atribut private.
 */
public class Character {

    // Atribut private
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Menghitung jumlah objek Character yang telah dibuat.
    private static int totalCharacterCreated = 0;

    // Constructor untuk membuat karakter baru
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Constructor untuk memuat karakter dari database
    public Character(int id, String name, CharacterType type,
            int level, int hitPoints, int attackPower) {
        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Helper private
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif");
        }

        this.mana = mana;
    }

    // Memeriksa status hidup karakter
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Character other = (Character) obj;

        return name != null
                && other.name != null
                && name.equalsIgnoreCase(other.name);
    }

    // Harus konsisten dengan equals()
    @Override
    public int hashCode() {
        return name == null
                ? 0
                : name.toLowerCase(
                        java.util.Locale.ROOT).hashCode();
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hp=" + hitPoints +
                ", atk=" + attackPower +
                ", mana=" + mana +
                '}';
    }
}
