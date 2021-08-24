package app.skripsi.aspinkepumas.model.inserttesting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataInsertTesting {

    @Expose
    @SerializedName("id_hasil") private int id;
    @Expose
    @SerializedName("id_mahasiswa")private  int id_mahasiswa;
    @Expose
    @SerializedName("id_periode")private int id_periode;
    @Expose
    @SerializedName("id_kuis")private int id_kuis;
    @Expose
    @SerializedName("jawaban_presepsi") private String jawabanPresepsi;
    @Expose
    @SerializedName("jawaban_harapan")private String jawabanHarapan;
    @Expose
    @SerializedName("created_at") private String date;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message")private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mahasiswa() {
        return id_mahasiswa;
    }

    public void setId_mahasiswa(int id_mahasiswa) {
        this.id_mahasiswa = id_mahasiswa;
    }

    public int getId_periode() {
        return id_periode;
    }

    public void setId_periode(int id_periode) {
        this.id_periode = id_periode;
    }

    public int getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(int id_kuis) {
        this.id_kuis = id_kuis;
    }

    public String getJawabanPresepsi() {
        return jawabanPresepsi;
    }

    public void setJawabanPresepsi(String jawabanPresepsi) {
        this.jawabanPresepsi = jawabanPresepsi;
    }

    public String getJawabanHarapan() {
        return jawabanHarapan;
    }

    public void setJawabanHarapan(String jawabanHarapan) {
        this.jawabanHarapan = jawabanHarapan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
