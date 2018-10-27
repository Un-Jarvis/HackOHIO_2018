package comun_jarvishackohio_2018.httpsgithub.hackohio_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginActivity extends AppCompatActivity {

    private static final int PORT = 9072;

    private BufferedReader in;
    private PrintWriter out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String serverAddress = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        try {
            // Make connection
            Socket socket = new Socket(serverAddress, PORT);

            // Initialize streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {

        }
    }

    public void signIn(View view) {
        // Set up GUI
        EditText usernameText = findViewById(R.id.Username);
        EditText passwordText = findViewById(R.id.Password);

        // Get user information
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
    }
}
