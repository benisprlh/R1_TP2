import java.util.Scanner;

public class MainKasir {

    private static final int MAX_ANTRIAN = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueuePelanggan antrian = new QueuePelanggan(MAX_ANTRIAN);
        StackRiwayat riwayat = new StackRiwayat();

        System.out.println("=== SISTEM KASIR TOKO ===");

        boolean keluar = false;
        while (!keluar) {
            tampilMenu();
            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tambahAntrian(sc, antrian);
                    break;
                case "2":
                    layaniPelanggan(antrian, riwayat);
                    break;
                case "3":
                    tampilkanAntrian(antrian);
                    break;
                case "4":
                    lihatRiwayat(riwayat);
                    break;
                case "5":
                    keluar = true;
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void tampilMenu() {
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");
    }

    private static void tambahAntrian(Scanner sc, QueuePelanggan antrian) {
        if (antrian.getSize() >= antrian.getKapasitasMaks()) {
            System.out.println("Antrian penuh (maksimal " + antrian.getKapasitasMaks() + " pelanggan).");
            return;
        }
        System.out.print("Masukkan Nomor Antrian: ");
        String nomor = sc.nextLine().trim();
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = sc.nextLine().trim();
        System.out.print("Masukkan Total Belanja: ");
        double total;
        try {
            total = Double.parseDouble(sc.nextLine().trim().replace(",", ""));
        } catch (NumberFormatException e) {
            System.out.println("Total belanja tidak valid.");
            return;
        }
        if (antrian.enqueue(nomor, nama, total)) {
            System.out.println("Data pelanggan ditambahkan ke antrian!");
        } else {
            System.out.println("Gagal menambahkan (antrian penuh).");
        }
    }

    private static void layaniPelanggan(QueuePelanggan antrian, StackRiwayat riwayat) {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada pelanggan untuk dilayani.");
            return;
        }
        Node dilayani = antrian.dequeue();
        riwayat.push(dilayani);
        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian + " (" + dilayani.namaPelanggan + ")");
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    private static void tampilkanAntrian(QueuePelanggan antrian) {
        if (antrian.isEmpty()) {
            System.out.println("Antrian saat ini kosong.");
            return;
        }
        System.out.println("Antrian saat ini (depan → belakang):");
        Node p = antrian.getFront();
        int no = 1;
        while (p != null) {
            System.out.println(no + ". " + p.nomorAntrian + " | " + p.namaPelanggan + " | Rp "
                    + (long) p.totalBelanja);
            p = p.next;
            no++;
        }
        System.out.println("Jumlah dalam antrian: " + antrian.getSize());
    }

    private static void lihatRiwayat(StackRiwayat riwayat) {
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat transaksi (terbaru → lama):");
        Node p = riwayat.getTop();
        int no = 1;
        while (p != null) {
            System.out.println(no + ". " + p.nomorAntrian + " | " + p.namaPelanggan + " | Rp "
                    + (long) p.totalBelanja);
            p = p.next;
            no++;
        }
    }
}
