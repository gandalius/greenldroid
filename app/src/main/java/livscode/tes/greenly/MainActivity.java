package livscode.tes.greenly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import livscode.tes.greenly.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = viewBinding.getRoot();
        setContentView(view);



    }


}