package com.example.renan.trabalho1;

import android.provider.BaseColumns;

public final class FeiraContract {
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";

    public static final String SQL_CREATE_PARTICIPANTE = "CREATE TABLE " + Participante.TABLE_NAME + " (" +
            Participante._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Participante.COLUMN_NAME_NOME + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_EMAIL + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_DATA_ENTRADA + TEXT_TYPE + SEP +
            Participante.COLUMN_NAME_DATA_SAIDA + TEXT_TYPE + ")";
    public static final String SQL_DROP_PARTICIPANTE = "DROP TABLE IF EXISTS " + Participante.TABLE_NAME;

    public static final String SQL_CREATE_LIVRO = "CREATE TABLE " + Livro.TABLE_NAME + " (" +
            Livro._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Livro.COLUMN_NAME_TITULO + TEXT_TYPE + SEP +
            Livro.COLUMN_NAME_EDITORA + TEXT_TYPE + SEP +
            Livro.COLUMN_NAME_ANO + INT_TYPE + ")";
    public static final String SQL_DROP_LIVRO = "DROP TABLE IF EXISTS " + Livro.TABLE_NAME;

    public static final String SQL_CREATE_RESERVA = "CREATE TABLE " + Reserva.TABLE_NAME + " (" +
            Reserva._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Reserva.COLUMN_NAME_ID_PARTICIPANTE + INT_TYPE + SEP +
            Reserva.COLUMN_NAME_ID_LIVRO + INT_TYPE + ")";
    public static final String SQL_DROP_RESERVA = "DROP TABLE IF EXISTS " + Reserva.TABLE_NAME;

    public FeiraContract() {
    }

    public static final class Participante implements BaseColumns {
        public static final String TABLE_NAME = "participante";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_DATA_ENTRADA = "data_entrada";
        public static final String COLUMN_NAME_DATA_SAIDA = "data_saida";
    }

    public static final class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_EDITORA = "editora";
        public static final String COLUMN_NAME_ANO = "ano";
    }

    public static final class Reserva implements BaseColumns {
        public static final String TABLE_NAME = "reserva";
        public static final String COLUMN_NAME_ID_PARTICIPANTE = "id_participante";
        public static final String COLUMN_NAME_ID_LIVRO = "id_livro";
    }
}
