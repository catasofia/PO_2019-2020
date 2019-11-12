package m19.core;

import java.io.IOException;
import m19.core.exception.*;

import java.util.Collections;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Obra{
  private int _exemplares;
  private String _titulo;
  private int _preco;
  private Categoria _categoria;

  public Obra(int exemplares, String titulo, int preco, Categoria categoria){
    _exemplares=exemplares;
    _titulo=titulo;
    _preco=preco;
    _categoria=categoria;
  }

  protected String obterTitulo(){
    return _titulo;
  }

  protected int obterExemplares(){
    return _exemplares;
  }

  protected int obterPreco(){
    return _preco;
  }

  protected boolean existemExemplares(){
    return (_exemplares != 0);
  }
  
  protected void alteraExemplares(int nExemplares){
    _exemplares = nExemplares;
  }

  protected boolean verificaDisponibilidade(){return true;}

  protected void pesquisaTermo(String termo){};

}