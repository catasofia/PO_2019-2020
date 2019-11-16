package m19.core;

import java.util.List;
import java.io.Serializable;


public class User implements Serializable{
    private int _iDUser;
    private String _name;
    private String _email;
    private Situation _situation;
    private List<Notification> _notifications;
    //private List<Request> _requests;

    private static final long serialVersionUID = 201901101348L;

    public User(int iDUser, String name, String email){
        _iDUser=iDUser;
        _name = name;
        _email = email;
        _situation = new Situation();
        //_notifications = new List<>();
    }

    protected int getUserID(){
        return _iDUser;
    }

    protected String getName(){
        return _name;
    }
    
    protected String getEmail(){
        return _email;
    }

    protected Situation getSituation(){
        return _situation;
    }

    protected String showUser(){
        String aux = _iDUser + " - " + _name + " - " + _email + " - ";
        aux += _situation.showSituation();
        return aux;

    }

    protected void showNotification(int iDNotificacao){
        System.out.println(_notifications.get(iDNotificacao).getMessage());
    }
    
    protected void showNotifications(){
        for(Notification i: _notifications)
            showNotification(i.getID());
    }

    protected void verifyUser(){
        //To Do in final project submition
        //Verifica se Utente tem obras que ja devia de ter entregue, altera pontuaçao, etc..
    }

    protected void addNotification(String tipo, String mensagem){
        _notifications.add(new Notification(tipo, mensagem));
    }
}