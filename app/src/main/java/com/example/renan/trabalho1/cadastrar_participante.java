package com.example.renan.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrar_participante extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_participante);

        nome = (EditText) findViewById(R.id.idNomeParticipante);
        email = (EditText) findViewById(R.id.idEmailParticipante);
        adicionar = (Button) findViewById(R.id.idAdicionarParticipante);

        adicionar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().isEmpty()) {
                    nome.requestFocus();
                } else if (email.getText().toString().isEmpty()) {
                    email.requestFocus();
                } else {
                    Participante part = new Participante(nome.getText().toString(), email.getText().toString(), " ", " ");

                    MainActivity.adapter.inserirParticipante(part);
                    MainActivity.adapter.atualizar();
                    nome.setText("");
                    email.setText("");

                    Toast.makeText(cadastrar_participante.this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
