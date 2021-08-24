package app.skripsi.aspinkepumas.model.histori;

import com.google.gson.annotations.SerializedName;

public class HistoriData {

    @SerializedName("id_mhs")
    private String id_mhs;


    @SerializedName("pertanyaan")
    private String pertanyaan;

    @SerializedName("jawaban_persepsi")
    private String jawaban_persepsi;



    @SerializedName("jawaban_harapan")
    private String jawaban_harapan;


    public String getId_mhs() {
        return id_mhs;
    }

    public void setId_mhs(String id_mhs) {
        this.id_mhs = id_mhs;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban_persepsi() {
        return jawaban_persepsi;
    }

    public void setJawaban_persepsi(String jawaban_persepsi) {
        this.jawaban_persepsi = jawaban_persepsi;
    }

    public String getJawaban_harapan() {
        return jawaban_harapan;
    }

    public void setJawaban_harapan(String jawaban_harapan) {
        this.jawaban_harapan = jawaban_harapan;
    }

    @Override
    public String toString() {
        return "HistoriData{" +
                "id_mhs='" + id_mhs + '\'' +
                ", pertanyaan='" + pertanyaan + '\'' +
                ", jawaban_persepsi='" + jawaban_persepsi + '\'' +
                ", jawaban_harapan='" + jawaban_harapan + '\'' +
                '}';
    }

}
