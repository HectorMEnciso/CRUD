package com.example.hector.crud;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hector on 28/12/2014.
 */
public class adaptadorCoches extends ArrayAdapter<Coches>implements Filterable {
    Activity context;
    ArrayList<Coches> co;

    final String[] datos=new String[]{"Gasolina","Diesel","Hibrido"};

    adaptadorCoches(Activity context,ArrayList<Coches> c){
        super(context, R.layout.activity_main,c);
        this.context=context;
        this.co=c;
    }
    public void addCoche(String Matricula,String Marca, String Modelo, String Motorizacion,String Cilindrada, String FechaCompra){
        co.add(new Coches (Matricula,Marca,Modelo,Motorizacion,Cilindrada,FechaCompra));
    }

    public void editCoche(Coches c,int posicion){
        co.set(posicion,c);
    }
    public void delCoches(ArrayList<Coches> c, int posi){
        c.remove(posi);//Borra Coches selecionada
    }
    public void deleteAll(ArrayList<Coches> c){
        c.clear();
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.mi_layout, null);

        //ImageView imagen = (ImageView)item.findViewById(R.id.foto);
        //imagen.setImageResource(co.get(position).getIdentificador());

        TextView mat = (TextView)item.findViewById(R.id.lblMatricula);
        mat.setText(co.get(position).getMatricula());

        TextView mar =(TextView)item.findViewById(R.id.lblMarca);
        mar.setText(co.get(position).getMarca());

        TextView model =(TextView)item.findViewById(R.id.lblModelo);
        model.setText(co.get(position).getModelo());

        TextView mo =(TextView)item.findViewById(R.id.lblMotorizacion);
        mo.setText(co.get(position).getMotorizacion());

        TextView ci =(TextView)item.findViewById(R.id.lblCilindrada);
        ci.setText(co.get(position).getCilindrada());

        TextView FechaCompra =(TextView)item.findViewById(R.id.lblFechaCompra);
        FechaCompra.setText(co.get(position).getFechaCompra());
        return(item);
    }
}
