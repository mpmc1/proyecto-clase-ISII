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
		if(message !=null) {
			getMessage().add(message);
		}
		
	}
	public void addData(final D data ) {
		if(data !=null) {
			getData().add(data);
		}
		
	}
	
	public List<Message> getMessage(){
		if(messages==null) {
			this.messages = new ArrayList<>();
		}
		return messages;
	}
	public final void setMessages(List<Message> messages) {
		if(messages==null) {
			this.messages = new ArrayList<>();
		}else{
			this.messages=messages;
		}
	}
	public List<D> getData(){
		if(data==null) {
			this.data = new ArrayList<>();
		}
		return data;
	}
	public final void setData(List<D> data) {
		if(data==null) {
			this.data = new ArrayList<>();
		}else{
			this.data=data;
		}
	}

}
