package instagram.mpsdm.com.instagram.revision;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import instagram.mpsdm.com.instagram.R;
import instagram.mpsdm.com.instagram.databinding.ActivityJavaRevisionBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JavaRevisionActivity extends AppCompatActivity implements SensorEventListener {

    private GerritAPI gerritAPI;
    private SensorManager sensorManager;
    private long lastUpdate;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_java_revision);


        ActivityJavaRevisionBinding mBinding = DataBindingUtil.setContentView(this,R.layout.activity_java_revision);
        //mBinding.txt.setText("kks");

        /*
        for fragments
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater(), container, attachToContainer);
        // get the root view
        View view = binding.getRoot();

         */


        // ########################### START FRAGMENT #############################
        //getSupportFragmentManager().beginTransaction().replace(R.id.listFragment,new HomeFragment()).commit();

        // ########################### SHARED PREFERENCES #############################
        SharedPreferences settings = getSharedPreferences("Test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("sd",true);
        editor.apply();



        // ########################### SQLITE #############################
        /*
         User user;
         AppDatabase database;
         database = AppDatabase.getDatabase(getApplicationContext());
         database.userDao().removeAllUsers();
         database.userDao().addUser(new User(1,"",456));
        */


        gerritAPI.loadChanges("sq").enqueue(answersCallback);
        createAPI();


        // ############################ ASK PERMISSION #####################
        int permissionCheck = checkSelfPermission(Manifest.permission.WRITE_CALENDAR);
        if (!(permissionCheck == PackageManager.PERMISSION_GRANTED)) {
            // User may have declined earlier, ask Android if we should show him a reason
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CALENDAR)) {
                // show an explanation to the user
                // Good practise: don't block thread after the user sees the explanation, try again to request the permission.
            } else {
                // request the permission.
                // CALLBACK_NUMBER is a integer constants
                requestPermissions(new String[]{Manifest.permission.WRITE_CALENDAR}, 69);
                // The callback method gets the result of the request.
            }
        } else {
            // got permission use it
        }


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        /*
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[] { "https://www.vogella.com/index.html" });
        */


        //####################### PICK IMG #########################
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 88);


    }



    Callback<List<User>> answersCallback = new Callback<List<User>>() {
        @Override
        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
            if (response.isSuccessful()) {
                List<User> data = new ArrayList<>();
                //data.addAll(response.body().items);
                //recyclerView.setAdapter(new RecyclerViewAdapter(data));
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }
        @Override
        public void onFailure(Call<List<User>> call, Throwable t) {
            t.printStackTrace();
        }
    };



    private void createAPI() {
        /*
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GerritAPI.BASE_URL)
                //.addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        gerritAPI = retrofit.create(GerritAPI.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        InputStream stream = null;
        if (requestCode == 88 && resultCode == Activity.RESULT_OK)
            try {
                // recyle unused bitmaps
                /*
                if (bitmap != null) {
                    bitmap.recycle();
                }
                */
                //stream = getContentResolver().openInputStream(data.getData());
                //bitmap = BitmapFactory.decodeStream(stream);

                //imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 69: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, do your work....
                } else {
                    // permission denied
                    // Disable the functionality that depends on this permission.
                }
                return;
            }

            // other 'case' statements for other permssions
        }
    }




    // ################# Check network availability #################
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelationSquareRoot >= 2) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
                    .show();
            /*
            if (color==true) {
                view.setBackgroundColor(Color.GREEN);
            } else {
                view.setBackgroundColor(Color.RED);
            }
            color = !color;
            */
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}


class DownloadWebPageTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
        OkHttpClient client = new OkHttpClient();
        Request request =
                new Request.Builder()
                        .url(urls[0])
                        .build();
        okhttp3.Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Download failed";
    }



    @Override
    protected void onPostExecute(String result) {
        //textView.setText(result);
    }
}

