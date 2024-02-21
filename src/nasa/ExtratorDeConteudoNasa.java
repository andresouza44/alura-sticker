package nasa;

import com.google.gson.Gson;
import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;

import java.util.Arrays;
import java.util.List;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

  Gson gson = new Gson();
  public List<Conteudo> extrairConteudos(String json) {
      ConteudoNasa[] conteudoNasa = gson.fromJson(json, ConteudoNasa[].class);

      return Arrays.stream(conteudoNasa).
            map(atributos -> new Conteudo(atributos.title(), atributos.url()))
            .toList();
    }

    @Override
    public void imprimirAtributos (String json){

        ConteudoNasa[] conteudoNasa = gson.fromJson(json, ConteudoNasa[].class);
        for (ConteudoNasa nasa : conteudoNasa) {
            System.out.println(nasa.title() + "\n" + nasa.url());

        }
    }
  }

