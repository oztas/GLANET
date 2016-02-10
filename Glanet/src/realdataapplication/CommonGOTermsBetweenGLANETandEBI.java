/**
 * 
 */
package realdataapplication;

import enumtypes.CommandLineArguments;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import auxiliary.FileOperations;
import common.Commons;

/**
 * @author Bur�ak Otlu
 * @date Feb 10, 2016
 * @project Glanet 
 *
 */
public class CommonGOTermsBetweenGLANETandEBI {

	/**
	 * 
	 */
	public CommonGOTermsBetweenGLANETandEBI() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static String getAdditionalZeros(int goNumber){
		
		String additionalZeros = "";
		
		
		//0000000
		for(int i=6; i>=0; i--){
			if(goNumber/((int)Math.pow(10, i))==0){
				additionalZeros = additionalZeros + "0";
			}
		}
		
		return additionalZeros;
		
		
	}
	
	
	public static void findCommonGOTerms(
			TIntList goNumber_EBI_List,
			TIntList goNumber_GLANET_List,
			TIntObjectMap<String> goNumber2TermMap,
			String information){
		
		int goNumber;
		
		String addZeros = null;
		
		System.out.println("\n************************************************************" + information + " starts************************************************************"  );
		System.out.println("GOID\tGOTerm\tzScore");
		for(TIntIterator itr = goNumber_GLANET_List.iterator();itr.hasNext();){
			
			goNumber = itr.next();
			
			if (goNumber_EBI_List.contains(goNumber)){
				
				addZeros = getAdditionalZeros(goNumber);
				System.out.println("GO:" + addZeros + goNumber + "\t" + goNumber2TermMap.get(goNumber));
			}//End of IF
			
		}//End of FOR
		System.out.println("************************************************************" + information + " ends************************************************************\n");
		
	}
	
	
	public static void readGLANETFile(
			String enrichedGOTermsGLANET_SydhGata2K562FileName,
			TIntList enrichedGOTermsGLANET_SydhGata2K562_List,
			TIntObjectMap<String> goNumber2TermMap){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String  strLine = null;
		String goNumberWithUnderscore = null;
		
		int goNumber;
		int indexofFirstTab = -1;
		int indexofSecondTab = -1;
		int indexofUnderscore = -1;
		
		String goTerm = null;
		String zScore = null;
		
		try {
			
			fileReader = FileOperations.createFileReader(enrichedGOTermsGLANET_SydhGata2K562FileName);
			bufferedReader = new BufferedReader(fileReader);
			
			//example lines
			//GO ID	zScore	GO Term
			//GO_0002295	25.25324782	T-helper cell lineage commitment
			//GO_0045403	25.25324782	negative regulation of interleukin-4 biosynthetic process

			//skip header line
			strLine = bufferedReader.readLine();
			
			while((strLine = bufferedReader.readLine())!=null){
				
				indexofFirstTab = strLine.indexOf('\t');				
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);	
				
				goNumberWithUnderscore = strLine.substring(0,indexofFirstTab);
				
				indexofUnderscore = goNumberWithUnderscore.indexOf('_');
				
				goNumber = Integer.parseInt(goNumberWithUnderscore.substring(indexofUnderscore+1,indexofFirstTab));
				
				zScore = strLine.substring(indexofFirstTab+1, indexofSecondTab);
				
				goTerm = strLine.substring(indexofSecondTab+1);
				
				if (!enrichedGOTermsGLANET_SydhGata2K562_List.contains(goNumber)){
					enrichedGOTermsGLANET_SydhGata2K562_List.add(goNumber);
					
				}//End of IF
				
				if (!goNumber2TermMap.containsKey(goNumber)){
					goNumber2TermMap.put(goNumber, goTerm + "\t" + zScore);
				}//End of IF
				
			}//End of WHILE
			
			//Close bufferedReader
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void readEBIFile(String gata2AssociatedGOTermsEBIFileName,TIntList gata2AssociatedGOTermsEBI_List){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String  goID = null;
		int goNumber;
		int indexofColon = -1;
		
		try {
			
			fileReader = FileOperations.createFileReader(gata2AssociatedGOTermsEBIFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			//example lines
			//GO Identifier
			//GO:0000122
			
			//skip header line
			goID = bufferedReader.readLine();
			
			while((goID = bufferedReader.readLine())!=null){
				
				indexofColon = goID.indexOf(':');				
				goNumber = Integer.parseInt(goID.substring(indexofColon+1));
				
				if (!gata2AssociatedGOTermsEBI_List.contains(goNumber)){
					gata2AssociatedGOTermsEBI_List.add(goNumber);
				}//End of IF
				
			}//End of WHILE
			
			//Close bufferedReader
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];
		String dataFolder = glanetFolder + Commons.DATA + System.getProperty( "file.separator");
		
		
		TIntList  gata2AssociatedGOTermsEBI_List = new TIntArrayList();
		TIntList  exonBased_enrichedGOTermsGLANET_SydhGata2K562_List = new TIntArrayList();
		TIntList  regulationBased_enrichedGOTermsGLANET_SydhGata2K562_List = new TIntArrayList();
		TIntList  extendedBased_enrichedGOTermsGLANET_SydhGata2K562_List = new TIntArrayList();

		//TIntList  enrichedGOTermsGLANET_SydhGata2Huvec = new TIntArrayList();
		//TIntList  enrichedGOTermsGLANET_HaibGata2K562 = new TIntArrayList();
		
		TIntObjectMap<String> exonBased_goNumber2TermMap = new TIntObjectHashMap<String>();
		TIntObjectMap<String> regulationBased_goNumber2TermMap = new TIntObjectHashMap<String>();
		TIntObjectMap<String> extendedBased_goNumber2TermMap = new TIntObjectHashMap<String>();
		
		//FROM EBI
		String gata2AssociatedGOTermsEBIFileName = dataFolder + System.getProperty( "file.separator") + "demo_input_data" + System.getProperty( "file.separator") + "GREAT_Inspired_RealDataApplication" + System.getProperty( "file.separator") + "EBI_GATA2_GO.txt" ;

		//FROM GLANET
		String exonBased_enrichedGOTermsGLANET_SydhGata2K562FileName = dataFolder + System.getProperty( "file.separator") + "demo_input_data" + System.getProperty( "file.separator") + "GREAT_Inspired_RealDataApplication" + System.getProperty( "file.separator") + "exonBased_sydhGata2K562_GO.txt" ;
		String regulationBased_enrichedGOTermsGLANET_SydhGata2K562FileName = dataFolder + System.getProperty( "file.separator") + "demo_input_data" + System.getProperty( "file.separator") + "GREAT_Inspired_RealDataApplication" + System.getProperty( "file.separator") + "regulationBased_sydhGata2K562_GO.txt" ;
		String extendedBased_enrichedGOTermsGLANET_SydhGata2K562FileName = dataFolder + System.getProperty( "file.separator") + "demo_input_data" + System.getProperty( "file.separator") + "GREAT_Inspired_RealDataApplication" + System.getProperty( "file.separator") + "extendedBased_sydhGata2K562_GO.txt" ;

		readEBIFile(gata2AssociatedGOTermsEBIFileName,gata2AssociatedGOTermsEBI_List);
		
		readGLANETFile(exonBased_enrichedGOTermsGLANET_SydhGata2K562FileName,exonBased_enrichedGOTermsGLANET_SydhGata2K562_List,exonBased_goNumber2TermMap);
		readGLANETFile(regulationBased_enrichedGOTermsGLANET_SydhGata2K562FileName,regulationBased_enrichedGOTermsGLANET_SydhGata2K562_List,regulationBased_goNumber2TermMap);
		readGLANETFile(extendedBased_enrichedGOTermsGLANET_SydhGata2K562FileName,extendedBased_enrichedGOTermsGLANET_SydhGata2K562_List,extendedBased_goNumber2TermMap);
	
		findCommonGOTerms(gata2AssociatedGOTermsEBI_List,exonBased_enrichedGOTermsGLANET_SydhGata2K562_List,exonBased_goNumber2TermMap, "ExonBased --- SydhGata2(K562) --- CommonGOTerms  --- Between GLANET and EMBL-EBI");
		findCommonGOTerms(gata2AssociatedGOTermsEBI_List,regulationBased_enrichedGOTermsGLANET_SydhGata2K562_List,regulationBased_goNumber2TermMap,"RegulationBased --- SydhGata2(K562) --- CommonGOTerms  --- Between GLANET and EMBL-EBI");
		findCommonGOTerms(gata2AssociatedGOTermsEBI_List,extendedBased_enrichedGOTermsGLANET_SydhGata2K562_List,extendedBased_goNumber2TermMap,"ExtendedBased --- SydhGata2(K562) --- CommonGOTerms  --- Between GLANET and EMBL-EBI");

	}

}
