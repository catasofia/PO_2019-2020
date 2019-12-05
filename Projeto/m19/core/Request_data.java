package m19.core;

import java.io.Serializable;

public class Request_data implements Serializable {
    private int _user;
    private int _work;

    public Request_data(int user, int work){
        _user = user;
        _work = work;
    }

    int getUser() { return _user; }
    int getWork() { return _work; }

}