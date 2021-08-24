package app.skripsi.aspinkepumas.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import app.skripsi.aspinkepumas.model.login.DataLogin;
import app.skripsi.aspinkepumas.model.login.DataLoginAdmin;
import app.skripsi.aspinkepumas.model.login.Login;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID = "id_mhs";
    public static final String NIM = "nim";
    public static final String NAMA = "nama_mhs";
    public static final String EMAIL = "email";

//    public static final  String ROLE = "role";

    public static final String IDAD = "id_admin";
    public static final String EMAILING = "email";
    public static final String NAMAA = "nama_admin";


    public SessionManager(Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();

    }

    public void createLoginSession(DataLogin mahasiswa) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, mahasiswa.getId());
        editor.putString(NIM, mahasiswa.getNim());
        editor.putString(NAMA, mahasiswa.getNama());
        editor.putString(EMAIL, mahasiswa.getEmail());
//        editor.putString(ROLE,mahasiswa.getRole());
        editor.commit();
    }

    public void createLoginAdminSession(DataLoginAdmin admin){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(IDAD, admin.getId_admin());
        editor.putString(EMAILING, admin.getEmail());
        editor.putString(NAMAA, admin.getNama());
        editor.commit();
    }

    public HashMap<String, String>getAdminDetail(){
        HashMap<String, String> admin = new HashMap<>();
        admin.put(IDAD, sharedPreferences.getString(IDAD, null));
        admin.put(EMAILING, sharedPreferences.getString(EMAILING,null));
        admin.put(NAMAA, sharedPreferences.getString(NAMAA, null));
        return admin;
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> mahasiswa = new HashMap<>();
        mahasiswa.put(ID, sharedPreferences.getString(ID, null));
        mahasiswa.put(NIM, sharedPreferences.getString(NIM, null));
        mahasiswa.put(EMAIL, sharedPreferences.getString(EMAIL, null));
//        mahasiswa.put(ROLE, sharedPreferences.getString(ROLE, null));



        return mahasiswa;
    }


    public void logoutSession(){
        editor.clear();
        editor.commit();
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}


