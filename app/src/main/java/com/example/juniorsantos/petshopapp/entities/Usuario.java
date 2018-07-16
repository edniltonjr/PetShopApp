package com.example.juniorsantos.petshopapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {


    private String stringNome, stringSobrenome, stringEmail, stringSenha, stringTelefone, stringApelido;
    private int intAgendado, intPositivo;

    public Usuario() {

    }

    public Usuario(String stringNome, String stringSobrenome, String stringEmail, String stringSenha, String stringTelefone, String stringApelido) {
        this.intPositivo = 0;
        this.intAgendado = 0;

        this.stringTelefone = stringTelefone;
        this.stringSobrenome = stringSobrenome;
        this.stringSenha = stringSenha;
        this.stringEmail = stringEmail;
        this.stringNome = stringNome;
        this.stringApelido = stringApelido;
    }

    public String getStringApelido() {
        return stringApelido;
    }

    public void setStringApelido(String stringApelido) {
        this.stringApelido = stringApelido;
    }

    public String getStringNome() {
        return stringNome;
    }

    public void setStringNome(String stringNome) {
        this.stringNome = stringNome;
    }

    public String getStringSobrenome() {
        return stringSobrenome;
    }

    public void setStringSobrenome(String stringSobrenome) {
        this.stringSobrenome = stringSobrenome;
    }

    public String getStringEmail() {
        return stringEmail;
    }

    public void setStringEmail(String stringEmail) {
        this.stringEmail = stringEmail;
    }

    public String getStringSenha() {
        return stringSenha;
    }

    public void setStringSenha(String stringSenha) {
        this.stringSenha = stringSenha;
    }

    public String getStringTelefone() {
        return stringTelefone;
    }

    public void setStringTelefone(String stringTelefone) {
        this.stringTelefone = stringTelefone;
    }

    public int getIntAgendado() {
        return intAgendado;
    }

    public void setIntAgendado(int intAgendado) {
        this.intAgendado = intAgendado;
    }

    public int getIntPositivo() {
        return intPositivo;
    }

    public void setIntPositivo(int intPositivo) {
        this.intPositivo = intPositivo;
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new ClassLoaderCreator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new Usuario(parcel);
        }

        @Override
        public Usuario createFromParcel(Parcel parcel) {
            return new Usuario(parcel);
        }

        @Override
        public Usuario[] newArray(int i) {
            return new Usuario[i];
        }
    };

    private Usuario(Parcel in) {
        stringEmail = in.readString();
        stringNome = in.readString();
        stringSenha = in.readString();
        stringSobrenome = in.readString();
        stringTelefone = in.readString();
        stringApelido = in.readString();

        intAgendado = in.readInt();
        intPositivo = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(stringEmail);
        out.writeString(stringNome);
        out.writeString(stringSenha);
        out.writeString(stringSobrenome);
        out.writeString(stringTelefone);
        out.writeString(stringApelido);

        out.writeInt(intAgendado);
        out.writeInt(intPositivo);
    }
}
