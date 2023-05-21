public class ListaDuplamenteEncadeada1 {
  public NoDuplo primeiro;
  public NoDuplo ultimo;
  private NoDuplo cabeca;

  public void concatenar(ListaDuplamenteEncadeada1 lista2) {
    if (this.primeiro == null) {
      this.primeiro = lista2.primeiro;
    } else if (lista2.primeiro != null) {
      this.ultimo.proximo = lista2.primeiro;
      lista2.primeiro.anterior = this.ultimo;
    }
    if (lista2.ultimo != null) {
      this.ultimo = lista2.ultimo;
    }
  }

  public void separar() {
    if (this.primeiro == null || this.primeiro == this.ultimo) {
      return;
    }
    NoDuplo slow = this.primeiro;
    NoDuplo fast = this.primeiro;

    while (fast != null && fast.proximo != null) {
      fast = fast.proximo.proximo;
      slow = slow.proximo;
    }

    ListaDuplamenteEncadeada1 lista2 = new ListaDuplamenteEncadeada1();
    lista2.primeiro = slow.proximo;
    lista2.ultimo = this.ultimo;
    slow.proximo = null;
    this.ultimo = slow;

    System.out.println("Lista 1:");
    this.exibir();
    System.out.println("Lista 2:");
    lista2.exibir();
  }

  public void intercalar(ListaDuplamenteEncadeada1 lista2) {
    if (this.primeiro == null) {
      this.primeiro = lista2.primeiro;
      this.ultimo = lista2.ultimo;
    } else if (lista2.primeiro != null) {
      NoDuplo p1 = this.primeiro;
      NoDuplo p2 = lista2.primeiro;
      ListaDuplamenteEncadeada1 listaInter = new ListaDuplamenteEncadeada1();

      while (p1 != null && p2 != null) {
        if (p1.dado <= p2.dado) {
          listaInter.inserirNoFim(p1.dado);
          p1 = p1.proximo;
        } else {
          listaInter.inserirNoFim(p2.dado);
          p2 = p2.proximo;
        }
      }

      while (p1 != null) {
        listaInter.inserirNoFim(p1.dado);
        p1 = p1.proximo;
      }

      while (p2 != null) {
        listaInter.inserirNoFim(p2.dado);
        p2 = p2.proximo;
      }

      this.primeiro = listaInter.primeiro;
      this.ultimo = listaInter.ultimo;
    }
  }

  public void exibir() {
    NoDuplo temp = this.primeiro;
    while (temp != null) {
      System.out.print(temp.dado + " ");
      temp = temp.proximo;
    }
    System.out.println();
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