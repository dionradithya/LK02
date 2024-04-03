import java.util.Scanner;

class driver {
    public String nama;
    public String noSim;

    public driver(String nama, String noSim) {
        this.nama = nama;
        this.noSim = noSim;
    }

    @Override
    public String toString() {
        return this.nama; // Mengubah agar mencetak nama supir
    }
}

class kendaraan {
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public driver supir; // Menambah properti supir

    public kendaraan(String pn, int max, driver supir) { // Menambah parameter supir dalam konstruktor
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;
        this.supir = supir; // Inisialisasi properti supir
    }

    public void cekPenumpang() {
        System.out.println("Penumpang saat ini: " + this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik) {
        System.out.println("ada " + naik + " yang ingin naik");
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("maaf penumpang melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("ada " + turun + " yang ingin turun");
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("maaf jumlah penumpang yang anda masukkan lebih dari jumlah penumpang yang ada saat ini");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("penumpang berhasil turun");
        }
        cekPenumpang();
    }
}

class truk extends kendaraan {
    int muatan;
    int kapasitas;

    public truk(String pn, int max, int kap, driver supir) {
        super(pn, max, supir);
        this.muatan = 0;
        this.kapasitas = kap;
    }

    public void cekMuatan() {
        System.out.println("Muatan saat ini adalah " + this.muatan);
    }

    public void muatanTambah(int tambah) {
        System.out.println("ada muatan yang ingin ditambahkan sebanyak " + tambah);
        int current = this.muatan;
        if (current + tambah > this.kapasitas) {
            System.out.println("maaf, muatan melebihi kapasitas");
        } else {
            this.muatan += tambah;
            System.out.println("muatan berhasil ditambahkan");
        }
        cekMuatan();
    }

    public void muatanKurang(int kurang) {
        System.out.println("ada muatan yang ingin dikurangkan sebanyak " + kurang);
        int current = this.muatan;
        if (current - kurang < 0) {
            System.out.println("maaf, muatan yang ada kurang dari itu");
        } else {
            this.muatan -= kurang;
            System.out.println("muatan berhasil dikurangkan");
        }
        cekMuatan();
    }
}

class bus extends kendaraan {
    int tarif;
    int pemasukkan;
    int bayar;

    public bus(String pn, int max, int tarif, driver supir) {
        super(pn, max, supir);
        this.tarif = tarif;
        this.pemasukkan = 0;
    }

    public void bayar(int turun) {
        bayar = tarif * turun;
        pemasukkan += bayar;
        cekPemasukkan();
    }

    public void cekPemasukkan() {
        System.out.println("Pemasukkan saat ini adalah Rp." + this.pemasukkan);
    }
}

public class LK02 {
    public static void main(String[] args) {
        int pilihan = 0;

        driver d1 = new driver("Dzaky", "34567");
        driver d2 = new driver("Gantang", "12345");

        truk t1 = new truk("N 1234 YY", 2, 50, d1); 
        bus b1 = new bus("B 4321 GG", 15, 50000, d2); // Menambahkan objek driver d2 sebagai supir bus
      
        Scanner scan = new Scanner(System.in);
        // Menampilkan menu
        System.out.println("Selamat datang di aplikasi kendaraan");
        System.out.println("Menu:");
        System.out.println("1. Truk");
        System.out.println("2. Bus");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu (masukkan angka): ");
        pilihan = scan.nextInt();

        switch (pilihan) {
            case 1:
                int pilihantruk;
                do {
                    System.out.println("Selamat datang di dalam Truk");
                    System.out.println(t1.supir.nama + " akan menjadi supir didalam kendaraan ini"); // Mengubah agar mencetak nama supir
                    System.out.println("Truk ini memiliki plat nomor " + t1.platNomor + ", Kapasitas penumpang sebanyak " + t1.maxPenumpang + " orang, dan kapasitas muatan sebesar " + t1.kapasitas + " Kg");
                    System.out.println("Menu:");
                    System.out.println("1. penumpang Naik");
                    System.out.println("2. Penumpang Turun");
                    System.out.println("3. Tambah muatan ");
                    System.out.println("4. Kurangi muatan");
                    System.out.println("5. Cek Penumpang");
                    System.out.println("6. Keluar");
                    System.out.println("pilih menu: ");
                    pilihantruk = scan.nextInt();

                    switch (pilihantruk) {
                        case 1:
                            System.out.println("Berapa jumlah penumpang naik?");
                            System.out.print("(masukkan angka): ");
                            int naik = scan.nextInt();
                            t1.penumpangNaik(naik);
                            break;
                        case 2:
                            System.out.println("Berapa jumlah penumpang turun?");
                            System.out.print("(masukkan angka): ");
                            int turun = scan.nextInt();
                            t1.penumpangTurun(turun);
                            break;
                        case 3:
                            System.out.println("Berapa jumlah muatan yang ingin ditambahkan?");
                            System.out.println("masukkan angka");
                            int tambah = scan.nextInt();
                            t1.muatanTambah(tambah);
                            break;
                        case 4:
                            System.out.println("Berapa jumlah muatan yang ingin dikurangi?");
                            System.out.println("masukkan angka");
                            int kurang = scan.nextInt();
                            t1.muatanKurang(kurang);
                            break;
                        case 5:
                            t1.cekPenumpang();
                            break;
                        case 6:
                            System.out.println("Terima kasih. Program berhenti.");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                    }
                } while (pilihantruk != 6);
                break;
            case 2:
                int pilihanBus;
                do {
                    System.out.println("Selamat datang di dalam bus");
                    System.out.println(b1.supir.nama + " akan menjadi supir didalam kendaraan ini"); // Mengubah agar mencetak nama supir
                    System.out.println("Bus ini memiliki plat nomor " + b1.platNomor + ", Kapasitas penumpang sebanyak " + b1.maxPenumpang + " orang, dengan tarif sebesar Rp." + b1.tarif + " per orangnya");
                    System.out.println("Menu:");
                    System.out.println("1. penumpang Naik");
                    System.out.println("2. Penumpang Turun");
                    System.out.println("3. Cek Penumpang");
                    System.out.println("4. Cek Pemasukkan");
                    System.out.println("5. Keluar");
                    System.out.println("pilih menu: ");
                    pilihanBus = scan.nextInt();

                    switch (pilihanBus) {
                        case 1:
                            System.out.println("Berapa jumlah penumpang naik?");
                            System.out.print("(masukkan angka): ");
                            int naikBus = scan.nextInt();
                            b1.penumpangNaik(naikBus);
                            break;
                        case 2:
                            System.out.println("Berapa jumlah penumpang turun?");
                            System.out.print("(masukkan angka): ");
                            int turunBus = scan.nextInt();
                            b1.penumpangTurun(turunBus);
                            b1.bayar(turunBus);
                            break;
                        case 3:
                            b1.cekPenumpang();
                            break;
                        case 4:
                            b1.cekPemasukkan();
                            break;
                        case 5:
                            System.out.println("Terima kasih. Program berhenti.");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih antara 1-5.");
                    }
                } while (pilihanBus != 5);
        }

        scan.close();
    }
}
