package com.org.project.module.coreJava.Impl;

import com.org.project.module.coreJava.appleInterface.AppleInterface;
import com.org.project.module.coreJava.model.Apple;
import org.springframework.stereotype.Service;

@Service
public class AppleRedPredicate implements AppleInterface {
    @Override
    public boolean testApple(Apple a) {
        return a.getColor().equalsIgnoreCase("RED");
    }
}
