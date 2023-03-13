package sp.senai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // listView
    private ListView lvEstudantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencia da lista a partir do resourse id
        lvEstudantes = findViewById(R.id.lvEstudantes);

        // criacao de lista de estudantes
        String[] nomes = {"Luiz", "Paulo", "Gustavo", "Jorge", "João", "Maria"};
        List<String> estudantes = new ArrayList<>(Arrays.asList(nomes));

        // contexto, recurso para apresentar lista, fonte de dados
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estudantes);

        // indicar os dados por tras do ListView
        lvEstudantes.setAdapter(adapter);

        lvEstudantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // dialogo de alerta
                AlertDialog alerta;

                // estudante selecionado da lista
                String estudanteSelecionado = (String) parent.getAdapter().getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // titulo
                builder.setTitle("Atenção!");
                // mensagem
                builder.setMessage("Você quer deletar o registro?");

                // botao do sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        estudantes.remove(estudanteSelecionado);
                        adapter.notifyDataSetChanged();
                    }
                });

                //botao do nao
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Estudante " + estudanteSelecionado +
                                " não foi deletado.", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });
    }
}