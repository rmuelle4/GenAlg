/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhkoeln.gm.ki.alg.reproducers;

import de.fhkoeln.gm.ki.alg.util.Population;

/**
 *
 * @author Mahdi
 */
public class FullReplacement extends AbstractReproducer{

    @Override
    public Population reproduce(Population oldGeneration, Population tmpGeneration) {
        Population newPop = tmpGeneration;
        
        return newPop;
    }

    @Override
    public String getName() {
        String name;
        name = "FullReplacement";
        return name;
    }
    
}
