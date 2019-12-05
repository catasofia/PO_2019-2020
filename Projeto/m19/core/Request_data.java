package m19.core;

import java.io.Serializable;

public class Request_data implements Serializable {
    private static final long serialVersionUID = 201901101348L;
    private int _user;
    private int _work;

    public Request_data(int user, int work){
        _user = user;
        _work = work;
    }

    int getUser() { return _user; }
    int getWork() { return _work; }

    public boolean equals(Object obj){
        Request_data geek = (Request_data) obj;
        return geek._user == this._user && geek._work == this._work;
    }

    
}