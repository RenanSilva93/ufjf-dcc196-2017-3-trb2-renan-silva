package com.example.renan.trabalho1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CursorAdapter;

import java.util.ArrayList;

public class FeiradbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "feira.db";

    public FeiradbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_CREATE_RESERVA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(FeiraContract.SQL_DROP_RESERVA);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion,newVersion);
    }

    public void inserirParticipante(Participante participante){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FeiraContract.Participante.COLUMN_NAME_NOME, participante.getNome());
            values.put(FeiraContract.Participante.COLUMN_NAME_EMAIL, participante.getEmail());
            values.put(FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA, " ");
            values.put(FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA, " ");
            //db.delete(FeiraContract.Participante.TABLE_NAME, null, null);
            long id = db.insert(FeiraContract.Participante.TABLE_NAME, null, values);
            atualizarParticipante();
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
        }
    }

    public Cursor atualizarParticipante(){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA,
            };

            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, null, null, null, null, null);

            return c;

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }
    }

    public Participante getParticipante(int index) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA,
            };

            String selecao = FeiraContract.Participante._ID +"=?";
            String[] args = {Integer.toString(index)};
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, selecao, args, null, null, null);
            c.moveToFirst();
            Participante participante = new Participante(c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            return participante;

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }

    }

    public void inserirLivro(Livro livro){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FeiraContract.Livro.COLUMN_NAME_TITULO, livro.getTitulo());
            values.put(FeiraContract.Livro.COLUMN_NAME_EDITORA, livro.getEditora());
            values.put(FeiraContract.Livro.COLUMN_NAME_ANO, livro.getAno());
            long id = db.insert(FeiraContract.Livro.TABLE_NAME, null, values);
            atualizarLivro();
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
        }
    }

    public Cursor atualizarLivro(){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Livro._ID,
                    FeiraContract.Livro.COLUMN_NAME_TITULO,
            };

            Cursor c = db.query(FeiraContract.Livro.TABLE_NAME, visao, null, null, null, null, null);
            return c;

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }
    }

    public void setEntrada(String entrada, int index) { //FUNCIONOU

        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues newValues = new ContentValues();
            newValues.put(FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA, entrada);

            String selecao = FeiraContract.Participante._ID+"= ?";

            db.update(FeiraContract.Participante.TABLE_NAME, newValues, selecao, new String[]{Integer.toString(index)});
            atualizarParticipante();
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
        }
    }

    public void setSaida(String saida, int index) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues newValues = new ContentValues();
            newValues.put(FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA, saida);

            String selecao = FeiraContract.Participante._ID+"= ?";

            db.update(FeiraContract.Participante.TABLE_NAME, newValues, selecao, new String[]{Integer.toString(index)});
            atualizarParticipante();
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
        }
    }

    public String getEntrada(int index) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA,
            };
            String selecao = FeiraContract.Participante._ID+"=?";
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, selecao, new String[]{Integer.toString(index)}, null, null, null);
            //atualizarParticipante();
            c.moveToFirst();
            Log.d("getEntrada", c.getString(c.getColumnIndex(FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA)));
            return c.getString(c.getColumnIndex(FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA));
            //return null;
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }
    }

    public String getSaida(int index) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Participante._ID,
                    FeiraContract.Participante.COLUMN_NAME_NOME,
                    FeiraContract.Participante.COLUMN_NAME_EMAIL,
                    FeiraContract.Participante.COLUMN_NAME_DATA_ENTRADA,
                    FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA,
            };

            String selecao = FeiraContract.Participante._ID+"=?";
            Cursor c = db.query(FeiraContract.Participante.TABLE_NAME, visao, selecao, new String[]{Integer.toString(index)}, null, null, null);

            c.moveToFirst();
            return c.getString(c.getColumnIndex(FeiraContract.Participante.COLUMN_NAME_DATA_SAIDA));

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }
    }

    public Cursor getLivroParticipante(int participante){ //ARRUMAR

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Reserva._ID,
                    FeiraContract.Reserva.COLUMN_NAME_ID_LIVRO,
                    FeiraContract.Reserva.COLUMN_NAME_ID_PARTICIPANTE,
            };

            String selecao = FeiraContract.Reserva.COLUMN_NAME_ID_PARTICIPANTE+"=?";
            Cursor c = db.query(FeiraContract.Reserva.TABLE_NAME, visao, selecao, new String[]{Integer.toString(participante)}, null, null, null);
            c.moveToFirst();
            return c;

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }
    }

    public Livro getLivro(int index) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] visao = {
                    FeiraContract.Livro._ID,
                    FeiraContract.Livro.COLUMN_NAME_TITULO,
                    FeiraContract.Livro.COLUMN_NAME_EDITORA,
                    FeiraContract.Livro.COLUMN_NAME_ANO,
            };

            String selecao = FeiraContract.Livro._ID +"=?";
            String[] args = {Integer.toString(index)};
            Cursor c = db.query(FeiraContract.Livro.TABLE_NAME, visao, selecao, args, null, null, null);
            c.moveToFirst();
            Livro livro = new Livro(c.getString(1), c.getString(2), Integer.parseInt(c.getString(3)));
            return livro;

        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
            return null;
        }

    }

    public void inserirReserva(int participante, int livro) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FeiraContract.Reserva.COLUMN_NAME_ID_PARTICIPANTE, participante);
            values.put(FeiraContract.Reserva.COLUMN_NAME_ID_LIVRO, livro);
            long id = db.insert(FeiraContract.Reserva.TABLE_NAME, null, values);
        } catch (Exception e) {
            Log.e("FEIRA", e.getLocalizedMessage());
            Log.e("FEIRA", e.getStackTrace().toString());
        }
    }
}
