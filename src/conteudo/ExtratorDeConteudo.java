package conteudo;

import conteudo.Conteudo;

import java.util.List;

public interface ExtratorDeConteudo {
    List<Conteudo> extrairConteudos(String json);
    void imprimirAtributos (String json);
}
