public class ListaCircularDuplamenteEncadeada {
  private NoDuplo cabeca;

  public ListaCircularDuplamenteEncadeada() {
    cabeca = new NoDuplo();
    cabeca.proximo = cabeca;
    cabeca.anterior = cabeca;
  }

  public int contarElementos() {
    if (cabeca == null) {
      return 0;
    }

    NoDuplo atual = cabeca;
    int contador = 1;

    while (atual.proximo != cabeca) {
      contador++;
      atual = atual.proximo;
    }

    return contador;
  }

  public void inserirNaEsquerda(int dado) {
    NoDuplo novoNo = new NoDuplo();
    novoNo.dado = dado;

    if (cabeca == null) {
      cabeca = novoNo;
      cabeca.proximo = cabeca;
      cabeca.anterior = cabeca;
    } else {
      novoNo.proximo = cabeca;
      novoNo.anterior = cabeca.anterior;
      cabeca.anterior.proximo = novoNo;
      cabeca.anterior = novoNo;
      cabeca = novoNo;
    }
  }

  public void concatenar(ListaCircularDuplamenteEncadeada lista2) {
    if (cabeca == null) {
      cabeca = lista2.cabeca;
    } else if (lista2.cabeca != null) {
      NoDuplo ultimoLista1 = cabeca.anterior;
      ultimoLista1.proximo = lista2.cabeca;
      lista2.cabeca.anterior = ultimoLista1;
      cabeca.anterior = lista2.cabeca.anterior;
      lista2.cabeca.anterior.proximo = cabeca;
    }
  }

  public void intercalar(ListaCircularDuplamenteEncadeada lista2) {
    if (cabeca == null) {
      cabeca = lista2.cabeca;
    } else if (lista2.cabeca != null) {
      NoDuplo atualLista1 = cabeca;
      NoDuplo atualLista2 = lista2.cabeca;
      NoDuplo cabecaInter = new NoDuplo();
      NoDuplo atualInter = cabecaInter;

      while (atualLista1 != cabeca && atualLista2 != lista2.cabeca) {
        if (atualLista1.dado <= atualLista2.dado) {
          atualInter.proximo = atualLista1;
          atualLista1.anterior = atualInter;
          atualLista1 = atualLista1.proximo;
        } else {
          atualInter.proximo = atualLista2;
          atualLista2.anterior = atualInter;
          atualLista2 = atualLista2.proximo;
        }
        atualInter = atualInter.proximo;
      }

      while (atualLista1 != cabeca) {
        atualInter.proximo = atualLista1;
        atualLista1.anterior = atualInter;
        atualLista1 = atualLista1.proximo;
        atualInter = atualInter.proximo;
      }

      while (atualLista2 != lista2.cabeca) {
        atualInter.proximo = atualLista2;
        atualLista2.anterior = atualInter;
        atualLista2 = atualLista2.proximo;
        atualInter = atualInter.proximo;
      }

      atualInter.proximo = cabeca;
      cabeca.anterior = atualInter;
      cabeca = cabecaInter.proximo;
      cabeca.anterior = atualInter;
    }
  }

  public ListaCircularDuplamenteEncadeada copiar() {
    ListaCircularDuplamenteEncadeada listaCopia = new ListaCircularDuplamenteEncadeada();
    if (cabeca == null) {
      return listaCopia;
    }

    NoDuplo atual = cabeca;
    do {
      listaCopia.inserirNaEsquerda(atual.dado);
      atual = atual.proximo;
    } while (atual != cabeca);

    return listaCopia;
  }

}