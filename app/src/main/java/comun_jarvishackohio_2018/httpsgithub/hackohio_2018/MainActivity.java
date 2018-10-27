package comun_jarvishackohio_2018.httpsgithub.hackohio_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "IP_ADDRESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterIPAddress(View view) {
        // Get server IP address
        EditText ipAddressText = findViewById(R.id.addressText);
        String serverAddress = ipAddressText.getText().toString();

        // Start another activity
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_MESSAGE, serverAddress);
        startActivity(intent);
    }
}