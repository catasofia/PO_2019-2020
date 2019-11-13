package m19.core;

import java.io.IOException;
import m19.core.exception.*;

import java.util.Collections;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public abstract class Obra{
  private int _idObra;
  private int _exemplares;
  private int _exemplaresDisponiveis;
  private String _titulo;
  private int _preco;
  private String _categoria;

  public Obra(int idObra,int exemplares, String titulo, int preco, String categoria){
    _idObra=idObra;
    _exemplares=exemplares;
    _exemplaresDisponiveis=exemplares;
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

  protected int obterID(){
    return _idObra;
  }

  protected int obterExemlaresDisponiveis(){
    return _exemplaresDisponiveis;
  }

  protected String obterCategoria(){
    if (_categoria.equals("FICTION")) return "Ficção";
    return "";
  }
  
  protected boolean existemExemplares(){
    return (_exemplares != 0);
  }
  
  protected void alteraExemplares(int nExemplares){
    _exemplares = nExemplares;
  }

  abstract protected String mostrarObra();

  protected boolean verificaDisponibilidade(){return true;}

  protected void pesquisaTermo(String termo){};

}