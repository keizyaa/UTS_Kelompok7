import java.util.HashMap;

public class Toko {
    private HashMap<String, Integer> hargaBibit = new HashMap<>();
    private HashMap<String, Integer> hargaJual = new HashMap<>();

    public Toko() {
        hargaBibit.put("jagung", 50);
        hargaBibit.put("tomat", 40);
        hargaBibit.put("gandum", 60);

        hargaJual.put("jagung", 200);
        hargaJual.put("tomat", 150);
        hargaJual.put("gandum", 250);
    }

    public void tampilkanBibit() {
        System.out.println("🌱 Daftar bibit yang tersedia:");
        for (String nama : hargaBibit.keySet()) {
            System.out.println("- " + nama + " ($" + hargaBibit.get(nama) + ")");
        }
    }

    public Tanaman jualBibit(Petani petani, String nama) {
        nama = nama.toLowerCase();
        if (!hargaBibit.containsKey(nama)) {
            System.out.println("❌ Bibit tidak tersedia!");
            return null;
        }
        int harga = hargaBibit.get(nama);
        if (petani.getUang() < harga) {
            System.out.println("💸 Uang tidak cukup untuk membeli bibit " + nama + "!");
            return null;
        }

        petani.kurangiUang(harga);
        System.out.println("✅ " + nama + " berhasil dibeli seharga $" + harga);

        switch (nama) {
            case "jagung": return new Jagung();
            case "tomat": return new Tomat();
            case "gandum": return new Gandum();
            default: return null;
        }
    }

    public int beliHasilPanen(Petani petani, String nama, int jumlah) {
        nama = nama.toLowerCase();
        if (!hargaJual.containsKey(nama)) {
            System.out.println("❌ Toko tidak membeli hasil panen ini!");
            return 0;
        }
        int total = hargaJual.get(nama) * jumlah;
        System.out.println("🛒 Toko membeli " + jumlah + " " + nama + " senilai $" + total);
        return total;
    }
}
