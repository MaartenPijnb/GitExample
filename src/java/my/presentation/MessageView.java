/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author maart
 */
@Named(value = "MessageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }
    //create a new field
    private Message message;
    
    //call message to retreave its value
    public Message getMassage(){
        return message;
        
    }
    //return the total number of messages
    public int getNumberOfMessages(){
        return messageFacade.findAll().size();
    }
    
    // save message and return the string theend
    public String postMessage(){
        this.messageFacade.create(message);
        return "theend";
    }
}
