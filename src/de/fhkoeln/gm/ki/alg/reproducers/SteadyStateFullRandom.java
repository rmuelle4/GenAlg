/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhkoeln.gm.ki.alg.reproducers;

import de.fhkoeln.gm.ki.alg.util.Individual;
import de.fhkoeln.gm.ki.alg.util.Population;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mahdi
 */
public class SteadyStateFullRandom extends AbstractReproducer{

    @Override
    public Population reproduce(Population oldGeneration, Population tmpGeneration) {
        Population p = oldGeneration;
        for(int i=0;i < tmpGeneration.getPop().size(); i++) {
            p.replace(p.getIndividualAt(new Random().nextInt(p.getCurrentSize())), tmpGeneration.getPop().get(i));
        }
        
        return p;
    }

    @Override
    public String getName() {
        String name;
        name = "SteadyStateFullRandom";
        return name;
    }
    
}
