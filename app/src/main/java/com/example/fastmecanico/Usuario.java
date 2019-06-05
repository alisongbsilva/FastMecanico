package com.example.fastmecanico;

import android.view.View;

import java.security.KeyStore;
public class Usuario   {
    private String Nome;
    private String Endereco;
    private String Uf;
    private Long Telefone;
    private Long  cep;
    private Long cnh;
    private Long cpf;
    private String email;
    private KeyStore.PasswordProtection senha;
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private String Proprietario;


    //construtor e get e set de todos os campos

    public Usuario(String nome, String endereco, String uf, Long telefone, Long cep,
                   Long cnh, Long cpf, String email, KeyStore.PasswordProtection senha,
                   String placa, String modelo, String marca, int ano, String proprietario) {
        Nome = nome;
        Endereco = endereco;
        Uf = uf;
        Telefone = telefone;
        this.cep = cep;
        this.cnh = cnh;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        Proprietario = proprietario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String uf) {
        Uf = uf;
    }

    public Long getTelefone() {
        return Telefone;
    }

    public void setTelefone(Long telefone) {
        Telefone = telefone;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Long getCnh() {
        return cnh;
    }

    public void setCnh(Long cnh) {
        this.cnh = cnh;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KeyStore.PasswordProtection getSenha() {
        return senha;
    }

    public void setSenha(KeyStore.PasswordProtection senha) {
        this.senha = senha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return Proprietario;
    }

    public void setProprietario(String proprietario) {
        Proprietario = proprietario;
    }
}
