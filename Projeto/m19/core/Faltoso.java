package m19.core;

import java.io.Serializable;

public class Faltoso implements Serializable, ClassificationInterface{
    private static final long serialVersionUID = 201901101348L;
    
    public int getDeadline(int copies){
        return 2;
    }
}