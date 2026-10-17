
package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola kumpulan karakter dalam aplikasi.
 */
public class CharacterManager {

    // Daftar internal tidak boleh diakses langsung dari luar.
    private final ArrayList<Character> characterList = new ArrayList<>();

    /**
     * Menambahkan karakter jika objek dan namanya valid
     * serta belum terdapat dalam daftar.
     *
     * @param character karakter yang akan ditambahkan
     * @return true jika berhasil, false jika ditolak
     */
    public boolean addCharacter(Character character) {
        if (character == null || character.getName() == null
                || character.getName().trim().isEmpty()) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characterList.add(character);
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     *
     * @param name nama karakter
     * @return objek karakter jika ditemukan, selain itu null
     */
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characterList) {
            if (character.getName() != null
                    && character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     *
     * @param name nama karakter yang akan dihapus
     * @return true jika berhasil dihapus
     */
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characterList.remove(character);
        return true;
    }

    /**
     * Menghitung karakter yang saat ini ada dalam daftar.
     *
     * @return jumlah karakter saat ini
     */
    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan salinan daftar, bukan daftar internal.
     *
     * @return salinan ArrayList karakter
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    /**
     * Menghitung rata-rata level seluruh karakter.
     *
     * @return rata-rata level, atau 0 jika daftar kosong
     */
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characterList) {
            total += character.getLevel();
        }

        return (double) total / characterList.size();
    }

    /**
     * Mengambil semua karakter dengan tipe tertentu.
     *
     * @param type tipe yang dicari
     * @return daftar baru berisi karakter dengan tipe tersebut
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characterList) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Menghitung jumlah karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang ingin dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        if (type == null) {
            return 0;
        }

        int count = 0;

        for (Character character : characterList) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
