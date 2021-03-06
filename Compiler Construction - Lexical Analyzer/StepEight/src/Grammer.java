/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
class Grammer {
    
    public String[] tableheading= {"State", "id", "+", "*", "(", ")", "$", "E", "T", "F"};
     public String[][] SLRparsingTable = {
        
            {"0", "s5", "", "", "s4", "", "", "1", "2", "3"},
            {"1", "", "s6", "", "", "", "accept", "", "", ""},
            {"2", "", "r2", "s7", "", "r2", "r2", "", "", ""},
            {"3", "", "r4", "r4", "", "r4", "r4", "", "", ""},
            {"4", "s5", "", "", "s4", "", "", "8", "2", "3"},
            {"5", "", "r6", "r6", "", "r6", "r6", "", "", ""},
            {"6", "s5", "", "", "s4", "", "", "", "9", "3"},
            {"7", "s5", "", "", "s4", "", "", "", "", "10"},
            {"8", "", "s6", "", "", "s11", "", "", "", ""},
            {"9", "", "r1", "s7", "", "r1", "r1", "", "", ""},
            {"10", "", "r3", "r3", "", "r3", "r3", "", "", ""},
            {"11", "", "r5", "r5", "", "r5", "r5", "", "", ""}};
      public String[] CFG = {"E->E+T", "E->T", "T->T*F", "T->F", "F->(E)", "F->i"};
      
     public void printTable()
     {
         System.out.println("\t \t \t  \t \t SLR(1) Parsing Table");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
   for (int k = 0; k < tableheading.length; k++){
     System.out.printf("%10s", tableheading[k] + " ");
    
   }
   
   System.out.println();
   System.out.println("-----------------------------------------------------------------------------------------------------------------------------");    
   for (int i = 0; i < SLRparsingTable.length; i++) { 
         for (int j = 0; j < SLRparsingTable[i].length; j++) { 
            System.out.printf("%10s", SLRparsingTable[i][j] + " ");
         }
         System.out.println(); 
           System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
      }
   
     
     }
 public void printProductionRules()
    {
   int j;
        System.out.println("\t\tCFG");
        System.out.println("---------------------------------");
        for(int i=0;i<CFG.length;i++)
    {
   j=i+1;
        System.out.println("Rule "+j +":  "+CFG[i]);
    
  
    }
    }

public void accessTabledata(int state, String symbol)
{
int symcode=24;
    
    switch(symbol){
        case "id":symcode=1;break;
        case "+":symcode=2;break;
        case "*":symcode=3;break;
    case "(":symcode=4;break;
    case ")":symcode=5;break;
    case "$":symcode=6;break;
    case "E":symcode=7;break;
   case "T":symcode=8;break;
   case "F":symcode=9;break;
   default:symcode=10;break;
    }
if(state>=0&&state<=13&&symcode<=9){

if(SLRparsingTable[state][symcode].equals(""))
{
    System.out.println("error");
}
else{
    
    System.out.println(SLRparsingTable[state][symcode]);
    

}
}

else{
    System.out.println("State or Symbol at given input is not present in the table.");
}
}
public void accessProductionRule(int ruleno)
{
if(ruleno>=0&&ruleno<=6)
{    System.out.println(CFG[ruleno-1]);
}
else{
    
   System.out.println("Rule Number "+ruleno +" is not present in the grammar.");  
}}
}