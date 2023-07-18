package com.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
     
	String recourceName;
	
	String fieldNaame;
	long fieldVaalue;
	public ResourceNotFoundException(String recourceName, String fieldNaame, long fieldVaalue) {
		super(String.format("%s not found with %s:%s",recourceName,fieldNaame,fieldVaalue ));
		this.recourceName = recourceName;
		this.fieldNaame = fieldNaame;
		this.fieldVaalue = fieldVaalue;
	}
}
