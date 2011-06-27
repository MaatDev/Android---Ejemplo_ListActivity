package com.ejemplo.lista;

import java.util.ArrayList;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;


public class VentanaLista extends Activity{
    
    ListView list;
    MyListAdapter adapter;
    ArrayList<String> nombres;
    Intent intentCartero;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_lista);
        
        list=(ListView)findViewById(R.id.list);  
        
        nombres = new ArrayList<String>();
        
        for(int i =0;i<120;i=i+10){
        	String s="";
        	for(int j = 0;j<9;j++){
        		char a = (char) (i+j);
        		s = s+a;        		
        	}
        	nombres.add(String.valueOf(s));
        }
        
        adapter=new MyListAdapter(this, nombres);
        list.setAdapter(adapter);
            
      //http://stackoverflow.com/questions/3402255/setonclicklistener-of-a-listview-not-working
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
//				Parametersparent 	
//				parent  The AdapterView where the click happened.
//				view 	The view within the AdapterView that was clicked (this will be a view provided by the adapter)
//				position 	The position of the view in the adapter.
//				id 	The row id of the item that was clicked.
				// TODO Auto-generated method stub
				Log.v("Droidnova","Posición del list: "+position+ "Estoy viendo: "+nombres.get(position));
				prepararIntent(position);
				
			}
		});

    }
    
    public void prepararIntent(int position){
    	intentCartero = new Intent("com.ejemplo.lista.VENTANA");
    	intentCartero.putExtra("posicion", position);
    	intentCartero.putExtra("nombre", nombres.get(position));
    	startActivity(intentCartero);
    	
    }

  
    
    @Override
    public void onDestroy()
    {

        list.setAdapter(null);
        super.onDestroy();
    }
    
    

    
}