package de.fhkoeln.gm.ki.alg.reproducers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.fhkoeln.gm.ki.alg.util.DataSource;
import de.fhkoeln.gm.ki.alg.util.Population;


/***
 * Abstract Class for Reproducers, also handles GUI integration
 * @author Sascha Schewe
 *
 */
public abstract class AbstractReproducer implements ActionListener {

	public AbstractReproducer(){
		DataSource.getInstance().currentReproducer = this;
	}
	
	/***
	 * Reproduces the old population and returns a new one
	 * @param oldGeneration the original population to be reproduced
	 * @param tmpGeneration the temporary population to reproduce with
	 * @return the next generation/population
	 */
	public abstract Population reproduce(Population oldGeneration, Population tmpGeneration);
	
	public abstract String getName();




        @Override
	public final void actionPerformed(ActionEvent e) {
		DataSource.getInstance().currentReproducer=this;
		
	}



}
