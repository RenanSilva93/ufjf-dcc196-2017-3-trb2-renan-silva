package com.example.renan.trabalho1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DadosParticipantes extends AppCompatActivity {
    private Participante participante;
    private TextView nome;
    private TextView email;
    private TextView entrada;
    private TextView saida;
    private ListView lista;
    private String selecionado;
    private ReservaAdapter adapterReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participantes);

        selecionado = (String) getIntent().getSerializableExtra("id");
        int aux = (int) Integer.parseInt(selecionado);
        Participante participante = MainActivity.adapter.getParticipante(aux);

        //DateFormat df = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        nome = (TextView) findViewById(R.id.idNomeDados);
        email = (TextView) findViewById(R.id.idEmailDados);
        entrada = (TextView) findViewById(R.id.idEntradaDados);
        saida = (TextView) findViewById(R.id.idSaidaDados);
        lista = (ListView) findViewById(R.id.idListaDado);

        nome.setText(participante.getNome());
        email.setText(participante.getEmail());
        if(!participante.getEntrada().equals(" ")) {
            //Date dt =
            entrada.setText((participante.getEntrada()));
        }

        if(!participante.getSaida().equals(" ")) {
            saida.setText((participante.getSaida()));
        }

        adapterReserva = new ReservaAdapter(getApplicationContext(), MainActivity.adapterReserva.getLivroParticipante(aux));
        ArrayList<String> l = new ArrayList<>();

        for(int i=0; i<adapterReserva.getCount(); i++) {
            Livro auxLivro = MainActivity.adapterLivro.getLivro(Integer.parseInt(adapterReserva.getCursor().getString(i)));
            l.add(auxLivro.getTitulo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, l);
        lista.setAdapter(adapter);

    }

}
