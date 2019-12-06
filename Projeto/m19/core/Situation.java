package m19.core;

import java.io.Serializable;

public class Situation implements Serializable{
    private boolean _situation;
    private int _fine;
    private ClassificationInterface _classification;

    private static final long serialVersionUID = 201901101348L;

    public Situation(){
        _situation = true;
        _classification = new Normal();
        _fine = 0;
    }

    protected boolean getSituation(){
        return _situation;
    }

    protected ClassificationInterface getClassification(){
        return _classification;
    }

    protected int getFine(){
        return _fine;
    }

    protected void changeSituation(){
        if (_situation) _situation = false;
        else _situation = true;
    }
    
    protected void changeFine(int valor){
        _fine = valor;
    }
    
    protected String showSituation(){
        String aux=_classification + " - ";
        if (_situation) aux += "ACTIVO\n";
        else aux += "SUSPENSO - EUR - " + _fine + "\n";
        return aux;
    }
}
