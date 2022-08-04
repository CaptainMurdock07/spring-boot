package com.exemple.nation;

import org.springframework.stereotype.Component;

@Component("en")
public class English implements IEuropean {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
	}

}
