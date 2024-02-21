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
            map(atrubutos -> new Conteudo(atrubutos.getTitle(), atrubutos.getUrl()))
            .toList();
    }

    @Override
    public void imprimirAtributos (String json){

        ConteudoNasa[] conteudoNasa = gson.fromJson(json, ConteudoNasa[].class);
        for (ConteudoNasa nasa : conteudoNasa) {
            System.out.println(nasa.getTitle() + "\n" + nasa.getUrl());

        }
    }
  }

