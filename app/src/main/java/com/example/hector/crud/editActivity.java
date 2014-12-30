package com.example.hector.crud;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Hector on 28/12/2014.
 */
public class editActivity extends Activity {
    final String[] datos=new String[]{"Gasolina","Diesel","Hibrido"};
    private EditText Matricula;
    private EditText Marca;
    private EditText Modelo;
    private Spinner Motorizacion;
    private EditText Cilindrada;
    private DatePicker FechaCompra;
    private String opnSpinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_coches);
        String matricula,marca,modelo,cilindrada;

        Matricula = (EditText) findViewById(R.id.entradaMatricula);
        Marca = (EditText) findViewById(R.id.entradaMarca);
        Modelo = (EditText) findViewById(R.id.entradaModelo);
        Cilindrada=(EditText)findViewById(R.id.entradaCilindrada);
        FechaCompra=(DatePicker)findViewById(R.id.datePicker);
        matricula=getIntent().getStringExtra("Matricula");
        marca=getIntent().getStringExtra("Marca");
        modelo=getIntent().getStringExtra("Modelo");
        cilindrada=getIntent().getStringExtra("Cilindrada");
        Motorizacion=(Spinner)findViewById(R.id.spnMotorizacion);
        ArrayAdapter<String> adap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,datos);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Motorizacion.setAdapter(adap);
        Motorizacion.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        opnSpinner=datos[position].toString();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        Matricula.setText(matricula);
        Marca.setText(marca);
        Modelo.setText(modelo);
        Cilindrada.setText(cilindrada);

    }
    public void onClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("¿Está seguro que desea modificar el coche? ");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Sí",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent data = new Intent();
                        Matricula = (EditText) findViewById(R.id.entradaMatricula);
                        Marca = (EditText) findViewById(R.id.entradaMarca);
                        Modelo = (EditText) findViewById(R.id.entradaModelo);
                        Motorizacion=(Spinner)findViewById(R.id.spnMotorizacion);
                        Cilindrada=(EditText)findViewById(R.id.entradaCilindrada);
                        FechaCompra=(DatePicker)findViewById(R.id.datePicker);
                        int dia,mes,anno;
                        dia=FechaCompra.getDayOfMonth();
                        mes=FechaCompra.getMonth();
                        anno=FechaCompra.getYear();
                        String fecha=dia+"/"+mes+"/"+anno;
                        Bundle b= new Bundle();
                        b.putString("Matricula",Matricula.getText().toString());
                        b.putString("Marca", Marca.getText().toString());
                        b.putString("Modelo", Modelo.getText().toString());
                        b.putString("Cilindrada", Cilindrada.getText().toString());
                        b.putString("Motorizacion",opnSpinner.toString());
                        b.putString("FechaCompra",fecha.toString());
                        data.putExtras(b);
                        setResult(RESULT_OK,data);
                        //---closes the activity---
                        finish();
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
    public void onClickCancelar(View v){
        finish();
    }

}
