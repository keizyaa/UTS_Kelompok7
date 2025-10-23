import java.util.ArrayList;

public class Lahan {
    private ArrayList<Tanaman> daftarTanaman;

    public Lahan() {
        daftarTanaman = new ArrayList<>();
    }

    public void tanam(Tanaman tanaman) {
        daftarTanaman.add(tanaman);
        System.out.println("🌾 " + tanaman.getNama() + " berhasil ditanam di lahan.");
    }

    public void tumbuhSemua(Cuaca cuaca) {
        System.out.println("\n🌤️ Hari ini cuacanya: " + cuaca.getKondisi());
        for (Tanaman t : daftarTanaman) {
            t.tumbuh(cuaca);
        }
    }

    public void siramSemua() {
        for (Tanaman t : daftarTanaman) {
            t.siram();
        }
    }

    public void pupukSemua() {
        for (Tanaman t : daftarTanaman) {
            t.pupuk();
        }
    }

    public void periksaHama() {
        for (Tanaman t : daftarTanaman) {
            t.cekHama();
        }
    }

    public void berantasHama() {
        for (Tanaman t : daftarTanaman) {
            t.berantasHama();
        }
    }

public void panenSemua(Petani petani) {
    System.out.println("\n🚜 Proses panen dimulai...");
    ArrayList<Tanaman> panen = new ArrayList<>();

    for (Tanaman t : daftarTanaman) {
        if (t.siapPanen()) {
            System.out.println("✅ " + t.getNama() + " berhasil dipanen!");
            petani.simpanKeGudang(t); 
            panen.add(t);
        } else {
            System.out.println("⏳ " + t.getNama() + " belum siap panen.");
        }
    }

    daftarTanaman.removeAll(panen);
}

   public void tampilkanStatus() {
    System.out.println("\n📋 Status semua tanaman di lahan:");
    if (daftarTanaman.isEmpty()) {
        System.out.println("❌ Belum ada tanaman di lahan.");
    } else {
        for (Tanaman t : daftarTanaman) {
            System.out.println("- " + t.statusLengkap());
        }
    }
}

    public boolean isKosong() {
        return daftarTanaman.isEmpty();
    }
}


