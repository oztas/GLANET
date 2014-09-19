/**
 * @author burcakotlu
 * @date Sep 18, 2014 
 * @time 10:20:46 AM
 */
package ui;

import empiricalpvalues.AnnotatePermutationsWithNumbersWithChoices;
import empiricalpvalues.CollectionofPermutationsResults;
import giveninputdata.InputDataProcess;
import giveninputdata.InputDataRemoveOverlaps;
import giveninputdata.Preparation;
import jaxbxjctool.GenerationofSequencesandMatricesforGivenIntervals;
import rsat.RSATMatrixScanClient;
import annotate.intervals.parametric.AnnotateGivenIntervalsWithNumbersWithChoices;
import augmentation.results.AugmentationofEnrichedElementswithGivenInputData;
import augmentation.results.CreationofRemapInputFileswith0BasedStart1BasedEndGRCh37Coordinates;
import common.Commons;

/**
 * 
 */
public class GlanetRunnerWithoutGUI {
	
	private static String args[];
	
	
	public static String[] getArgs() {
		
		return args;
	}

	public static void setArgs( String args[]) {
		
		GlanetRunnerWithoutGUI.args = new String[args.length];
		for( int i = 0; i < args.length; i++) 
			GlanetRunnerWithoutGUI.args[i] = args[i];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		setArgs(args);
		
		Preparation.main(args);
				
		InputDataProcess.main(args);
		
		/* In case of Enrichment remove overlaps and merge */
		/* In case of only Annotation, do not remove overlaps and do not merge*/
		if( getArgs()[4].equalsIgnoreCase(Commons.DO_ENRICH)){
			InputDataRemoveOverlaps.main(args);
		}
						
		AnnotateGivenIntervalsWithNumbersWithChoices.main(args);
		
		
		if( getArgs()[4].equalsIgnoreCase(Commons.DO_ENRICH)){
			
			AnnotatePermutationsWithNumbersWithChoices.main(args);
			
			CollectionofPermutationsResults.main(args);
			
			AugmentationofEnrichedElementswithGivenInputData.main(args);
			
			CreationofRemapInputFileswith0BasedStart1BasedEndGRCh37Coordinates.main(args);
	
			
			if( getArgs()[16].equalsIgnoreCase(Commons.DO_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT)) {
				
				GenerationofSequencesandMatricesforGivenIntervals.main(args);
				RSATMatrixScanClient.main(args);
			}
		}
		
	
	}

}
