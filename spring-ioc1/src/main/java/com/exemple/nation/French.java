package com.exemple.nation;

import org.springframework.stereotype.Component;

@Component("fr")
public class French implements IEuropean {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println();
	}

	
}
