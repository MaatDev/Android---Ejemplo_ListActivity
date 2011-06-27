package com.ejemplo.lista;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Ventana extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tx = (TextView) findViewById(R.id.tx_posicion);
        Bundle bundle = getIntent().getExtras();
        tx.setText("Position: "+bundle.getInt("posicion")+ "Char: "+bundle.getString("nombre"));
    }
}