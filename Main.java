import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Kampus kampus = new Kampus("Kampus Akademik Mini");
        SortedList mahasiswa = new SortedList();

        int pilihan = 0;

        while (pilihan != 8) {
            System.out.println("\n================================");
            System.out.println("     SISTEM AKADEMIK MINI");
            System.out.println("================================");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Tambah Mata Kuliah");
            System.out.println("4. Tampilkan Mata Kuliah");
            System.out.println("5. Isi KRS");
            System.out.println("6. Cari Mahasiswa");
            System.out.println("7. Tampilkan Semua KRS");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                pilihan = 0;
            }

            switch (pilihan) {

                case 1:
                    System.out.println("\n--- TAMBAH MAHASISWA ---");

                    System.out.print("NIM: ");
                    String nim = input.nextLine();

                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Jurusan: ");
                    String jurusan = input.nextLine();

                    System.out.print("Semester: ");
                    int semester;

                    try {
                        semester = Integer.parseInt(input.nextLine());

                        if (semester < 1) {
                            System.out.println("Semester tidak valid.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Semester harus angka.");
                        break;
                    }

                    Mahasiswa mhs = new Mahasiswa(
                            nim, nama, jurusan, semester);

                    if (mahasiswa.insert(mhs)) {
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                    } else {
                        System.out.println("Mahasiswa gagal ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR MAHASISWA ---");
                    mahasiswa.tampilkan();
                    break;

                case 3:
                    System.out.println("\n--- TAMBAH MATA KULIAH ---");

                    System.out.print("Kode MK: ");
                    String kode = input.nextLine();

                    System.out.print("Nama MK: ");
                    String namaMK = input.nextLine();

                    System.out.print("Jumlah SKS: ");
                    int sks;

                    try {
                        sks = Integer.parseInt(input.nextLine());

                        if (sks <= 0 || sks > 24) {
                            System.out.println("SKS tidak valid.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("SKS harus angka.");
                        break;
                    }

                    System.out.print("Kuota: ");
                    int kuota;

                    try {
                        kuota = Integer.parseInt(input.nextLine());

                        if (kuota <= 0) {
                            System.out.println("Kuota tidak valid.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Kuota harus angka.");
                        break;
                    }

                    MataKuliah mk = new MataKuliah(
                            kode, namaMK, sks, kuota);

                    if (kampus.tambahMataKuliah(mk)) {
                        System.out.println("Mata kuliah berhasil ditambahkan.");
                    } else {
                        System.out.println("Mata kuliah gagal ditambahkan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- DAFTAR MATA KULIAH ---");
                    kampus.tampilkanMataKuliah();
                    break;

                case 5:
                    System.out.println("\n--- PENGISIAN KRS ---");

                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimKRS = input.nextLine();

                    Mahasiswa cariMhs = mahasiswa.search(nimKRS);

                    if (cariMhs == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }

                    kampus.tambahKRS(
                            cariMhs.getNim(),
                            cariMhs.getNama());

                    KRS krs = kampus.cariKRS(nimKRS);

                    System.out.println("\nDaftar Mata Kuliah:");
                    kampus.tampilkanMataKuliah();

                    System.out.print("Masukkan kode MK yang diambil: ");
                    String kodeKRS = input.nextLine();

                    MataKuliah cariMK = kampus.cariMataKuliah(kodeKRS);

                    if (cariMK == null) {
                        System.out.println("Mata kuliah tidak ditemukan.");
                        break;
                    }

                    krs.tambahMataKuliah(cariMK);
                    krs.tampilkanKRS();
                    break;

                case 6:
                    System.out.println("\n--- CARI MAHASISWA ---");

                    System.out.print("Masukkan NIM: ");
                    String cariNim = input.nextLine();

                    Mahasiswa hasil = mahasiswa.search(cariNim);

                    if (hasil != null) {
                        System.out.println("\nData ditemukan:");
                        hasil.tampilkanInfo();
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- DAFTAR KRS ---");
                    kampus.tampilkanSemuaKRS();
                    break;

                case 8:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

        input.close();
    }
}