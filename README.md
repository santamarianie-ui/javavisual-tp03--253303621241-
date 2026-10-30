Character Manager — TP3 (Java Visual SIH-6406)
Character Manager adalah sebuah aplikasi atau sistem (biasanya berbasis Object-Oriented Programming menggunakan Java) yang dirancang untuk mengelola data karakter dalam sebuah game atau simulasi.
  <img width="697" height="260" alt="Screenshot 2026-10-16 152748" src="https://github.com/user-attachments/assets/b2f7677f-7300-4a0c-a9b5-b284f248df0c" />
CharacterManager/
├── src/
   └── com/
       └── unpri/
           └── charactermanager/
               ├── model/
               │   ├── Character.java
               │   └── CharacterType.java
               └── Main.java

Identitas Mahasiswa 

Nama Lengkap: Santa Mariani Elisabeth Simangunsong 

Nim: 253303521241

Google Docs Analisis: https://1drv.ms/b/c/251df1b2271152b7/IQBqCa0O3Q1wQbgZeQnYluOWARnYU1lLalO2W2HIiKMZ334?e=iOrMLE

Tugas · TP5 · Character Manager Sprint #2 CharacterManager, Analytics & Object Reference

<img width="623" height="427" alt="Screenshot 2026-10-17 094216" src="https://github.com/user-attachments/assets/6b9cbc54-96cd-48a2-b889-8dc05d735d9b" />


Bagian C — Fitur Analitik Rancangan Sendiri

1. Implementasi Kode Java (Bagian C)
Di bawah ini adalah 3 pilihan method analitik/manajemen yang dirancang dengan memperhatikan prinsip Encapsulation, pencegahan kebocoran referensi (Defensive Copying), dan Javadoc lengkap. Anda bisa memilih salah satu atau menggunakan semuanya di dalam CharacterManager.java.

Pilihan Utama: renameCharacter(String oldName, String newName)
Fitur ini mengubah nama karakter terdaftar dengan validasi ganda (memastikan karakter lama ada dan nama baru belum dipakai oleh karakter lain).

Pilihan Alternatif 1: findStrongest()
Mencari karakter dengan level tertinggi dan mengembalikan salinan independen (Defensive Copy) agar objek asli internal tidak dapat diubah secara sengaja/tidak sengaja dari luar.

Pilihan Alternatif 2: countByType(CharacterType type)
Menghitung jumlah karakter berdasarkan tipe tertent

2. Penjelasan Rasionalitas untuk README.md
Tuliskan paragraf berikut pada berkas README.md Anda untuk menjelaskan rasionalitas perancangan fitur tersebut:

Markdown
Rasionalitas Rancangan Fitur Analitik / Kustom (Bagian C)

1. Rasionalitas Bisnis & Fitur (`renameCharacter`):
   Dalam game/aplikasi berbasis karakter, fitur mengubah nama (*rename*) adalah kebutuhan umum. Namun, perubahan nama tidak boleh merusak aturan keunikan (*uniqueness constraint*). Method `renameCharacter` dirancang untuk memvalidasi keberadaan karakter target serta memastikan bahwa `newName` belum terdaftar pada karakter lain (mencegah bentrok nama duplikat).

2. Penerapan Encapsulation:
   - Method ini mengendalikan mutasi atribut secara penuh di dalam enkapsulasi `CharacterManager`.
   - Method tidak pernah mengembalikan atau menerima koleksi `ArrayList` internal.
   - Apabila menggunakan method pencarian seperti `findStrongest()`, pengembalian nilai dilakukan menggunakan **Defensive Copy (`new Character(strongest)`), sehingga pihak luar (*caller*) tidak mendapatkan pointer/referensi langsung ke objek di dalam memori internal `CharacterManager`. Perubahan atribut pada objek hasil return tidak akan merusak data di dalam manager.

Bagian D — Analisis Reference & Rancangan (Google Docs) 
https://1drv.ms/b/c/251df1b2271152b7/IQDEDFv0eVXHSIcTdV_Gs-VhAZ9Z8qvlclvV6vV4gejI-7g?e=pPGxiY


Character Manager Sprint #3 MainWindow, Data Dinamis & Analisis MVC TP03
Cok, ini pengertian TP08 yang bisa kau masukkan ke dalam `README.md` bagian pendahuluan. ❤️

### Pengertian TP08 — Implementasi GUI dan Analisis MVC
Graphical User Interface (GUI) menggunakan Java Swing serta pemahaman konsep Model-View-Controller (MVC). Pada tugas ini, program Character Manager yang sebelumnya dijalankan melalui console dikembangkan menjadi aplikasi berbasis jendela interaktif yang menampilkan data karakter secara dinamis. Selain itu, tugas ini mencakup penambahan karakter baru, perhitungan statistik rata-rata level, serta penerapan `SwingUtilities.invokeLater()` untuk menjalankan GUI pada thread yang sesuai. Melalui TP08, mahasiswa diharapkan mampu memahami pemisahan tanggung jawab antara pengelolaan data, tampilan antarmuka, dan alur kerja aplikasi.
<img width="854" height="398" alt="Screenshot 2026-10-23 235249" src="https://github.com/user-attachments/assets/85109970-ced1-446c-b380-b8b1976974cd" />
src
└── com
    └── unpri
        └── charactermanager
            ├── Main.java
            ├── model
            │   ├── Character.java
            │   ├── CharacterManager.java
            │   └── CharacterType.java
            └── view
                └── MainWindow.java

2. Aliran Data dan Konsep MVC
Program dimulai dari `Main.java`, yang membuat objek `CharacterManager` dan menambahkan data karakter ke dalamnya. Selanjutnya, objek `CharacterManager` diberikan kepada `MainWindow` agar daftar karakter dapat ditampilkan secara dinamis melalui komponen `JLabel`. Dalam konsep MVC, `Character` dan `CharacterManager` berperan sebagai Model, sedangkan `MainWindow` berperan sebagai View yang bertanggung jawab menampilkan data kepada pengguna. `Main.java` mengatur inisialisasi aplikasi dan menampilkan jendela menggunakan `SwingUtilities.invokeLater()`.
3. Karakter Baru dan Alasan Pemilihan

| Nama | Tipe | Level | Alasan Pemilihan |
|---|---|---:|---|
| Luna | HEALER | 6 | Mewakili karakter pendukung yang berfokus pada pemulihan dan memiliki variasi peran. |
| Bima | WARRIOR | 8 | Mewakili karakter petarung dengan level lebih tinggi untuk menunjukkan variasi level karakter. |

Penambahan Luna dan Bima membuat aplikasi memiliki lima karakter dengan tipe dan level yang bervariasi.

4. Dokumentasi Analisis GUI dan MVC

Dokumen Google Docs Bagian D: https://1drv.ms/b/c/251df1b2271152b7/IQDbopTQA6o0TomgWWKhvZvJAc8tDxn3JBCgbx3WMEovtIM?e=tfIgD8

Character Manager Sprint #4 Theming, Properti Komponen & Analisis MVC
Screenshoot sesudah (v0.4 - AppTheme)
<img width="759" height="473" alt="Screenshot 2026-10-28 173539" src="https://github.com/user-attachments/assets/b3a59345-b8ff-4876-9b73-125ce8f29033" />
screenshoot masih (v0.3 - App Theme)
<img width="788" height="441" alt="Screenshot 2026-10-28 173115" src="https://github.com/user-attachments/assets/8ed9c970-f6a5-4391-950e-232c7b7bafdb" />

Pada bagian ini, aplikasi Character Manager dikembangkan dengan menambahkan fitur penanda level tinggi. Karakter yang memiliki level minimal 5 akan ditampilkan menggunakan teks berwarna emas dan tebal. Batas level disimpan dalam konstanta HIGH_LEVEL_THRESHOLD agar mudah diatur.

Selain itu, jumlah karakter ditambahkan menjadi minimal 6 dengan variasi role dan level. Dua properti tambahan juga diterapkan, yaitu tooltip untuk menampilkan informasi HP dan ATK serta border emas untuk karakter dengan level tinggi.

Sebagai bukti pengembangan, disertakan screenshot sebelum (v0.3) dan sesudah (v0.4). Perubahan juga dilakukan secara bertahap melalui commit GitHub untuk menunjukkan proses pengerjaan aplikasi.
Dokumen Google Docs Bagian D: https://1drv.ms/b/c/251df1b2271152b7/IQBoXvXcTlMYRKOfSt3kbU5ZAW36omJbhIbst6hcX-5EPMg?e=jHECeU
