package com.mipresupuesto.personalbudget.controller.response;

import java.util.ArrayList;
import java.util.List;

import com.mipresupuesto.personalbudget.controller.response.dto.Message;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;

public class Response<D> {
	private List<D> data;
	private List<Message> messages;
	
	
	
	
	public Response() {
		super();
	}
	
	public void addMessage(final Message message ) {
		if(!UtilObject.getUtilObject().isNull(message)) {
			getMessage().add(message);
		}
		
	}
	public void addData(final D data ) {
		if(!UtilObject.getUtilObject().isNull(data)) {
			getData().add(data);
		}
		
	}
	
	public List<Message> getMessage(){
		if(UtilObject.getUtilObject().isNull(messages)) {
			this.messages = new ArrayList<>();
		}
		return messages;
	}
	public final void setMessages(List<Message> messages) {
		
		this.messages =UtilObject.getUtilObject().getDefault(messages, new ArrayList<>());
		
	}
	public List<D> getData(){
		if(UtilObject.getUtilObject().isNull(data)) {
			this.data = new ArrayList<>();
		}
		return data;
	}
	public final void setData(List<D> data) {
		this.data = UtilObject.getUtilObject().getDefault(data, new ArrayList<>());
	}

}
