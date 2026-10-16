import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // ===== MEMBUAT 3 KARAKTER =====
        Character hero = new Character(
                "Arjuna", CharacterType.WARRIOR, 5);

        Character wizard = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character scout = new Character(
                "Athena", CharacterType.ARCHER, 4);

        // Menampilkan informasi ketiga karakter
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // ===== DEMO LEVEL UP =====
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        System.out.println("After level up: " + hero);

        // ===== MENAMPILKAN INFORMASI HERO =====
        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // ===== MINI-CHALLENGE: MANA DAN ISALIVE =====
        System.out.println();
        System.out.println("=== Demo Mana dan IsAlive ===");

        // Membuat karakter baru
        Character paladin = new Character(
                "Luna", CharacterType.WARRIOR, 5);

        // Mengatur mana Luna menjadi 100
        paladin.setMana(100);

        // Menampilkan informasi Luna
        System.out.println(paladin);
        System.out.println("Mana Luna: " + paladin.getMana());

        // Memeriksa apakah Luna masih hidup
        System.out.println(
                "Apakah Luna masih hidup? " + paladin.isAlive());

        // ===== MENGUJI VALIDASI MANA NEGATIF =====
        System.out.println();
        System.out.println("=== Demo Validasi Mana ===");

        try {
            paladin.setMana(-10);

            System.out.println("Mana berhasil diubah.");
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Validasi mana berhasil: " + e.getMessage());
        }

        // Memastikan mana tetap 100 setelah nilai negatif ditolak
        System.out.println(
                "Mana Luna setelah pengujian: " + paladin.getMana());
    }
}