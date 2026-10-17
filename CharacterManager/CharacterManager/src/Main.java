package CharacterManager.src;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {

                CharacterManager manager = new CharacterManager();

                // A. Menguji daftar kosong
                System.out.println("=== UJI DAFTAR KOSONG ===");
                CharacterManager emptyManager = new CharacterManager();

                System.out.println(
                                "Total awal: " + emptyManager.getTotalCharacters());
                System.out.println(
                                "Rata-rata level: " + emptyManager.getAverageLevel());

                // B. Menambahkan karakter
                System.out.println("\n=== TAMBAH KARAKTER ===");

                Character arjuna = new Character("Arjuna", CharacterType.WARRIOR, 5);

                Character merlin = new Character("Merlin", CharacterType.MAGE, 3);

                Character athena = new Character("Athena", CharacterType.ARCHER, 4);

                System.out.println("Arjuna: " + manager.addCharacter(arjuna));
                System.out.println("Merlin: " + manager.addCharacter(merlin));
                System.out.println("Athena: " + manager.addCharacter(athena));

                // C. Menguji equals()
                System.out.println("\n=== UJI EQUALS ===");

                Character arjunaLain = new Character("ARJUNA", CharacterType.MAGE, 8);

                System.out.println(
                                "Nama Arjuna sama: " + arjuna.equals(arjunaLain));

                // D. Menguji duplikat
                System.out.println("\n=== UJI DUPLIKAT ===");

                System.out.println(
                                "Tambah ARJUNA lagi: "
                                                + manager.addCharacter(arjunaLain));

                System.out.println(
                                "Total setelah percobaan duplikat: "
                                                + manager.getTotalCharacters());

                // E. Menampilkan semua karakter
                System.out.println("\n=== SEMUA KARAKTER ===");

                for (Character c : manager.getAllCharacters()) {
                        System.out.println(c);
                }

                // F. Menguji pencarian
                System.out.println("\n=== UJI PENCARIAN ===");

                Character found = manager.findByName("Merlin");

                System.out.println("Merlin ditemukan: " + (found != null));
                System.out.println(
                                "Karakter tidak ada ditemukan: "
                                                + (manager.findByName("Thor") != null));

                // G. Menguji rata-rata
                System.out.println("\n=== UJI RATA-RATA LEVEL ===");

                System.out.println(
                                "Rata-rata: " + manager.getAverageLevel());

                // H. Menguji pencarian berdasarkan tipe
                System.out.println("\n=== UJI FIND BY TYPE ===");

                ArrayList<Character> warriors = manager.findByType(CharacterType.WARRIOR);

                for (Character c : warriors) {
                        System.out.println(c.getName());
                }

                // I. Fitur analitik tambahan
                System.out.println("\n=== UJI COUNT BY TYPE ===");

                System.out.println(
                                "Jumlah Warrior: "
                                                + manager.countByType(CharacterType.WARRIOR));

                System.out.println(
                                "Jumlah Mage: "
                                                + manager.countByType(CharacterType.MAGE));

                System.out.println(
                                "Jumlah Archer: "
                                                + manager.countByType(CharacterType.ARCHER));

                // J. Menguji encapsulation dan salinan daftar
                System.out.println("\n=== UJI SALINAN DAFTAR ===");

                ArrayList<Character> salinan = manager.getAllCharacters();
                salinan.clear();

                System.out.println("Ukuran salinan: " + salinan.size());
                System.out.println(
                                "Jumlah di manager asli: "
                                                + manager.getTotalCharacters());

                // K. Menguji penghapusan
                System.out.println("\n=== UJI PENGHAPUSAN ===");

                System.out.println(
                                "Hapus Merlin: " + manager.removeCharacter("Merlin"));

                System.out.println(
                                "Hapus Thor: " + manager.removeCharacter("Thor"));

                System.out.println(
                                "Total setelah hapus: "
                                                + manager.getTotalCharacters());

                // L. Menguji penghitung static
                System.out.println("\n=== UJI STATIC ===");

                System.out.println(
                                "Objek Character yang dibuat: "
                                                + Character.getTotalCharacterCreated());
        }
}