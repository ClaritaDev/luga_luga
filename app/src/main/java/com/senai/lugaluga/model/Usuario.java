package com.senai.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private String nome;

    private String cpf;

    private String data;

    private String cep;

    private String cidade;

    private String uf;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private int telefone;

    private String email;

    private String senha;

    public Usuario() {
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    protected Usuario(Parcel in) {
        nome = in.readString();
        cpf = in.readString();
        data = in.readString();
        cep = in.readString();
        cidade = in.readString();
        uf = in.readString();
        logradouro = in.readString();
        numero = in.readString();
        complemento = in.readString();
        bairro = in.readString();
        telefone = in.readInt();
        email = in.readString();
        senha = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(cpf);
        dest.writeString(data);
        dest.writeString(cep);
        dest.writeString(cidade);
        dest.writeString(uf);
        dest.writeString(logradouro);
        dest.writeString(numero);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeInt(telefone);
        dest.writeString(email);
        dest.writeString(senha);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
