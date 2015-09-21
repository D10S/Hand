package com.example.d10s.hand;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener{
    private SensorManager mSensorManager;
    private Sensor mSensor, mSensor1, mSensor2, mSensor3, mSensor4, mSensor5;
    public TextView enx, eny, enz, renx, reny, renz, lenx, leny, lenz, venx, veny, venz, cte, genx, geny, genz, menx, meny, menz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enx = (TextView) findViewById(R.id.textView5);
        eny = (TextView) findViewById(R.id.textView6);
        enz = (TextView) findViewById(R.id.textView7);
        renx = (TextView) findViewById(R.id.textView12);
        reny = (TextView) findViewById(R.id.textView13);
        renz = (TextView) findViewById(R.id.textView14);
        lenx = (TextView) findViewById(R.id.textView19);
        leny = (TextView) findViewById(R.id.textView20);
        lenz = (TextView) findViewById(R.id.textView21);
        venx = (TextView) findViewById(R.id.textView26);
        veny = (TextView) findViewById(R.id.textView27);
        venz = (TextView) findViewById(R.id.textView28);
        cte = (TextView) findViewById(R.id.textView30);
        genx = (TextView) findViewById(R.id.textView35);
        geny = (TextView) findViewById(R.id.textView36);
        genz = (TextView) findViewById(R.id.textView37);
        menx = (TextView) findViewById(R.id.textView42);
        meny = (TextView) findViewById(R.id.textView43);
        menz = (TextView) findViewById(R.id.textView44);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            mSensorManager.registerListener(this, mSensor , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Acelerometro", Toast.LENGTH_SHORT).show();
        }


        mSensor1 = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            mSensorManager.registerListener(this, mSensor1 , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Giroscopio", Toast.LENGTH_SHORT).show();
        }


        mSensor2 = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null){
            mSensorManager.registerListener(this, mSensor2 , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Aceleracion lineal", Toast.LENGTH_SHORT).show();
        }


        mSensor3 = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) != null){
            mSensorManager.registerListener(this, mSensor3 , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Vector de Rotacion", Toast.LENGTH_SHORT).show();
        }


        mSensor4 = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR) != null){
            mSensorManager.registerListener(this, mSensor4 , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Rotacion Geomagnetica", Toast.LENGTH_SHORT).show();
        }


        mSensor5 = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            mSensorManager.registerListener(this, mSensor5 , SensorManager.SENSOR_DELAY_GAME);
        }
        else {
            Toast.makeText(this, "No tenemos \n Magnetometro", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"En Construcciòn.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onSensorChanged(SensorEvent event) {

        switch( event.sensor.getType() ) {
            case Sensor.TYPE_ACCELEROMETER:
                float x = event.values[0];
                enx.setText(""+x);
                float y = event.values[1];
                eny.setText(""+y);
                float z = event.values[2];
                enz.setText("" + z);
                break;
            case Sensor.TYPE_GYROSCOPE:
                float rx = event.values[0];
                renx.setText(""+rx);
                float ry = event.values[1];
                reny.setText(""+ry);
                float rz = event.values[2];
                renz.setText("" + rz);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                float lrx = event.values[0];
                renx.setText(""+lrx);
                float lry = event.values[1];
                reny.setText(""+lry);
                float lrz = event.values[2];
                renz.setText("" + lrz);
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                float vrx = event.values[0];
                venx.setText(""+vrx);
                float vry = event.values[1];
                veny.setText(""+vry);
                float vrz = event.values[2];
                venz.setText("" + vrz);
                float cte1 = event.values[3];
                cte.setText("" + cte1);
                break;
            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                float grx = event.values[0];
                genx.setText(""+grx);
                float gry = event.values[1];
                geny.setText(""+gry);
                float grz = event.values[2];
                genz.setText("" + grz);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                float mrx = event.values[0];
                menx.setText(""+mrx);
                float mry = event.values[1];
                meny.setText(""+mry);
                float mrz = event.values[2];
                menz.setText("" + mrz);
                break;
            default:
                return;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
