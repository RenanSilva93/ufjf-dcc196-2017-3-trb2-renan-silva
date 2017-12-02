package com.example.renan.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class cadastrar_reserva extends AppCompatActivity {
    private EditText nome;
    private EditText livro;
    private Button btnAdicionar;
    Spinner sp;
    Spinner sp2;
    public static ParticipanteAdapter adapterParticipante;
    public static LivroAdapter adapterLivro;
    public static ReservaAdapter adapterReserva;
    int idParticipante;
    int idLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_reserva);

        btnAdicionar = (Button) findViewById(R.id.idAdicionarReserva);

        adapterParticipante = new ParticipanteAdapter(getBaseContext(), null);
        adapterParticipante.atualizar();

        sp = (Spinner) findViewById(R.id.spinner);
        sp.setAdapter(adapterParticipante);

        adapterLivro = new LivroAdapter(getBaseContext(), null);
        adapterLivro.atualizar();
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp2.setAdapter(adapterLivro);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idParticipante = (int) l;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idLivro = (int) l;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("part", Integer.toString(idParticipante));
                Log.d("livro", Integer.toString(idLivro));
                if(!adapterParticipante.getEntrada(idParticipante).equals(" "))  {
                    if(adapterParticipante.getSaida(idParticipante).equals(" ")) {
                        adapterReserva = new ReservaAdapter(getBaseContext(), null);
                        adapterReserva.inserirReserva(idParticipante, idLivro);
                        Toast.makeText(cadastrar_reserva.this, "Reservado com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(cadastrar_reserva.this, "Não foi possível realizar reserva!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(cadastrar_reserva.this, "Não foi possível realizar reserva!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
