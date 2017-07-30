package good.force.teah.makeawish.ConnectionManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Anurag on 7/29/2017.
 */

public class Session {
    // LogCat tag
    private static String TAG = "Session";

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Login";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    public Session(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
