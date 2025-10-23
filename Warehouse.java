import java.util.HashMap;

public class Warehouse {
    private int kapasitas;
    private HashMap<String, Integer> isiGudang = new HashMap<>();

    public Warehouse(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void simpan(String nama, int jumlah) {
        nama = nama.toLowerCase();
        int totalIsi = isiGudang.values().stream().mapToInt(Integer::intValue).sum();
        if (totalIsi + jumlah > kapasitas) {
            System.out.println("❌ Gudang penuh! Tidak bisa menyimpan " + nama);
            return;
        }
        isiGudang.put(nama, isiGudang.getOrDefault(nama, 0) + jumlah);
        System.out.println("📦 " + jumlah + " " + nama + " disimpan ke gudang.");
    }

    public boolean keluarkan(String nama, int jumlah) {
        nama = nama.toLowerCase();
        if (isiGudang.containsKey(nama) && isiGudang.get(nama) >= jumlah) {
            isiGudang.put(nama, isiGudang.get(nama) - jumlah);
            if (isiGudang.get(nama) == 0) isiGudang.remove(nama);
            System.out.println("📤 " + jumlah + " " + nama + " dikeluarkan dari gudang.");
            return true;
        }
        System.out.println("❌ Stok " + nama + " tidak cukup di gudang!");
        return false;
    }

    public void cekIsi() {
        if (isiGudang.isEmpty()) {
            System.out.println("📦 Gudang kosong.");
        } else {
            for (String nama : isiGudang.keySet()) {
                System.out.println("- " + nama + " : " + isiGudang.get(nama));
            }
        }
    }

    
}
