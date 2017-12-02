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

import java.util.ArrayList;

public class ReservaAdapter extends CursorAdapter {
    private FeiradbHelper feiradbHelper;

    public ReservaAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiradbHelper = new FeiradbHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.lista_layout,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitulo = (TextView) view.findViewById(R.id.textView);
        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(FeiraContract.Reserva.COLUMN_NAME_ID_LIVRO));
        txtTitulo.setText(titulo);
    }

    public void inserirReserva(int participante, int livro){
        feiradbHelper.inserirReserva(participante, livro);
    }

    public Cursor getLivroParticipante(int participante) {
        return feiradbHelper.getLivroParticipante(participante);
    }
}
