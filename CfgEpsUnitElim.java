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
	
	//private ArrayList<String> V = new ArrayList<String>();
	private String v;
	private String[] vArray;
	private String terminals;
	//private String[] terminalsArray;
	private String[] r;
    private ArrayList<ArrayList<String>> terminalsVariables = new ArrayList<ArrayList<String>>();
    private ArrayList<String> doneSubs = new ArrayList<String>();
    private ArrayList<String> doneUnitRules = new ArrayList<String>();
	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *             representation follows the one in the task description
	 */
	public CfgEpsUnitElim(String cfg) {
		// TODO Auto-generated constructor stub
		
		String[] temp = cfg.split("#");
		this.v = temp[0];
		this.vArray = v.split(";");
		this.terminals = temp[1];
		//this.terminalsArray = terminals.split(";");
		this.r = temp[2].split(";");
		DictatingTVs();
//		eliminateEpsilonRules();
//		eliminateUnitRules();
//		toString();
		
	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		   // String epsilonElim = v + "#" + terminals;
		    String UnitRuleElim = v + "#" + terminals;
		    
		    String transitions = "";
		    String transitions2 = "";
		   // System.out.println("epsilonElim: " + epsilonElim);
			//eliminateEpsilonRules();
			//eliminateUnitRules();
			
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
				
				//System.out.println("transitions: " + transitions);
			}
			
			UnitRuleElim = UnitRuleElim + "#" + transitions;
			//System.out.println("UnitRuleElim: " + UnitRuleElim);
		// TODO Auto-generated method stub
		return UnitRuleElim;
	}

	/**
	 * Eliminates Epsilon Rules from the grammar
	 */
	public void eliminateEpsilonRules() {
		// TODO Auto-generated method stub
		for (int i = 0; i < terminalsVariables.size(); i++) {
			if (terminalsVariables.get(i).contains("e")) {
				//System.out.println("terminalsVariables.get(i): " + terminalsVariables.get(i));
				
				//el variable el hageeb beeh el subs beta3to
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
		
			
		//System.out.println("terminalsVariables FINAL:" + terminalsVariables);
		//System.out.println("doneSubs: " + doneSubs);
		cleanArrays();
		sortArraysLexi(terminalsVariables);
		
		}
	
}
	
	
	
	
	public void ReplacingEs(String v) {
		
		ArrayList<Integer> allOccurrances = new ArrayList<Integer>();
		ArrayList<String> finalCombos = new ArrayList<String>();
		
		for (int i = 0; i < terminalsVariables.size(); i++) {
			for (int k = 0; k < terminalsVariables.get(i).size(); k++) {
				//ASA ---> AS/SA/S
				//System.out.println("terminalsVariables before: " + terminalsVariables);
				//System.out.println("EL VARIABLE EL WA2FA ANDO: " + terminalsVariables.get(i).get(k));
				if (terminalsVariables.get(i).get(k).contains(v)) {
					
					
					allOccurrances = findAllOccurrences(terminalsVariables.get(i).get(k), v);
					int occurCount = countOccurrence(terminalsVariables.get(i).get(k), v);
					finalCombos = generateCombos(allOccurrances, terminalsVariables.get(i).get(k), v, occurCount);
					//System.out.println("FINAL COMBOS: " + finalCombos);
					if (finalCombos.isEmpty() && !(terminalsVariables.get(i).contains("e"))) {
						//System.out.println("ana fady");
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
					
					//System.out.println("terminalsVariables after: " + terminalsVariables);
					
					//System.out.println(allOccurrances);
					//int occurCount = countOccurrence(terminalsVariables.get(i).get(k), v);
					//System.out.println(occurCount);
					//finalCombos = generateCombos(terminalsVariables.get(i).get(k), v, occurCount);
							
							
							
					//we still need to handle checking law el returned array fadya
					
					
					//String newRemoved = terminalsVariables.get(i).get(k).replace(v, "");
					//System.out.println(newRemoved);
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
		//System.out.println("FINAL COMBOS SIZE BEFORE: " + finalCombos.size());
		ArrayList<String> combos = new ArrayList<String>();
		
		
		for (int i = 0; i < allOcurrances.size(); i++) {
			
            StringBuilder sb = new StringBuilder(tv);
            sb.deleteCharAt(allOcurrances.get(i)); 
            if (! (sb.toString().equals(""))) {
            	combos.add(sb.toString());
            	//System.out.println("sb: " + sb.toString());
            }
            
//            else {
//            	System.out.println("sb: FADYAAAAAA");
//            }
            
           // System.out.println("COMBOS: " + combos);
        }
		
		
		finalCombos.addAll(combos);
		
		
		for (int k = 0; k < combos.size(); k++) {
			for (int j = 1; j <= count; j++) {
				StringBuilder tempy = new StringBuilder(tv);
				
				for (int i = 0; i < j; i++) {
					//System.out.println("i: " + i);
					int index = tempy.indexOf(v);
					//System.out.println("index of v: " + index);
					tempy.deleteCharAt(index);
					//System.out.println("ana tempy: " + tempy);
				}
				
				
				if (! (finalCombos.contains(tempy.toString()))) {
					finalCombos.add(tempy.toString());
				}
		  }
	}
		
			
		
		//System.out.println("FINAL COMBOS SIZE AFTER: " + finalCombos.size());
		//System.out.println(finalCombos);
		return finalCombos;
	}
	
	
	public void DictatingTVs() {
		
		
		for (int i = 0; i < r.length; i++) {
			String[] transition = r[i].split("/");
			String[] tv = transition[1].split(",");
			ArrayList<String> temp = new ArrayList<String>();
			
			for (int j = 0; j < tv.length; j++) {
				//System.out.println(j);
				temp.add(tv[j]);
			}
			
		    terminalsVariables.add(temp);
		}
		
	}
	
	
	
	public void cleanArrays() {
		for (int i = 0; i < terminalsVariables.size(); i++) {
				terminalsVariables.get(i).remove("");
			}
		//System.out.println("CLEAN terminalsVariables: " + terminalsVariables);
		
	}
	
	
	
	public void sortArraysLexi(ArrayList<ArrayList<String>> a) {
		for (int i = 0; i < a.size(); i++) {
			Collections.sort(a.get(i));
		}
		
		//System.out.println("aroo7 fein tani: " + terminalsVariables);
	}

	/**
	 * Eliminates Unit Rules from the grammar
	 */
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
		    					//System.out.println("they're equal!!!!" + "vArray[i]: " + vArray[i] + " terminalsVariables.get(k).get(z): " + terminalsVariables.get(k).get(z));
		    				}
		    				
		    				else {
		    					//System.out.println("element im going to add: " + terminalsVariables.get(k).get(z));
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
		//System.out.println("ALL TIME FINAL terminalsVariables: " + terminalsVariables);
		// TODO Auto-generated method stub
	}
	
	
	

	
	
//	public static void main(String[] args) { 
//		String cfg = "S;A;B;C#a;b;c;d;x#S/aAb,xB;A/Bc,C,c,d;B/CACA,e;C/A,b,e";
//		
//		CfgEpsUnitElim idk = new CfgEpsUnitElim(cfg);
//		
////		System.out.println(idk.v);
////		System.out.println(idk.terminalsVariables);
////		
////		for(int i = 0; i < idk.vArray.length; i++) {
////			System.out.println(idk.vArray[i]);
////		}
////		
////		for(int i = 0; i < idk.terminalsArray.length; i++) {
////			System.out.println(idk.terminalsArray[i]);
////		}
////		
////		for(int i = 0; i < idk.r.length; i++) {
////			System.out.println(idk.r[i]);
////		}
//	}

}
