package br.edu.fecap.doesangueproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class telaLogin extends AppCompatActivity {

    private Button btnEntrar;
    private EditText emailLog, senhaLog;
    private String dadosEmail, dadosSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        // Criado o botão para trocar para tela de registro
        TextView textoRegistrar = findViewById(R.id.textRegistrar);
        // Conectando a função ao botão
        textoRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent numbersIntent = new Intent(telaLogin.this, telaRegistro.class);
                startActivity(numbersIntent);
            }
        });

        emailLog = findViewById(R.id.textEmailLog);
        senhaLog = findViewById(R.id.textSenhaLog);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Definindo o diretorio e o nome do arquivo do Email
                File directoryE = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File emailFile = new File(directoryE, "Email.txt");
                // Criando um StringBuilder para Email
                StringBuilder dadosE = new StringBuilder();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(emailFile));
                    String linhaE;
                    // Buscando o texto do arquivo
                    while ((linhaE = br.readLine()) != null) {
                        dadosE.append(linhaE);
                    }
                    br.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Fail to read the file..", Toast.LENGTH_LONG).show();
                }
                // Salvando os dados do email para uma string
                dadosEmail = dadosE.toString();

                // Definindo o diretorio e o nome do arquivo da senha
                File directoryP = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File senhaFile = new File(directoryP, "Senha.txt");
                // Criando um StringBuilder para senha
                StringBuilder dadosP = new StringBuilder();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(senhaFile));
                    String linhaP;
                    // Buscando o texto do arquivo
                    while ((linhaP = br.readLine()) != null) {
                        dadosP.append(linhaP);
                    }
                    br.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Fail to read the file..", Toast.LENGTH_LONG).show();
                }
                // Salvando os dados da senha para uma string
                dadosSenha = dadosP.toString();

                // Comparando dados digitados com o arquivo
                if (emailLog.getText().toString().equals(dadosEmail) && senhaLog.getText().toString().equals(dadosSenha)) {
                    Toast.makeText(getApplicationContext(), "DADOS CORRETOS", Toast.LENGTH_LONG).show();

                    // Iniciando a MainActivity
                    Intent intent = new Intent(telaLogin.this, MainActivity.class);
                    Intent intentRE = getIntent();
                    Intent intentPR = new Intent(telaLogin.this, PerfilFragment.class);
                    intentPR.putExtra("nome", intentRE.getStringExtra("nome"));
                    intentPR.putExtra("email", intentRE.getStringExtra("email"));
                    startActivity(intent);
                    finish(); // Finalizando telaLogin para que o usuário não possa voltar para ela com o botão de voltar
                } else {
                    Toast.makeText(getApplicationContext(), "DADOS ERRADOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}