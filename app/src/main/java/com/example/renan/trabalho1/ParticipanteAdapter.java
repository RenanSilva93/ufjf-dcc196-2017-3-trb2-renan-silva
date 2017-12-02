package com.example.renan.trabalho1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ParticipanteAdapter extends CursorAdapter {
    private FeiradbHelper feiradbHelper;


    public ParticipanteAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiradbHelper = new FeiradbHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.lista_layout, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNome = (TextView) view.findViewById(R.id.textView);
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Participante.COLUMN_NAME_NOME));
        txtNome.setText(nome);
    }

    public void atualizar(){
        this.changeCursor(feiradbHelper.atualizarParticipante());

    }

    public void inserirInicial(){
        //feiradbHelper.inserirInicial();
        //feiradbHelper.atualizarParticipante();

    }

    public void inserirParticipante(Participante participante){
        feiradbHelper.inserirParticipante(participante);

    }

    public Participante getParticipante(int index) {

        return feiradbHelper.getParticipante(index);
    }

    public void setEntrada(String entrada, int index) {
        feiradbHelper.setEntrada(entrada, index);
    }

    public void setSaida(String saida, int index) {
        feiradbHelper.setSaida(saida, index);
    }

    public String getEntrada(int index) {
        Log.d("getEntrada", "entrei partAdap");
        return  feiradbHelper.getEntrada(index);
    }

    public String getSaida(int index) {
        return  feiradbHelper.getSaida(index);
    }
}
