package sg.edu.rp.c346.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1b: Obtain an instance of the Shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Step 1c: Obtain an instance of the Shared Preference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Step 1d: Add the key-value pair
        prefEdit.putString("greeting","Hello!");
        // Step 1e: Call commit() method to save the changes into the Shared Preference
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b: Retrieve the saved data with the key, greeting from the SharedPreferences Object
        String strGreeting = prefs.getString("greeting","No Greeting");

        Toast toast = Toast.makeText(getApplicationContext(), strGreeting, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
