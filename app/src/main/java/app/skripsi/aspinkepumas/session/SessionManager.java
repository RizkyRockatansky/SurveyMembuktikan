package app.skripsi.aspinkepumas.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import app.skripsi.aspinkepumas.model.login.DataLogin;
import app.skripsi.aspinkepumas.model.login.Login;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID = "id";
    public static final String NIM = "nim";
    public static final String NAMA = "nama";

    public SessionManager(Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();

    }

    public void createLoginSession(DataLogin pengguna) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, pengguna.getId());
        editor.putString(NIM, pengguna.getNim());
        editor.putString(NAMA, pengguna.getNama());
        editor.commit();
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> pengguna = new HashMap<>();
        pengguna.put(ID, sharedPreferences.getString(ID, null));
        pengguna.put(NIM, sharedPreferences.getString(NIM, null));
        pengguna.put(NAMA, sharedPreferences.getString(NAMA, null));

        return pengguna;
    }
    public void logoutSession(){
        editor.clear();
        editor.commit();
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}


