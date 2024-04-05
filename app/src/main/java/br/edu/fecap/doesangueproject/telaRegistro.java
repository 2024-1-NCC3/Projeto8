package br.edu.fecap.doesangueproject;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import org.w3c.dom.Text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;


public class telaRegistro extends AppCompatActivity {

    private Button btnRegistrar;
    private EditText nome, email, senha;
    private final int PERMISSAO_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);

        // Pedindo permissão para LER
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        //Pedindo permissão para ESCREVER
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        // Criado o botão para trocar para tela de login
        TextView textoLogar = (TextView) findViewById(R.id.textLogin);
        // Conectando a função ao botão
        textoLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent numbersIntent = new Intent(telaRegistro.this, telaLogin.class);
                startActivity(numbersIntent);
            }
        });

        // Inicializando as variaveis
        btnRegistrar = findViewById(R.id.btnRegistrar);
        nome = findViewById(R.id.textNameReg);
        email = findViewById(R.id.textEmailReg);
        senha = findViewById(R.id.textSenhaReg);

        // Criando a função para o botão registrar salvar os dados no arquivo
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buscando as informações dos campos
                String name = nome.getText().toString();
                String mail = email.getText().toString();
                String pass = senha.getText().toString();

                // Checando se alguma das entradas está vazia
                if (name.isEmpty() || mail.isEmpty() ||pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                    return;
                }

                // Criando e inicializando o ContextWrapper
                ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
                // Definindo o diretorio
                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                // Criando um TXT para o nome
                File nameFile = new File(directory, "Nome" + ".txt");

                // Criando um TXT para o email
                File emailFile = new File(directory, "Email" + ".txt");

                // Criando um TXT para o senha
                File passFile = new File(directory, "Senha" + ".txt");

                // Escrevendo os dados no arquivo
                FileOutputStream fosN = null;
                FileOutputStream fosE = null;
                FileOutputStream fosP = null;
                try {
                    fosN = new FileOutputStream(nameFile);
                    OutputStreamWriter oswN = new OutputStreamWriter(fosN);
                    oswN.write(name);
                    oswN.flush();
                    oswN.close();
                    fosN.close();

                    fosE = new FileOutputStream(emailFile);
                    OutputStreamWriter oswE = new OutputStreamWriter(fosE);
                    oswE.write(mail);
                    oswE.flush();
                    oswE.close();
                    fosE.close();

                    fosP = new FileOutputStream(passFile);
                    OutputStreamWriter oswP = new OutputStreamWriter(fosP);
                    oswP.write(pass);
                    oswP.flush();
                    oswP.close();
                    fosP.close();
                    Toast.makeText(contextWrapper, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}