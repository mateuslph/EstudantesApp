package sp.senai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}