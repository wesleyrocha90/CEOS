package br.com.ceos.util;

import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/**
 * Esta classe contém métodos estáticos que permitem a criação e inicialização
 * de objetos que extendem de Map de uma forma mais curta e elegante.
 *
 * <p>
 * A documentação contida nos métodos desta classe contém uma breve descrição de
 * <i>implementações</i>.
 *
 * @author Wesley
 * @since 13 de Março de 2015
 */
public class Maps {

  /**
   * Retorna uma intância de Map composta pelos valores passados.
   *
   * <p>
   * Este método providencia uma forma mais sucinta de criar um objeto do tipo
   * Map, e inicializá-lo com valores.
   * <pre><code>
   *  Map<Long, String> map = Maps.<Long, String>asMap(1, "Valor1", 2, "Valor2", 3, "Valor3");
   * </code></pre> Esta mesma linha de código deveria ser escrita da seguinte
   * forma, em Java puro:
   * <pre><code>
   *  Map<Long, String> map = new HashMap<>();
   *  map.put(1, "Valor1");
   *  map.put(2, "Valor2");
   *  map.put(3, "Valor3");
   * </code></pre>
   * <p>
   * Mas repare, como o método se baseia em Generics pra criar a intância de
   * Map, é necessário especificar os tipos das classes na declaração do método.
   *
   * @param <K> A classe dos objetos chave do map
   * @param <V> A classe dos objetos valor do map
   * @param keyvals A lista de valores que representam de dois em dois os
   * conjuntos de chave-valor do map. Portanto a ordem de declaração dos
   * parâmetros é importante e deve ser respeitada, a ordem deve seguir o padrão
   * (chave1, valor1, chave2, valor2, ... chaveN, valorN).
   * @return Uma instância de HashMap (afinal Map não pode ser instanciado)
   * preenchida com todos os valores passados, respeitando a ordem chave-valor.
   */
  public static <K, V> Map<K, V> asMap(@NonNull Object... keyvals) {
    return fillMap(new HashMap<>(keyvals.length), keyvals);
  }

  /**
   * Retorna a instância do Map passado como parâmetro e preenchido com os
   * valores também passados.
   * <p>
   * Este método provê uma forma mais limpa de instanciar e inicializar um
   * objeto que extende Map e inserir valores nele. Como esse método já recebe a
   * instância da classe Map que será usada, ele dispensa a necessidade de
   * especificar os tipos da classe que compõem o Map no corpo do método. E, no
   * Java 8, com o aprimoramento do operador diamond, também é desnessário essa
   * especificação no momento da inicialização da classe que é passada no
   * parâmetro.
   * <p>
   * Segue um exemplo de uso:
   * <pre><code>
   *  ConcurrentHashMap<String, String> map = Maps.asMap(new ConcurrentHashMap<>(), "chave1", "valor1", "chave2", "valor2");
   * </code></pre>
   *
   * @param <K> A classe dos objetos chave do map
   * @param <V> A classe dos objetos valor do map
   * @param <T> A classe que extende Map que será usada
   * @param map A intância da classe Map que será usada na inicialização dos
   * valores e no retorno
   * @param keyvals A lista de valores que representam de dois em dois os
   * conjuntos de chave-valor do map. Portanto a ordem de declaração dos
   * parâmetros é importante e deve ser respeitada, a ordem deve seguir o padrão
   * (chave1, valor1, chave2, valor2, ... chaveN, valorN).
   * @return A intância da classe que extende Map passada como parâmetro
   * preenchida com os valores passados, respeitando a ordem chave-valor.
   */
  public static <K, V, T extends Map<K, V>> T asMap(@NonNull T map, @NonNull Object... keyvals) {
    return fillMap(map, keyvals);
  }

  /*
   Método usado para inserir os valores passados no Map
   */
  private static <K, V, T extends Map<K, V>> T fillMap(T map, Object... keyvals) {
    if (keyvals.length > 0) { // verifica se keyvals tem elementos
      if (keyvals.length % 2 == 0) { // verifica se keyvals tem número par de elementos
        for (int i = 0; i < keyvals.length; i += 2) { // percorre os elementos de 2 em 2 ...
          map.put((K) keyvals[i], (V) keyvals[i + 1]); // ... e adciona como chave e valor no map
          // aqui lançar erro de conversão
        }
        // aqui lançar erro de número de parâmetros incorretos
      }
      // não sei se será possível
    }
    return map;
  }
}
