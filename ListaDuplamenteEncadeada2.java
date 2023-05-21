public class ListaDuplamenteEncadeada2 {
  private NoDuplo cabeca;

  public ListaDuplamenteEncadeada2() {
    cabeca = new NoDuplo();
    cabeca.proximo = cabeca;
    cabeca.anterior = cabeca;
  }

  public void inserirNoInicio(int dado) {
    NoDuplo novoNo = new NoDuplo();
    novoNo.dado = dado;
    novoNo.proximo = cabeca.proximo;
    novoNo.anterior = cabeca;
    cabeca.proximo.anterior = novoNo;
    cabeca.proximo = novoNo;
  }

  public void inserirNoFim(int dado) {
    NoDuplo novoNo = new NoDuplo();
    novoNo.dado = dado;
    novoNo.proximo = cabeca;
    novoNo.anterior = cabeca.anterior;
    cabeca.anterior.proximo = novoNo;
    cabeca.anterior = novoNo;
  }

  public void remover(int dado) {
    NoDuplo atual = cabeca.proximo;
    while (atual != cabeca) {
      if (atual.dado == dado) {
        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;
        break;
      }
      atual = atual.proximo;
    }
  }

  public boolean buscar(int dado) {
    NoDuplo atual = cabeca.proximo;
    while (atual != cabeca) {
      if (atual.dado == dado) {
        return true;
      }
      atual = atual.proximo;
    }
    return false;
  }
}