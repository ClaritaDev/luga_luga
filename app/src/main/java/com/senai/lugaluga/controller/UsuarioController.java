package com.senai.lugaluga.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioController {

    private SQLiteDatabase db;

    private CriarBanco banco;

    public UsuarioController(Context context){
        banco = new CriarBanco(context);}


    public String insereDados(String nome, String cpf, String dataNasc,
                              String cep, String municipio, String logradouro,
                              String numero, String complemento, String bairro,
                              int telefone, String email, String senha,
                                String uf){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.NOME,nome);
        valores.put(CriarBanco.CPF,cpf);
        valores.put(CriarBanco.DATA_NASC,dataNasc);
        valores.put(CriarBanco.CEP,cep);
        valores.put(CriarBanco.MUNICIPIO,municipio);
        valores.put(CriarBanco.UF,uf);
        valores.put(CriarBanco.LOGRADOURO,logradouro);
        valores.put(CriarBanco.NUMERO,numero);
        valores.put(CriarBanco.COMPLEMENTO,complemento);
        valores.put(CriarBanco.BAIRRO,bairro);
        valores.put(CriarBanco.TELEFONE,telefone);
        valores.put(CriarBanco.EMAIL,email);
        valores.put(CriarBanco.SENHA,senha);

        resultado = db.insert(CriarBanco.NOME_TABELA, null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir registro";
        }

        return "Inserido com sucesso";
    }
}
