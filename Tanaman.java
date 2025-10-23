public abstract class Tanaman implements Perawatan {
    protected String nama;
    protected int umur;
    protected int waktuPanen;
    protected int kebutuhanAir;
    protected int airTersedia;
    protected boolean siapPanen;
    protected boolean terkenaHama;
    protected boolean layu;

    public Tanaman(String nama, int waktuPanen, int kebutuhanAir) {
        this.nama = nama;
        this.waktuPanen = waktuPanen;
        this.kebutuhanAir = kebutuhanAir;
        this.airTersedia = 0;
        this.umur = 0;
        this.siapPanen = false;
        this.terkenaHama = false;
    }

    public void tumbuh(Cuaca cuaca) {
    if (terkenaHama) {
        System.out.println(nama + " terserang hama! Tidak tumbuh hari ini!");
        return;
    }

    // Efek cuaca terhadap air
    if (cuaca.getKondisi().equals("Hujan")) {
        airTersedia += 2; // lebih cepat nambah air
        System.out.println(nama + " mendapatkan air dari hujan.");
    } else if (cuaca.getKondisi().equals("Cerah")) {
        airTersedia++; // normal
    } else if (cuaca.getKondisi().equals("Panas")) {
        airTersedia--; // air cepat habis
        if (airTersedia < 0) airTersedia = 0;
        System.out.println(nama + " kekurangan air karena cuaca panas!");
    }

    // Pertumbuhan tanaman
    if (airTersedia >= kebutuhanAir) {
        umur++;
        airTersedia = 0;
        System.out.println(nama + " tumbuh! (Umur: " + umur + "/" + waktuPanen + ")");
    } else {
        System.out.println(nama + " butuh air lebih untuk tumbuh!");
    }

    if (umur >= waktuPanen) {
        siapPanen = true;
    }
}

    @Override
    public void siram() {
        airTersedia++;
        System.out.println("🚿 " + nama + " telah disiram!");
    }

    @Override
    public void pupuk() {
        if (!siapPanen) {
            umur++;
            System.out.println("🌿 Pupuk membantu " + nama + " tumbuh lebih cepat!");
            if (umur >= waktuPanen) siapPanen = true;
        } else {
            System.out.println("✅ " + nama + " sudah siap panen, tidak perlu pupuk lagi!");
        }
    }


    public void cekHama() {
        if (Math.random() < 0.1) {
            terkenaHama = true;
            System.out.println("🚨 Hama menyerang " + nama + "!");
        } else {
            System.out.println("✅ Tidak ada tanda-tanda hama pada " + nama + ".");
        }
    }

    public void berantasHama() {
        if (terkenaHama) {
            terkenaHama = false;
            System.out.println("🔥 Hama pada " + nama + " berhasil diberantas!");
        } else {
            System.out.println("🪴 " + nama + " sehat tanpa hama.");
        }
    }

    public String statusLengkap() {
    return nama + " | Umur: " + umur + "/" + waktuPanen + " hari | " +
           (siapPanen ? "✅ Siap Panen" : "⏳ Belum Panen");
}

    public boolean siapPanen() { return siapPanen; }
    public String getNama() { return nama; }
    public boolean isLayu() { return layu; }
    public void setLayu(boolean layu) { this.layu = layu; }
}
