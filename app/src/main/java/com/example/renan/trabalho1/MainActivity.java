package com.example.renan.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button btnCadastrarParticipante;
    private Button btnCadastrarReserva;
    private Button btnCadastrarLivro;
    private ListView listaParticipantes;
    FeiradbHelper feiraHelper;
    public static ParticipanteAdapter adapter;
    public static LivroAdapter adapterLivro;
    public static ReservaAdapter adapterReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feiraHelper = new FeiradbHelper(getApplicationContext());
        listaParticipantes = (ListView) findViewById(R.id.idListaParticipantes);
        adapter = new ParticipanteAdapter(getBaseContext(), null);
        adapterLivro = new LivroAdapter(getBaseContext(), null);
        adapterReserva = new ReservaAdapter(getBaseContext(), null);

        adapter.atualizar();
        listaParticipantes.setAdapter(adapter);

        btnCadastrarParticipante = (Button) findViewById(R.id.idCadastrarParticipante);
        btnCadastrarReserva = (Button) findViewById(R.id.idCadastrarReserva);
        btnCadastrarLivro = (Button) findViewById(R.id.idCadastrarLivro);

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_participante.class);
                startActivity(intent);
            }
        });

        btnCadastrarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_reserva.class);
                startActivity(intent);
            }
        });

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_livro.class);
                startActivity(intent);
            }
        });

        listaParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int j = (int) (l);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                if(adapter.getEntrada(j).equals(" ")){
                    adapter.setEntrada(dateFormat.format(date), j);
                    Toast.makeText(MainActivity.this, "Entrada: "+adapter.getEntrada(j), Toast.LENGTH_SHORT).show();

                } else if(adapter.getSaida(j).equals(" ")){
                    adapter.setSaida(dateFormat.format(date), j);
                    Toast.makeText(MainActivity.this, "Saída: "+adapter.getSaida(j), Toast.LENGTH_SHORT).show();

                } else {
                    adapter.setEntrada(" ", j);
                    adapter.setSaida(" ", j);
                    Toast.makeText(MainActivity.this, "Entradas e Saídas Apagadas!"+adapter.getEntrada(j), Toast.LENGTH_SHORT).show();
                }
                return  true;
            }
        });

        listaParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int j = (int) l;
                Intent atividade = new Intent(MainActivity.this, DadosParticipantes.class);
                atividade.putExtra("id", Integer.toString(j));
                startActivity(atividade);
            }
        });

    }
}
