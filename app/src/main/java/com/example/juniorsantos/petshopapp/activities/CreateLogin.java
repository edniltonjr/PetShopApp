package com.example.juniorsantos.petshopapp.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juniorsantos.petshopapp.R;
import com.example.juniorsantos.petshopapp.entities.Usuario;
import com.example.juniorsantos.petshopapp.utils.MaskEditUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateLogin extends AppCompatActivity {

    DatabaseReference databaseReference;

    @BindView(R.id.editNome)
    EditText editNome;
    @BindView(R.id.editSobrenome)
    EditText editSobrenome;
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editNumeroTelefone)
    EditText editNumeroTelefone;
    @BindView(R.id.editSenha)
    EditText editSenha;
    @BindView(R.id.editSenhaR)
    EditText editSenhaR;
    @BindView(R.id.editApelido)
    EditText editApelido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_login);
        ButterKnife.bind(this);

        databaseReference = FirebaseDatabase.getInstance().getReference("USUARIOS");

        editNumeroTelefone.addTextChangedListener(MaskEditUtil.mask(editNumeroTelefone, "(###)#####-####"));

    }

    @OnClick(R.id.btSalvar)
    public void salvar() {
        if (validaCampos()) {
            Usuario u = preencheUsuario();
            databaseReference.child(u.getStringApelido()).setValue(u);
            alert("Usuario salvo com sucesso !\nA pagina será fechada !");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
    }

    private boolean validaCampos() {
        boolean resultado = true;
        List<EditText> campos = campos();
        for (EditText campoAtual : campos) {
            if (campoAtual.getText().toString().trim().equals("")) {
                resultado = false;
                campoAtual.setError("Campo obrigatorio !");
            } else {
                switch (campoAtual.getId()) {
                    case R.id.editEmail:
                        if (!(Patterns.EMAIL_ADDRESS.matcher(campoAtual.getText().toString().trim()).matches())) {
                            campoAtual.setError("Insira um e-mail válido !");
                            resultado = false;
                        }
                        break;

                    case R.id.editSenhaR:
                        if (!(campoAtual.getText().toString().trim().equals(editSenha.getText().toString().trim()))) {
                            campoAtual.setError("Insira uma senha equivalente a senha acima !");
                        }
                        break;

                    case R.id.editNumeroTelefone:
                        if(campoAtual.getText().toString().trim().length() < 15){
                            resultado = false;
                            campoAtual.setError("Coloque um telefone completo !");
                        }
                }
            }
        }
        return resultado;
    }

    private List<EditText> campos() {
        List<EditText> campos = new ArrayList<>();
        campos.add(editEmail);
        campos.add(editNome);
        campos.add(editSobrenome);
        campos.add(editNumeroTelefone);
        campos.add(editSenha);
        campos.add(editSenhaR);
        campos.add(editApelido);
        return campos;
    }

    private Usuario preencheUsuario() {
        return new Usuario(editNome.getText().toString().trim(), editSobrenome.getText().toString().trim(), editEmail.getText().toString().trim(), editSenha.getText().toString().trim(), editNumeroTelefone.getText().toString().trim(), editApelido.getText().toString().trim() );
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
