package nasa;

import com.google.gson.Gson;
import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtratorConteudoNasa implements ExtratorDeConteudo {

  public List<Conteudo> extrairConteudos(String json) {

        //List<Conteudo> conteudos = new ArrayList<>();
        Gson gson = new Gson();
        ConteudoNasa[] conteudoNasa = gson.fromJson(json, ConteudoNasa[].class);

        return Arrays.stream(conteudoNasa).
                map(atrubutos -> new Conteudo(atrubutos.getTitle(), atrubutos.getUrl()))
                .toList();
    }
}
