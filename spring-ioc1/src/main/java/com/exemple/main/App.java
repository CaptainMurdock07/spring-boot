package com.exemple.main;

import com.exemple.config.AppConfig;
import com.exemple.models.Personne;
import com.exemple.nation.IEuropean;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
		Personne p = context.getBean("personne", Personne.class);
		   System.out.println(p);
		   IEuropean e = (IEuropean) context.getBean("fr");
		   e.sayHello();
	} catch (BeansException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
}
