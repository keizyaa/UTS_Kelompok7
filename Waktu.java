import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Waktu {
    private int hari = 1;

    public void lanjutHari() {
        hari++;
    }

    public int getHari() {
        return hari;
    }

    public void tampilkanWaktuSekarang() {
        LocalTime waktuSekarang = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("🕒 Waktu sekarang: " + waktuSekarang.format(fmt));
    }

    public void tampilkanWaktuSekarang(String pesan) {
        LocalTime waktuSekarang = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(pesan + " " + waktuSekarang.format(fmt));
    }
}
