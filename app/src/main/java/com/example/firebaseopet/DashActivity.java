package com.example.firebaseopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView textWelcome, textResultado;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        mAuth = FirebaseAuth.getInstance();
        textWelcome = findViewById(R.id.textWelcome);
        textResultado = findViewById(R.id.textResultado);
        db = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        textWelcome.setText("Bem vindo "+user.getEmail());
    }

    public void sair(View view){
        mAuth.signOut();
        Intent inicio = new Intent(DashActivity.this, MainActivity.class);
        startActivity(inicio);
        finish();
    }

    public void registrardadosusuario(View view) {
        Intent cadOneActivity= new Intent(DashActivity.this, CadOneActivity.class);
        startActivity(cadOneActivity);
    }

    public void registrardadosvenda(View view) {
        Intent cadTwoActivity= new Intent(DashActivity.this, CadTwoActivity.class);
        startActivity(cadTwoActivity);
    }

    public void gerarDadosFirebase(View view) {
        List<Pessoa> pessoas = PopulateUtil.loadPessoas();
        for (Pessoa p : pessoas) {
            db.collection("exemplo").add(p);
        }
    }

    public void carregarDados(View view) {
        CollectionReference pessoas = db.collection("exemplo");

        pessoas.whereEqualTo("ativo",true).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    String resultado="";
                    List<Pessoa> listPessoas = new ArrayList<>();
                    for(QueryDocumentSnapshot document : task.getResult()){
                        resultado+="ID: "+ document.getId() + '\n'+ document.getData().toString()+'\n';
                        listPessoas.add(document.toObject(Pessoa.class));
                    }
                    resultado="";
                    for(Pessoa p : listPessoas){
                        resultado += p.toString()+'\n';
                    }
                    textResultado.setText(resultado);
                }
            }
        });
    }

    public void uploadArquivo(View view) {
        Intent novaJanela = new Intent(DashActivity.this,ImageActivity.class);
        startActivity(novaJanela);
    }
}
