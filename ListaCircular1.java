public class ListaCircular1 {
  private No cabeca;

  public int contarElementos() {
    if (cabeca == null) {
      return 0;
    }

    No atual = cabeca;
    int contador = 1;

    while (atual.proximo != cabeca) {
      contador++;
      atual = atual.proximo;
    }

    return contador;
  }

  public void inserirNaEsquerda(int dado) {
    No novoNo = new No();
    novoNo.dado = dado;

    if (cabeca == null) {
      cabeca = novoNo;
      novoNo.proximo = cabeca;
    } else {
      novoNo.proximo = cabeca;
      No atual = cabeca;
      while (atual.proximo != cabeca) {
        atual = atual.proximo;
      }
      atual.proximo = novoNo;
      cabeca = novoNo;
    }
  }

  public void concatenar(ListaCircular1 lista2) {
    if (cabeca == null) {
      cabeca = lista2.cabeca;
    } else if (lista2.cabeca != null) {
      No ultimoLista1 = cabeca;
      while (ultimoLista1.proximo != cabeca) {
        ultimoLista1 = ultimoLista1.proximo;
      }
      ultimoLista1.proximo = lista2.cabeca;
      No ultimoLista2 = lista2.cabeca;
      while (ultimoLista2.proximo != lista2.cabeca) {
        ultimoLista2 = ultimoLista2.proximo;
      }
      ultimoLista2.proximo = cabeca;
    }
  }

  public void intercalar(ListaCircular1 lista2) {
    if (cabeca == null) {
      cabeca = lista2.cabeca;
    } else if (lista2.cabeca != null) {
      No atualLista1 = cabeca;
      No atualLista2 = lista2.cabeca;
      No cabecaInter = new No();
      No atualInter = cabecaInter;

      while (atualLista1.proximo != cabeca && atualLista2.proximo != lista2.cabeca) {
        if (atualLista1.dado <= atualLista2.dado) {
          atualInter.proximo = atualLista1;
          atualLista1 = atualLista1.proximo;
        } else {
          atualInter.proximo = atualLista2;
          atualLista2 = atualLista2.proximo;
        }
        atualInter = atualInter.proximo;
      }

      while (atualLista1.proximo != cabeca) {
        atualInter.proximo = atualLista1;
        atualLista1 = atualLista1.proximo;
        atualInter = atualInter.proximo;
      }

      while (atualLista2.proximo != lista2.cabeca) {
        atualInter.proximo = atualLista2;
        atualLista2 = atualLista2.proximo;
        atualInter = atualInter.proximo;
      }

      atualInter.proximo = cabeca;
      cabeca = cabecaInter.proximo;
    }
  }

  public ListaCircular1 copiar() {
    ListaCircular1 listaCopia = new ListaCircular1();
    if (cabeca == null) {
      return listaCopia;
    }

    No atual = cabeca;
    do {
      listaCopia.inserirNaEsquerda(atual.dado);
      atual = atual.proximo;
    } while (atual != cabeca);

    return listaCopia;
  }

}