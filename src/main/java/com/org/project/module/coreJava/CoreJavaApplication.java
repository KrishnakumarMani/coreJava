package com.org.project.module.coreJava;

import com.org.project.module.coreJava.Impl.AppleHeavyPredicate;
import com.org.project.module.coreJava.Impl.AppleRedPredicate;
import com.org.project.module.coreJava.Service.AppleService;
import com.org.project.module.coreJava.model.Apple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CoreJavaApplication {




	public static void main(String[] args) {
		SpringApplication.run(CoreJavaApplication.class, args);
		List<Apple> appleInventory=new ArrayList<>();
		appleInventory.add(new Apple(100,"RED"));
		appleInventory.add(new Apple(150,"GREEN"));
		appleInventory.add(new Apple(200,"RED"));
		appleInventory.add(new Apple(300,"GREEN"));
		appleInventory.add(new Apple(500,"RED"));
		appleInventory.add(new Apple(0,"GREEN"));
		CoreJavaApplication corejava=new CoreJavaApplication();
		corejava.getRedApples(appleInventory);
	}

	public  void getRedApples(List<Apple> appleInventory){

		AppleService appleService=new AppleService();
		appleService.getRedApples(appleInventory);
		//Strategy pattern
//		Based on the predicate class the result is obtained
		AppleRedPredicate appleRedPredicate=new AppleRedPredicate();
		appleService.filterApples(appleInventory, appleRedPredicate);
		AppleHeavyPredicate appleHeavyPredicate=new AppleHeavyPredicate();
		appleService.filterApples(appleInventory, appleHeavyPredicate);

	}

	public static void loadAppleInventory(){

	}

}
