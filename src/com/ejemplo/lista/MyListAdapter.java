package com.ejemplo.lista;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;


import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter   {
    
    private Activity activity;
    private ArrayList<String> Nombres;
    private static LayoutInflater inflater=null;

    
    public MyListAdapter(Activity a, ArrayList<String> c) {
        activity = a;
        Nombres = c;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
    }

    public int getCount() {
        return Nombres.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public static class ViewHolder{
        public TextView text;
        public ImageView image;
//        public String nombre;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolder holder;

        if(convertView==null){
            vi = inflater.inflate(R.layout.lista_item, null);
            holder=new ViewHolder();
            holder.text=(TextView)vi.findViewById(R.id.text);
            holder.image=(ImageView)vi.findViewById(R.id.image);
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
        
        
        holder.text.setText(Nombres.get(position));
        holder.image.setImageResource(R.drawable.icon);
//        holder.nombre = Nombres.get(position);      
        

        return vi;
    }



	
}