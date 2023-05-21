package com.org.project.module.coreJava.Service;

import com.org.project.module.coreJava.Impl.AppleHeavyPredicate;
import com.org.project.module.coreJava.Impl.AppleRedPredicate;
import com.org.project.module.coreJava.appleInterface.AppleInterface;
import com.org.project.module.coreJava.model.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class AppleService {
    @Autowired
    AppleHeavyPredicate appleHeavyPredicate;


    public  List<Apple> getHeavyApples(List<Apple> appleList){
        List<Apple> heavyApples=new ArrayList<Apple>();
        if(!appleList.isEmpty()){
            ListIterator<Apple> appleListIterator= appleList.listIterator();
            while(appleListIterator.hasNext()){
                Apple apple=appleListIterator.next();
                if(appleHeavyPredicate.testApple(apple)){
                    heavyApples.add(apple);
                }
            }
        }
        return heavyApples;
    }

    public  List<Apple> getRedApples(List<Apple> appleList){
        System.out.println("Inside getRedApples");
        List<Apple> redApples=new ArrayList<Apple>();
        AppleRedPredicate appleRedPredicate=new AppleRedPredicate();
        if(!appleList.isEmpty()){
            ListIterator<Apple> appleListIterator= appleList.listIterator();
            while(appleListIterator.hasNext()){
                Apple apple=appleListIterator.next();
                if(appleRedPredicate.testApple(apple)){
                    redApples.add(apple);
                    System.out.println(apple.toString());
                }
            }
        }
        return redApples;
    }


    public  List<Apple> filterApples(List<Apple> appleList, AppleInterface appleInterface){
        System.out.println("Inside filterApples"+appleInterface.getClass().getCanonicalName());
        List<Apple> redApples=new ArrayList<Apple>();
        if(!appleList.isEmpty()){
            ListIterator<Apple> appleListIterator= appleList.listIterator();
            while(appleListIterator.hasNext()){
                Apple apple=appleListIterator.next();
                if(appleInterface.testApple(apple)){
                    redApples.add(apple);
                    System.out.println(apple.toString());
                }
            }
        }
        return redApples;
    }

}
