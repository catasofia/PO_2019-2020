package m19.core;

import java.io.IOException;
import m19.core.exception.*;

import java.util.Collections;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Utente{
    private int _iDUtente;
    private String _nome;
    private String _email;
    private Pontuacao _pontuacao;
    private List<Notificacao> _notificacoes;
    private List<Requisicoes> _requisicoes;

    public Utente(int iDUtente, String nome, String email){
        _iDUtente=iDUtente;
        _nome = nome;
        _email = email;
        _pontuacao = new Pontuacao();
        //_notificacoes = new List<Notificacao>(); DA ERRO

    }

    protected int obterIDUtente(){
        return _iDUtente;
    }

    protected String obterNome(){
        return _nome;
    }
    
    protected String obterEmail(){
        return _email;
    }

    protected Pontuacao obterPontuacao(){
        return _pontuacao;
    }

    protected void mostrarUtente(){
        System.out.println(_iDUtente + " - " + _nome + " - " + _email); //FALTAM COISAS
    }

    protected void mostrarNotificacao(int iDNotificacao){
        System.out.println(_notificacoes.get(iDNotificacao).obterMensagem());
    }
    /*
    protected void mostrarNotificacoes(){
        for(int i=0;i<10;i++)
            mostrarNotificacao(i);
    }*/
}