# RBC Hotel - Input Control & User Interaction 🏨

Aplikasi Android sederhana untuk sistem manajemen perhotelan (RBC Hotel) yang berfokus pada implementasi UI/UX yang modern, *Input Control*, dan *User Interaction*. Proyek ini dikembangkan sebagai pemenuhan tugas mata kuliah Pemrograman Mobile (Pertemuan 5).

## 📱 Fitur Utama (Sesuai Kriteria Tugas)

1. **Complete Form**
   Form registrasi interaktif menggunakan `TextInputLayout` dan `TextInputEditText` bergaya Material Design (*OutlinedBox*) untuk input Nama, Email, Password, dan Konfirmasi Password.

2. **Advanced Validation**
   Implementasi validasi *real-time* cerdas untuk memastikan:
   * Form tidak boleh kosong.
   * Format email valid (harus mengandung '@').
   * Input *Password* dan *Konfirmasi Password* saling cocok (*match*).

3. **Selection Controls**
   * Menggunakan `RadioGroup` untuk pemilihan Jenis Kelamin.
   * Menggunakan `CheckBox` untuk pemilihan Hobi (dilengkapi validasi minimal pilihan).

4. **Spinner & Dialog**
   * *Dropdown* kustom menggunakan `Spinner` untuk pilihan Tipe Akun.
   * Memunculkan `AlertDialog` untuk konfirmasi ("Apakah data ini sudah benar?") sebelum pengiriman data (Submit) dan perpindahan halaman.

5. **Gesture Interaction**
   Implementasi interaksi *Long Press* (`setOnLongClickListener`) pada tombol Daftar. Jika ditekan lama, form akan otomatis me-reset seluruh inputan menjadi kosong dan memunculkan *Toast* pesan bantuan.

## 🛠️ Teknologi & Tools
* **Bahasa Pemrograman:** Kotlin
* **UI/UX & Desain:** XML (Material Design Components, ConstraintLayout, MaterialCardView)
* **IDE:** Android Studio

## 👨‍💻 Informasi Pengembang
* **Nama:** Ahmad Kurnia
* **Kelas:** TIF 24 RP CNS D 
* **Program Studi:** Teknik Informatika
* **Universitas:** Universitas Teknologi Bandung
* **Semester:** 4
