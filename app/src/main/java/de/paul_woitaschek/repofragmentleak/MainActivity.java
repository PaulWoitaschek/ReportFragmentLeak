package de.paul_woitaschek.repofragmentleak;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static boolean startedAgain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.VmPolicy vmPolicy = new StrictMode.VmPolicy.Builder()
                .detectActivityLeaks()
                .penaltyLog()
                .build();
        StrictMode.setVmPolicy(vmPolicy);

        super.onCreate(savedInstanceState);

        if (!startedAgain) {
            startedAgain = true;
            Intent i = new Intent(this, getClass());
            startActivity(i);
        }
    }
}
