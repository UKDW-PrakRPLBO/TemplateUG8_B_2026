package org.rplbo.app.ug8;

/**
 * Model class untuk item inventaris Sector B.
 * Digunakan untuk mapping data dari database SQLite ke TableView JavaFX.
 */
public class InventoryItem {
    private String itemName;
    private int initialStock; // Stok Awal
    private int newSupply;    // Pasokan Baru
    private int finalStock;   // Stok Akhir (Hasil Penjumlahan)

    /**
     * Constructor untuk inisialisasi objek InventoryItem.
     */
    public InventoryItem(String itemName, int initialStock, int newSupply, int finalStock) {
        this.itemName = itemName;
        this.initialStock = initialStock;
        this.newSupply = newSupply;
        this.finalStock = finalStock;
    }

    // Getter dan Setter untuk Item Name
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter dan Setter untuk Initial Stock
    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    // Getter dan Setter untuk New Supply
    public int getNewSupply() {
        return newSupply;
    }

    public void setNewSupply(int newSupply) {
        this.newSupply = newSupply;
    }

    // Getter dan Setter untuk Final Stock
    public int getFinalStock() {
        return finalStock;
    }

    public void setFinalStock(int finalStock) {
        this.finalStock = finalStock;
    }
}