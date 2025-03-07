import java.io.*;
import java.util.*;

public class Database {
    private static final String FILE_NAME = "data_mahasiswa.csv";
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Database() {
        loadData();
    }

    public void addMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
        saveData();
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return daftarMahasiswa;
    }

    public Mahasiswa findMahasiswa(String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public void updateMahasiswa(String nim, String namaBaru, String alamatBaru, int semesterBaru, int sksBaru, double ipkBaru) {
        Mahasiswa mhs = findMahasiswa(nim);
        if (mhs != null) {
            mhs.setNama(namaBaru);
            mhs.setAlamat(alamatBaru);
            mhs.setSemester(semesterBaru);
            mhs.setSks(sksBaru);
            mhs.setIpk(ipkBaru);
            saveData();
        }
    }

    public void deleteMahasiswa(String nim) {
        daftarMahasiswa.removeIf(mhs -> mhs.getNim().equals(nim));
        saveData();
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Mahasiswa mhs : daftarMahasiswa) {
                bw.write(mhs.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        daftarMahasiswa.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {  // Pastikan jumlah kolom sesuai
                    daftarMahasiswa.add(new Mahasiswa(
                            data[0], data[1], data[2],
                            Integer.parseInt(data[3]),
                            Integer.parseInt(data[4]),
                            Double.parseDouble(data[5])
                    ));
                } else {
                    System.out.println("Peringatan: Format data salah, lewati baris -> " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}