package genomeAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import genomeAnalysis.WriteResult;

public class StartExtract {
	
public static void startExtractFasta(String strander, String chrom, Integer strer, Integer ender) throws IOException{
		
		String path = "./hg19/";
        File folder = new File(path); 
        File[] fileFolder = folder.listFiles(); 
        String sequenceRead;
     	int count = 0;
     	int nextStop; 
     	ArrayList<String> tmpSequence = new ArrayList<String>(); 
        StringBuffer sequenceBufferPlus = new StringBuffer();
     	if(strander.equals("+")) {     		
     		 for(int i=0; i<fileFolder.length; i++) {             	 
         	    if(fileFolder[i].getName().equals(chrom+".fa")){ 
         		   Scanner sc = new Scanner(fileFolder[i]);
         		   sc.useDelimiter("\\s*"); 
         		   try {
         			 while(sc.hasNext()) {
 		            	count ++;
 		    	        sequenceRead = sc.next();
 		    	        nextStop = count; 
 		    	        if((nextStop >= (strer)) && (nextStop <= (ender))){
 		    	             tmpSequence.add(sequenceRead);
 		    	        	 }
 		    	        else{}
         		   }
 		    	      
 		           } catch(InputMismatchException e) {
 		        	        e.printStackTrace(); 
 		           } catch(NoSuchElementException e) {
 		        	       e.printStackTrace(); 
 		           }
         		  
         		  // Convert arraylist to string and load into TEXT file 
         		  for(int m=0; m<= tmpSequence.size()-1; m++){
	    	        	sequenceBufferPlus.append(tmpSequence.get(m));
	    	       }
	    	          WriteResult.loadSequence(chrom, strander, strer, ender, sequenceBufferPlus.toString());
         	       }
               }            	
    	   }
     	
     	else {
     		
     	 for(int i=0; i<fileFolder.length; i++) { 
           	 
             if(fileFolder[i].getName().equals(chrom+".fa")){  
          	    Scanner sc = new Scanner(fileFolder[i]);
         	    sc.useDelimiter("\\s*"); 
         	    String[] nucleotide = {"A","T","C","G","a","t","c","g", "N", "n"};
	    	    String[] minusNucleotide = {"T","A","G","C","t","a","g","c", "N", "n"};
	    	    StringBuffer sequenceBufferMinus = new StringBuffer(); 
         		  try {
         		   while(sc.hasNext()) {
 		            count ++;
 		    	    sequenceRead = sc.next();
 		    	    nextStop = count;
		    	       if((nextStop >= strer) && (nextStop <= ender))      
		    	           { 
		    	    	    for(int j=0; j<=9; j++)
		    	    	        { 
		    	    	    	  if(sequenceRead.equals(nucleotide[j]))
			            	         {
		    	    	    		   tmpSequence.add(minusNucleotide[j]);
		    	    	    	     }
		    	    	        }
		    	           }
		    	       else{}
         		   }
 		           } catch(InputMismatchException e) {
 		        	   e.printStackTrace(); 
 		           } catch(NoSuchElementException e) {
 		        	   e.printStackTrace();
 		           }
         		 // Covert arraylist to string and load into TEXT file 
         		 for(int k=tmpSequence.size()-1; k>=0; k--)
         		 { 
         		   sequenceBufferMinus.append(tmpSequence.get(k).toString());
         		 }
                   WriteResult.loadSequence(chrom, strander, strer, ender, sequenceBufferMinus.toString());
         	     }
             }
         }    
     }
}
