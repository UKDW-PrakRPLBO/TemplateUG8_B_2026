package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.rplbo.app.ug8.InventoryItem;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

import java.net.URL;
import java.util.ResourceBundle;

public class UmbrellaController implements Initializable {
    // Variabel FXML diubah untuk mencerminkan skema Grup B
    @FXML private TextField txtItem, txtInitial, txtSupply;
    @FXML private TableView<InventoryItem> tableInventory;
    @FXML private TableColumn<InventoryItem, String> colName;
    @FXML private TableColumn<InventoryItem, Integer> colInitial, colSupply, colFinal;

    private UmbrellaDBManager db;
    private ObservableList<InventoryItem> masterData = FXCollections.observableArrayList();
    private InventoryItem selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new UmbrellaDBManager();
        System.out.println("LOG: OPERATIVE " + UmbrellaApp.loggedInUser + " ACCESS GRANTED.");

        // ==============================================================================
        // TODO 1: MENGHUBUNGKAN KOLOM TABEL (TABLE COLUMN MAPPING)
        // ==============================================================================
        // Hubungkan setiap TableColumn (colName, colInitial, colSupply, colFinal)
        // dengan nama atribut (property) yang sesuai di dalam class InventoryItem.
        // Gunakan setCellValueFactory() dan new PropertyValueFactory<>().
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---




        // ==============================================================================
        // TODO 2: LISTENER KLIK BARIS TABEL (SELECTION MODEL)
        // ==============================================================================
        // Lengkapi logika di dalam listener di bawah ini:
        // 1. Masukkan objek 'newVal' ke dalam variabel global 'selectedItem'.
        // 2. Tampilkan nilai itemName dari newVal ke dalam TextField 'txtItem'.
        // 3. Tampilkan nilai initialStock dari newVal ke dalam TextField 'txtInitial'.
        // 4. Tampilkan nilai newSupply dari newVal ke dalam TextField 'txtSupply'.
        //    (Ingat: Ubah tipe data angka menjadi String menggunakan String.valueOf).
        // 5. Matikan (disable) TextField 'txtItem' agar pengguna tidak bisa mengubah
        //    nama item (Primary Key) saat sedang mengedit data.
        // ==============================================================================

        tableInventory.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // --- TULIS KODE ANDA DI BAWAH INI ---



            }
        });

        refreshTable();
    }

    @FXML
    private void handleSave() {
        // ==============================================================================
        // TODO 3: LOGIKA PERBARUI/UPDATE DATA
        // ==============================================================================
        // 1. Pastikan ada item yang dipilih (cek apakah selectedItem tidak sama dengan null).
        // 2. Ambil nilai teks terbaru dari txtInitial dan txtSupply, lalu ubah menjadi Integer.
        // 3. HITUNG FINAL STOCK BARU:
        //    Rumus GRUP B: final_stock = initial + supply
        // 4. Buat objek InventoryItem baru menggunakan data yang diperbarui.
        //    PENTING: Ambil nama item dari selectedItem.getItemName(), jangan dari TextBox!
        // 5. Panggil db.updateItem(). Jika berhasil (mengembalikan true), panggil:
        //    - refreshTable()
        //    - clearFields()
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---


    }

    @FXML
    private void handleAdd() {
        // ==============================================================================
        // TODO 4: LOGIKA TAMBAH DATA
        // ==============================================================================
        // 1. Ambil nilai teks dari txtInitial dan txtSupply, lalu ubah menjadi Integer.
        // 2. HITUNG FINAL STOCK:
        //    Rumus GRUP B: final_stock = initial + supply
        // 3. Ambil nilai String dari field txtItem untuk nama item.
        // 4. Buat objek InventoryItem baru menggunakan data-data di atas.
        // 5. Panggil metode addItem() dari objek 'db' dan masukkan objek item tersebut.
        // 6. Panggil metode refreshTable() agar data baru muncul di tabel.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---


    }

    @FXML
    private void handleDelete() {
        // ==============================================================================
        // TODO 5: LOGIKA HAPUS DATA
        // ==============================================================================
        // 1. Ambil item yang sedang dipilih oleh user di tableInventory.
        // 2. Cek jika item tersebut ada (tidak null):
        //    a. (Opsional/Nilai Plus) Tampilkan Alert konfirmasi penghapusan.
        //    b. Panggil db.deleteItem() dengan parameter nama item tersebut.
        //    c. Jika berhasil terhapus dari database, hapus juga dari 'masterData'.
        //    d. Panggil clearFields().
        // 3. Jika null (user belum memilih baris), tampilkan Alert bertipe WARNING
        //    yang meminta user memilih item terlebih dahulu.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---


    }

    // Logout
    @FXML
    private void handleLogout() {
        try {
            UmbrellaApp.switchScene("login-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Bersihkan Text Fields
    @FXML
    private void clearFields() {
        txtItem.clear();
        txtInitial.clear();
        txtSupply.clear();
        txtItem.setDisable(false);
        selectedItem = null;
    }

    // Refresh Table
    @FXML
    private void refreshTable() {
        masterData.setAll(db.getAllItems());
        tableInventory.setItems(masterData);
    }
}