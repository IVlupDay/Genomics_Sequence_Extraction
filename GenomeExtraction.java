package genomeAnalysis;

/*
 * 
 * This Java program is developed to extract all sequence 
 * (nucleotides) from human reference genome 
 * 
 * 
 */

import java.util.ArrayList; 
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.*; 

import genomeAnalysis.StartExtract; 

public class GenomeExtraction {

	public static void main(String[] args) {
        
		long startingTime = System.currentTimeMillis(); 
		
		System.out.println("\n"+"Start searching sequences...");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n");
		String erbsCoordinate = "./ErbswithStrand/erbswithStrandHg19.csv";
        String line = ""; 
        String splitPattern = ",";
        BufferedReader br = null;       
        try {
        	
        	br = new BufferedReader(new FileReader(erbsCoordinate)); 
        	while((line = br.readLine()) != null){
        	  String[] erbs = line.split(splitPattern); 
         	  StartExtract.startExtractFasta(erbs[1], erbs[0], Integer.parseInt(erbs[2]),Integer.parseInt(erbs[3]));
        	  System.out.println();
        	}
        	 
          }  catch(IOException e){
        	      e.printStackTrace();        	
          }  catch(InputMismatchException e){
        	      e.printStackTrace();        	
          }  catch(NoSuchElementException e){
        	      e.printStackTrace();        	
          }  finally {
        	if(br != null) {
        		try {
        			
        			br.close();
        			} catch(IOException e){
        			   e.printStackTrace(); 
        		  }
        	  }
          }
            
		System.out.println("\n\n\n");		
		long endingTime = System.currentTimeMillis(); 
		System.out.print((endingTime-startingTime)/(1000*3600)+" Hours"+"\n\n");
		
		System.out.println("\n"+"Finish loading sequences into TEXT files");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n");
		
	 	}
     }
