public class Petani {
    private String nama;
    private int uang;
    private int energi;
    private Warehouse warehouse;

    public Petani(String nama, int uang) {
        this.nama = nama;
        this.uang = uang;
        this.energi = 100;
    }

    public void setWarehouse(Warehouse w) {
        this.warehouse = w;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getUang() {
        return uang;
    }

    public void kurangiUang(int jumlah) {
        uang -= jumlah;
    }

    public void tambahUang(int jumlah) {
        uang += jumlah;
    }

    public int getEnergi() {
        return energi;
    }

    public void kurangiEnergi(int jumlah) {
        energi = Math.max(0, energi - jumlah);
    }

    public void pulihkanEnergi(int jumlah) {
        energi = Math.min(100, energi + jumlah);
    }

    public void simpanKeGudang(Tanaman hasil) {
        warehouse.simpan(hasil.getNama(), 1);
    }

    public void jualHasil(Toko toko, String nama, int jumlah) {
        int total = toko.beliHasilPanen(this, nama, jumlah);
        if (warehouse.keluarkan(nama.toLowerCase(), jumlah)) {
            tambahUang(total);
            System.out.println("🪙 +" + total + " ditambahkan ke saldo Anda!");
        } else {
            System.out.println("❌ Stok tidak cukup di gudang!");
        }
    }
}
