package csen1002.main.task4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write your info here
 * 
 * @name Maram Hossam
 * @id 49-1891
 * @labNumber 18
 */

public class CfgEpsUnitElim {
	
	private String v;
	private String[] vArray;
	private String terminals;
	private String[] r;
    private ArrayList<ArrayList<String>> terminalsVariables = new ArrayList<ArrayList<String>>();
    private ArrayList<String> doneSubs = new ArrayList<String>();
    private ArrayList<String> doneUnitRules = new ArrayList<String>();
	
	public CfgEpsUnitElim(String cfg) {
		
		String[] temp = cfg.split("#");
		this.v = temp[0];
		this.vArray = v.split(";");
		this.terminals = temp[1];
		this.r = temp[2].split(";");
		DictatingTVs();
		
	}

	
	@Override
	public String toString() {
		    String UnitRuleElim = v + "#" + terminals;
		    
		    String transitions = "";
		    String transitions2 = "";
			
			for (int i = 0; i < vArray.length; i++) {
				if (transitions.equals("")) {
					transitions = vArray[i] + "/";
				}
				
				else {
					transitions = transitions + ";" + vArray[i] + "/";
				}
				
				
				for (int k = 0; k < terminalsVariables.get(i).size(); k++) {
					if (transitions2.equals("")) {
						transitions2 = terminalsVariables.get(i).get(k);
					}
					
					else {
						transitions2 = transitions2 + "," + terminalsVariables.get(i).get(k);
					}
				}
				
				transitions = transitions + transitions2;
				transitions2 = "";
				
			}
			
			UnitRuleElim = UnitRuleElim + "#" + transitions;

		return UnitRuleElim;
	}

	
	public void eliminateEpsilonRules() {
		for (int i = 0; i < terminalsVariables.size(); i++) {
			if (terminalsVariables.get(i).contains("e")) {
				
				String currV = vArray[i];
				String currSub = currV + ">" + "e";
				doneSubs.add(currSub);
				ReplacingEs(currV);
				terminalsVariables.get(i).remove("e");
			
			}
		}
		
		
		for (int i = 0; i < terminalsVariables.size(); i++) {
			if (terminalsVariables.get(i).contains("e")) {
				eliminateEpsilonRules();
				break;
			}
		
			
		cleanArrays();
		sortArraysLexi(terminalsVariables);
		
		}
	
}
	
	
	
	
	public void ReplacingEs(String v) {
		
		ArrayList<Integer> allOccurrances = new ArrayList<Integer>();
		ArrayList<String> finalCombos = new ArrayList<String>();
		
		for (int i = 0; i < terminalsVariables.size(); i++) {
			for (int k = 0; k < terminalsVariables.get(i).size(); k++) {
				
				if (terminalsVariables.get(i).get(k).contains(v)) {
					
					
					allOccurrances = findAllOccurrences(terminalsVariables.get(i).get(k), v);
					int occurCount = countOccurrence(terminalsVariables.get(i).get(k), v);
					finalCombos = generateCombos(allOccurrances, terminalsVariables.get(i).get(k), v, occurCount);
					if (finalCombos.isEmpty() && !(terminalsVariables.get(i).contains("e"))) {
						String doneSub = vArray[i] + ">" + "e";
						if (! (doneSubs.contains(doneSub)) )
						terminalsVariables.get(i).add("e");
					}
					
					else {
						for (int z = 0; z < finalCombos.size(); z++) {
							if (! (terminalsVariables.get(i).contains(finalCombos.get(z)))) {
								terminalsVariables.get(i).add(finalCombos.get(z));
							}
						}
						
					}

				}
				
				
			}
		}
		
		
	}
	
	
	
	public int countOccurrence(String str, String v) {
		String[] word = str.split("");
		int count = 0;
		for (int i = 0; i < word.length; i++) {
			if (word[i].equals(v)) {
				count++;
			}
		}
		
		return count;
	}
	
	
	
	 public ArrayList<Integer> findAllOccurrences(String str, String v) {
	        ArrayList<Integer> occurrenceList = new ArrayList<>();
	        for (int i = 0; i < str.length(); i++) {
	            if (String.valueOf(str.charAt(i)).equals(v)) {
	                occurrenceList.add(i); 
	            }
	        }
			return occurrenceList;
	 }
	
	
	
	public ArrayList<String> generateCombos(ArrayList<Integer> allOcurrances, String tv,  String v, int count) {
		ArrayList<String> finalCombos = new ArrayList<String>();
		ArrayList<String> combos = new ArrayList<String>();
		
		
		for (int i = 0; i < allOcurrances.size(); i++) {
			
            StringBuilder sb = new StringBuilder(tv);
            sb.deleteCharAt(allOcurrances.get(i)); 
            if (! (sb.toString().equals(""))) {
            	combos.add(sb.toString());
            }
            
        }
		
		
		finalCombos.addAll(combos);
		
		
		for (int k = 0; k < combos.size(); k++) {
			for (int j = 1; j <= count; j++) {
				StringBuilder tempy = new StringBuilder(tv);
				
				for (int i = 0; i < j; i++) {
					int index = tempy.indexOf(v);
					tempy.deleteCharAt(index);
				}
				
				
				if (! (finalCombos.contains(tempy.toString()))) {
					finalCombos.add(tempy.toString());
				}
		  }
	}
		
		return finalCombos;
	}
	
	
	public void DictatingTVs() {
		
		
		for (int i = 0; i < r.length; i++) {
			String[] transition = r[i].split("/");
			String[] tv = transition[1].split(",");
			ArrayList<String> temp = new ArrayList<String>();
			
			for (int j = 0; j < tv.length; j++) {
				temp.add(tv[j]);
			}
			
		    terminalsVariables.add(temp);
		}
		
	}
	
	
	
	public void cleanArrays() {
		for (int i = 0; i < terminalsVariables.size(); i++) {
				terminalsVariables.get(i).remove("");
			}
		
	}
	
	
	
	public void sortArraysLexi(ArrayList<ArrayList<String>> a) {
		for (int i = 0; i < a.size(); i++) {
			Collections.sort(a.get(i));
		}
		
	}

	public void eliminateUnitRules() {
		
		for (int i = 0; i < terminalsVariables.size(); i++) {
		      for (int k = 0; k < vArray.length; k++) {
		    	  if (terminalsVariables.get(i).contains(vArray[k])) {
		    		  terminalsVariables.get(i).remove(vArray[k]); //remove Variable
		    		  String unitTrans = vArray[i] + ">" + vArray[k];
		    		  doneUnitRules.add(unitTrans);
		    		  
		    		  for (int z = 0; z < terminalsVariables.get(k).size(); z++) {
		    			  if (! (terminalsVariables.get(i).contains(terminalsVariables.get(k).get(z)))) {
		    				if ( (terminalsVariables.get(k).get(z).equals(vArray[i]))) {
		    				}
		    				
		    				else {
			    				  terminalsVariables.get(i).add(terminalsVariables.get(k).get(z));
		    				}
		    				 
		    			  }
		    		  }
		    	  }
		      }
		}
		
		
		for (int i = 0; i < terminalsVariables.size(); i++) {
		      for (int k = 0; k < vArray.length; k++) {
		    	  if (terminalsVariables.get(i).contains(vArray[k])) {
		    		  eliminateUnitRules();
		    		  break;
		    	  }
		      			}  
		      }
		
		sortArraysLexi(terminalsVariables);
	}

}
