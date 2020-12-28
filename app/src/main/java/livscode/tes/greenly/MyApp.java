package livscode.tes.greenly;

import android.app.Application;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyApp extends Application {
    private static final String TAG = MyApp.class.getSimpleName();

    private ArrayList<String> boardingPassCode = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        AssetManager assetManager = getAssets();
        InputStream input;

        BufferedReader reader;
        try {
            input = assetManager.open("input1.txt");
            reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
                boardingPassCode.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getBoardingPassCode() {
        return boardingPassCode;
    }
}
