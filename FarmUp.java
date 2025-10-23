import java.util.*;

public class FarmUp {
    public static void main(String[] args) {
        tampilkanOpening();

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama petani Anda: ");
        String nama = sc.nextLine();

        // Inisialisasi objek utama
        Petani petani = new Petani(nama, 100);
        Lahan lahan = new Lahan();
        Cuaca cuaca = new Cuaca();
        Waktu waktu = new Waktu();
        Toko toko = new Toko();
        Warehouse warehouse = new Warehouse(20);
        petani.setWarehouse(warehouse);

        waktu.tampilkanWaktuSekarang();

        System.out.println("\nSelamat datang di FarmUp, " + nama + " 🌱");
        System.out.println("Mulailah menanam dan kembangkan pertanianmu!\n");

        boolean bermain = true;
        while (bermain) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║          🌾 FARM UP! SIMULATOR 🌾        ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.printf("║ 🕒 Hari ke-%-3d     ☀️ Cuaca : %-10s║\n", waktu.getHari(), cuaca.getKondisi());
            System.out.printf("║ 💰 Uang : $%-6d  ⚡ Energi : %-3d/100   ║\n", petani.getUang(), petani.getEnergi());
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("🏠 Isi Gudang :");
            petani.getWarehouse().cekIsi();

            System.out.println("\nMenu:");
            System.out.println("1. Beli & Tanam Bibit");
            System.out.println("2. Sirami Tanaman");
            System.out.println("3. Pupuk Tanaman");
            System.out.println("4. Cek & Berantas Hama");
            System.out.println("5. Panen Tanaman");
            System.out.println("6. Lewati Hari");
            System.out.println("7. Cek Status Tanaman");
            System.out.println("8. Jual Hasil Panen");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1 -> {
                    toko.tampilkanBibit();
                    System.out.print("Pilih bibit (Jagung/Tomat/Gandum): ");
                    String bibit = sc.next();
                    Tanaman t = toko.jualBibit(petani, bibit);
                    if (t != null) {
                        lahan.tanam(t);
                        System.out.println("🌱 Kamu menanam " + bibit + " di lahan!");
                        petani.kurangiEnergi(10);
                    }
                }

                case 2 -> {
                    lahan.siramSemua();
                    petani.kurangiEnergi(5);
                }

                case 3 -> {
                    lahan.pupukSemua();
                    petani.kurangiEnergi(5);
                }

                case 4 -> {
                    lahan.periksaHama();
                    lahan.berantasHama();
                    petani.kurangiEnergi(5);
                }

                case 5 -> {
                    lahan.panenSemua(petani);
                    petani.kurangiEnergi(10);
                    petani.getWarehouse().cekIsi();
                }

                case 6 -> { // Lewati Hari
                    waktu.lanjutHari();
                    cuaca.ubahCuaca(); // ubah cuaca harian
                    
                    System.out.println("\nHari berganti ke hari ke-" + waktu.getHari() + "!");
                    waktu.tampilkanWaktuSekarang();
                    System.out.println("Cuaca hari ini: " + cuaca.getKondisi());

                    // Efek cuaca terhadap pertumbuhan tanaman
                    lahan.tumbuhSemua(cuaca);

                    // Tambah efek lain berdasarkan cuaca
                    if (cuaca.getKondisi().equals("Panas")) {
                        System.out.println("⚠️ Cuaca panas membuat tanaman cepat layu jika tidak disiram!");
                    } else if (cuaca.getKondisi().equals("Hujan")) {
                        System.out.println("🌧️ Hujan menyiram tanaman, kamu hemat tenaga hari ini!");
                    }

                    petani.pulihkanEnergi(10);
                }

                case 7 -> lahan.tampilkanStatus();
                case 8 -> {
                warehouse.cekIsi();
                System.out.print("Masukkan nama hasil panen yang ingin dijual: ");
                String hasil = sc.next().toLowerCase();
                System.out.print("Jumlah yang ingin dijual: ");
                int jumlah = sc.nextInt();
                petani.jualHasil(toko, hasil, jumlah);
            }

                case 0 -> {
                    bermain = false;
                    tampilkanPenutup();
                }

                default -> System.out.println("❌ Pilihan tidak valid!");
            }

            if (petani.getEnergi() <= 0) {
                System.out.println("\n⚠️ Kamu kelelahan! Istirahat sehari...");
                waktu.lanjutHari();
                petani.pulihkanEnergi(100);
            }
        }

        sc.close();
    }

    public static void tampilkanOpening() {
        System.out.println("=========================================================");
        System.out.println("                     🌾  WELCOME TO  🌾                  ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("     ███████╗ █████╗ ██████╗ ███╗   ███╗██╗   ██╗██████╗ ");
        System.out.println("     ██╔════╝██╔══██╗██╔══██╗████╗ ████║██║   ██║██╔══██╗");
        System.out.println("     █████╗  ███████║██████╔╝██╔████╔██║██║   ██║██████╔╝");
        System.out.println("     ██╔══╝  ██╔══██║██╔══██╗██║╚██╔╝██║██║   ██║██╔══╝  ");
        System.out.println("     ██║     ██║  ██║██║  ██║██║ ╚═╝ ██║╚██████╔╝██║     ");
        System.out.println("     ╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝ ╚═════╝ ╚═╝     ");
        System.out.println();
        System.out.println("                    🌾  F A R M U P !  ");
        System.out.println("          Grow your crops, build your farm, and rise!");
        System.out.println("==========================================================");
    }

    public static void tampilkanPenutup() {
        System.out.println("\n====================================================");
        System.out.println("🌾 Terima kasih telah bermain FarmUp! 🌾");
        System.out.println("Panen melimpah, hati bahagia! 💰");
        System.out.println("====================================================");
    }
}
