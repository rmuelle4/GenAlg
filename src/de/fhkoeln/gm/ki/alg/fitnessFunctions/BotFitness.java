/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhkoeln.gm.ki.alg.fitnessFunctions;

import de.fhkoeln.gm.ki.alg.genes.AbstractGene;
import de.fhkoeln.gm.ki.alg.util.Individual;
import de.fhkoeln.gm.ki.remoteControl.BotMonitor;
import java.util.ArrayList;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Motor;

/**
 *
 * @author Mahdi
 */
public class BotFitness extends AbstractFitness{
    private float highest = -10000000;
    
    private float lastDistance = 0;

    @Override
    public float evaluate(Individual genome) {
        
        
        ArrayList<AbstractGene> geneList = genome.getGenes();
        UltrasonicSensor uss = new UltrasonicSensor(SensorPort.S1);
        float currentDistance = uss.getDistance();
        float fitness = 0;
        
        for(AbstractGene g : geneList) {
            g.execute();
        }
        
        Motor.A.rotateTo(0);
        Motor.B.rotateTo(0);
        
        fitness = uss.getDistance() - currentDistance;
        genome.fitness = fitness;
        
        return fitness;
        
    }

    @Override
    public boolean thresholdReached() {
       return false;
    }

    @Override
    public String getName() {
        String name;
        name = "Fitness LegoBot";
        return name;
    }
    
}
