public class ListaCircular2 {
  private No cabeca;

  public ListaCircular2() {
    cabeca = new No();
    cabeca.proximo = cabeca;
  }

  public int contarElementos() {
    if (cabeca == null || cabeca.proximo == cabeca) {
      return 0;
    }

    No atual = cabeca.proximo;
    int contador = 1;

    while (atual != cabeca) {
      contador++;
      atual = atual.proximo;
    }

    return contador;
  }

  public void inserirNaEsquerda(int dado) {
    No novoNo = new No();
    novoNo.dado = dado;
    novoNo.proximo = cabeca.proximo;
    cabeca.proximo = novoNo;
  }

  public void concatenar(ListaCircular2 lista2) {
    if (cabeca.proximo == cabeca) {
      cabeca.proximo = lista2.cabeca.proximo;
    } else if (lista2.cabeca.proximo != lista2.cabeca) {
      No ultimoLista1 = cabeca.proximo;
      while (ultimoLista1.proximo != cabeca) {
        ultimoLista1 = ultimoLista1.proximo;
      }
      ultimoLista1.proximo = lista2.cabeca.proximo;
      lista2.cabeca.proximo = cabeca;
    }
  }

  public void intercalar(ListaCircular2 lista2) {
    if (cabeca.proximo == cabeca) {
      cabeca.proximo = lista2.cabeca.proximo;
    } else if (lista2.cabeca.proximo != lista2.cabeca) {
      No atualLista1 = cabeca.proximo;
      No atualLista2 = lista2.cabeca.proximo;
      No cabecaInter = new No();
      No atualInter = cabecaInter;

      while (atualLista1 != cabeca && atualLista2 != lista2.cabeca) {
        if (atualLista1.dado <= atualLista2.dado) {
          atualInter.proximo = atualLista1;
          atualLista1 = atualLista1.proximo;
        } else {
          atualInter.proximo = atualLista2;
          atualLista2 = atualLista2.proximo;
        }
        atualInter = atualInter.proximo;
      }

      while (atualLista1 != cabeca) {
        atualInter.proximo = atualLista1;
        atualLista1 = atualLista1.proximo;
        atualInter = atualInter.proximo;
      }

      while (atualLista2 != lista2.cabeca) {
        atualInter.proximo = atualLista2;
        atualLista2 = atualLista2.proximo;
        atualInter = atualInter.proximo;
      }

      atualInter.proximo = cabeca;
      cabeca.proximo = cabecaInter.proximo;
    }
  }

  public ListaCircular2 copiar() {
    ListaCircular2 listaCopia = new ListaCircular2();
    if (cabeca.proximo == cabeca) {
      return listaCopia;
    }

    No atual = cabeca.proximo;
    No atualCopia = new No();
    listaCopia.cabeca.proximo = atualCopia;

    while (atual != cabeca) {
      atualCopia.proximo = new No();
      atualCopia.proximo.dado = atual.dado;
      atualCopia = atualCopia.proximo;
      atual = atual.proximo;
    }

    atualCopia.proximo = listaCopia.cabeca;

    return listaCopia;
  }

}
