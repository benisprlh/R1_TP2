import java.util.Scanner;

public class MainPerpustakaan {

    private static final int MAX_KODE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListBuku daftar = new LinkedListBuku();

        System.out.println("===== SISTEM DATA BUKU =====");

        boolean keluar = false;
        while (!keluar) {
            tampilMenu();
            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tambahBuku(sc, daftar);
                    break;
                case "2":
                    hapusBuku(daftar);
                    break;
                case "3":
                    cariBuku(sc, daftar);
                    break;
                case "4":
                    tampilSemua(daftar);
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
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Tampilkan Semua Buku");
        System.out.println("5. Keluar");
    }

    private static void tambahBuku(Scanner sc, LinkedListBuku daftar) {
        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.nextLine().trim();
        if (kode.isEmpty() || kode.length() > MAX_KODE) {
            System.out.println("Kode buku harus 1-" + MAX_KODE + " karakter.");
            return;
        }
        System.out.print("Masukkan Judul: ");
        String judul = sc.nextLine();
        System.out.print("Masukkan Penulis: ");
        String penulis = sc.nextLine();
        daftar.tambahAkhir(kode, judul, penulis);
        System.out.println("Data berhasil ditambahkan!");
    }

    private static void hapusBuku(LinkedListBuku daftar) {
        if (!daftar.hapusTerakhir()) {
            System.out.println("Tidak ada data untuk dihapus.");
        } else {
            System.out.println("Buku terakhir berhasil dihapus.");
        }
    }

    private static void cariBuku(Scanner sc, LinkedListBuku daftar) {
        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.nextLine().trim();
        Node n = daftar.cari(kode);
        if (n == null) {
            System.out.println("Buku tidak ditemukan.");
        } else {
            System.out.println("Kode: " + n.kodeBuku + " | Judul: " + n.judul + " | Penulis: " + n.penulis);
        }
    }

    private static void tampilSemua(LinkedListBuku daftar) {
        if (daftar.isEmpty()) {
            System.out.println("Daftar kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node p = daftar.getHead();
        while (p != null) {
            System.out.println("Kode: " + p.kodeBuku + " | Judul: " + p.judul + " | Penulis: " + p.penulis);
            p = p.next;
        }
        System.out.println("Total Buku: " + daftar.getSize());
    }
}
