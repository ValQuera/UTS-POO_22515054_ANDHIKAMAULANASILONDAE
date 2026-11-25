public class SortedList {
    private Mahasiswa[] data;
    private int jumlah;

    public SortedList() {
        data = new Mahasiswa[100];
        jumlah = 0;
    }

    public boolean insert(Mahasiswa mhs) {
        if (jumlah >= data.length) {
            System.out.println("Data mahasiswa penuh.");
            return false;
        }

        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equals(mhs.getNim())) {
                System.out.println("NIM sudah terdaftar.");
                return false;
            }
        }

        int posisi = jumlah;

        while (posisi > 0 &&
                data[posisi - 1].getNim().compareTo(mhs.getNim()) > 0) {
            data[posisi] = data[posisi - 1];
            posisi--;
        }

        data[posisi] = mhs;
        jumlah++;

        return true;
    }

    public Mahasiswa search(String nim) {
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equals(nim)) {
                return data[i];
            }
        }

        return null;
    }

    public Mahasiswa get(int index) {
        if (index >= 0 && index < jumlah) {
            return data[index];
        }

        return null;
    }

    public void tampilkan() {
        if (jumlah == 0) {
            System.out.println("Data mahasiswa masih kosong.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {
            System.out.println("-------------------");
            data[i].tampilkanInfo();
        }
    }

    public int size() {
        return jumlah;
    }

    public boolean remove(String nim) {
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equals(nim)) {
                for (int j = i; j < jumlah - 1; j++) {
                    data[j] = data[j + 1];
                }

                data[jumlah - 1] = null;
                jumlah--;
                return true;
            }
        }

        return false;
    }
}