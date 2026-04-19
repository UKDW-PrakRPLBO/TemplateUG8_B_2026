# UG8_B_2026 - Umbrella Secure Terminal (Sector B)

Lengkapilah program terminal inventaris pasokan Umbrella Corporation (Sector B) ini agar memiliki fitur-fitur berikut:

## UI dan Alur Program
- Aplikasi terdiri dari 2 UI yang berbeda, yaitu **Form Login** dan **Form Terminal Inventaris**.
  ![Form Login](/img/LoginForm.png)    
  ![Form Utama](/img/MainForm.png)  

- **Autentikasi Login:** Untuk dapat mengakses form inventaris, pengguna harus melakukan login yang terhubung dan tervalidasi langsung melalui tabel `users` di database. Gunakan kredensial default dengan username: **hunk** dan password: **123** (sebagai Agen HUNK - U.S.S. Alpha).

- **Insert Data Inventaris (Add):** User harus menginputkan *Item Name*, *Initial Stock* (Stok Awal), dan *New Supply* (Pasokan Baru), kemudian menekan tombol tambah. Sistem harus secara otomatis menghitung nilai **Final Stock** dengan rumus matematika: `Final Stock = Initial Stock + New Supply` sebelum menyimpannya. Jika proses simpan berhasil, data akan langsung diperbarui dan muncul di dalam tabel.

- **Update Data Inventaris (Save/Edit):** Untuk memperbarui data item, user terlebih dahulu memilih item yang ingin diubah dengan mengeklik salah satu baris pada tabel inventaris. Data yang dipilih akan ditampilkan pada form input (khusus *Item Name* akan dinonaktifkan/tidak bisa diedit karena merupakan Primary Key). User dapat mengubah nilai *Initial Stock* dan *New Supply*. Tombol simpan/update digunakan untuk melakukan penyimpanan ke sistem. **PENTING:** Sistem harus menghitung ulang *Final Stock* (`Initial + Supply`) sesuai nilai yang baru.

- **Delete Data Inventaris:** Untuk menghapus data, user terlebih dahulu memilih item yang ingin dihapus dengan mengeklik salah satu baris pada tabel, lalu menekan tombol hapus. Disarankan untuk memunculkan pesan konfirmasi (*Confirmation Dialog Box*) sebelum menghapus. Jika disetujui, data akan dihapus secara permanen dari sistem database dan hilang dari tampilan tabel.

- **Database:** Seluruh data aplikasi (baik *users* maupun *inventory*) harus dikelola dan disimpan di dalam **SQLite** (`umbrella_inventory_b.db`).

### Daftar Method yang Perlu Dilengkapi (TODO)

**1. `LoginController.java`**
- [ ] `handleLogin()` : Mengambil input *username* dan *password*, lalu memvalidasinya menggunakan *database manager* sebelum masuk ke sistem.

**2. `UmbrellaController.java`**
- [ ] `handleAdd()` : Melengkapi logika untuk mengambil inputan form, menghitung stok otomatis, dan menyimpan data baru ke *database*.
- [ ] `handleSave()` : Melengkapi logika untuk memperbarui (*update*) data item yang dipilih dan menghitung ulang stok terbarunya.
- [ ] `handleDelete()` : Melengkapi logika penghapusan data dari sistem beserta tampilan konfirmasinya.
