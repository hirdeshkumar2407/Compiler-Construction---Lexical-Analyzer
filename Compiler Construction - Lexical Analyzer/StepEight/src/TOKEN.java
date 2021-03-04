
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

public class TOKEN {
   
List<List> arraylist2D = new ArrayList<>();
List list1=new ArrayList();    
    int test=0;
   
       int numid=0;
   public String pass;
    public String attribute;
    public String lexeme;
public String name;
public ArrayList<String> list;
public TOKEN()
        
{

}
    public TOKEN (String pass, ArrayList<String> list){
this.pass=pass;
this.list=list;
}
    public int i=0;
    char c;
char d;
public int j=0;
      int state =0;
      
    public void getRELOPToken()
    {
           i=0;
    state=0;
        
  

 while(pass.length()!=i)
 {     
        switch(state)
        {
         
            case 0:
                j=i+1;
                c=pass.charAt(i);
           
            if(c=='<') { state=1;}
            else if(c=='=') { state=5;} 
            else if(c=='>') { state=6;}
            else fail();
            break;
            
            case 1: 
                inc();
                c=pass.charAt(i);
            if(c=='=') {state=2;}
            else if(c=='>') {inc(); state=3;}
            else{ state=4;}
        
            break;
            case 2:OP("<=","RELOP","LE");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
           
            
            case 3:OP("<>","RELOP","NE");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
                    
                  
            case 4:OP("<","RELOP","LT");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            case 5:      
                inc();
                c=pass.charAt(i);
               
             if(c =='=') {state=9;}
        
                  else{  fail();}
break;
            case 6: 
                inc();
                c=pass.charAt(i);
             if(c=='=') { state=7;}
             else{ state=8;}
        break;
            case 7:OP(">=","RELOP","GE");
         inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
                
 
           case 8:OP(">","RELOP","GT");
               inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
         case 9:OP("==","RELOP","EQ");
                    inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
        
             
        }
       
 }
    
        
    } 
    

   public void OP(String symbol,String name, String value)
   {
       test++;
       this.name=name;
       this.attribute=value;
       list1.add(symbol);
       list1.add(name);
       list1.add(value);
       System.out.println(test);
   /*System.out.println("Symbol found:"+symbol+ " ,Token name:"+ name+  " ,and Attribute Value: " + this.attribute);*/
   }
    public void inc()
    {
    i++;
    }
       public void dec()
    {
 i--;
    }
public void fail()
{

inc();
state=0;


}
public void retract()        
        {
            dec();
        }


    public void getAROPandOTOP()
    {
    i=0;
    state=0;
    
        

 while(pass.length()!=i)
 {     
        switch(state)
        {
         
            case 0:
                j=i+1;
                c=pass.charAt(i);
           
            if(c=='='&&pass.charAt(i+1)!='='&&pass.charAt(i-1)!='='&&pass.charAt(i-1)!='<'&&pass.charAt(i-1)!='>') { state=1;}
            else if(c=='(') { state=2;} 
            else if(c==')') { state=3;}
                else if(c=='{') { state=4;} 
            else if(c=='}') { state=5;}
            else if(c==';') { state=6;}
               else if(c=='+') { state=7;}
                else if(c=='-') { state=8;} 
            else if(c=='*') { state=9;}
            else if(c=='/'&&pass.charAt(i+1)!='*'&&pass.charAt(i+1)!='/'&&pass.charAt(i-1)!='*'&&pass.charAt(i-1)!='/') { state=10;}
            else fail();
            break;
            
            case 1: 
          OP("=","OTOP","ASN");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            case 2: 
                 OP("(","OTOP","LPRN");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            
            case 3:   OP(")","OTOP","RPRN");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
                    
                  
            case 4:
                  OP("{","OTOP","LBRC");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            case 5:      
                 OP("}","OTOP","RBRC");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }

            case 6: 
               OP(";","OTOP","LNTR");inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            case 7:OP("+","AROP","ADD");
         inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
                
 
           case 8:OP("-","AROP","SUB");
         inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
                
         case 9:OP("*","AROP","MUL");
         inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
            
                  case 10:OP("/","AROP","DIV");
         inc();
            if(i==pass.length())
            {
             break;
            }
            else {
            
            state=0;
            break;
            }
             
        }
       
 }
    
     
    }
 public void gettoken(String lex, String tok, String att)
 {
     this.lexeme=lex;
  this.name=tok; 
  this.attribute=att;
    /*System.out.println("LEXEMES:"+lex +", TOKEN_NAME:"+tok +", ATTRIBUTE_VALUE:"+att);*/
    list1.add(lex);
    list1.add(tok);
    list1.add(att); }
public void getStringLiteral(){
  i=0;
String str="";
  String regex="\"[^\"\\\\]*(\\\\.[^\"\\\\]*)*\"";
    Pattern p = Pattern.compile(regex); 
  while (pass.length()!=i){
 c=pass.charAt(i);
  
boolean h=Character.isWhitespace(c);
if(h==true ||c=='=' || c==';'){
  Matcher m = p.matcher(str); 
  boolean h2=m.matches();
    
   if(h2==true)
   {
    
    gettoken(str,"sliteral","string literal value");
     str="";
     inc();
     
   }

   else{
   str="";
   inc();
   }

}
    
    

 else{
         str=str.concat(Character.toString(c));
         inc();
         } 

}

  

}



/*
 public void getStringLiteral2()
 {
i=0;
String str="";
char doj;
while(i!=pass.length())
{
    c=pass.charAt(i);
    int jkl = i+1;
    
   if(c=='='){inc();c=pass.charAt(i);
   
if(c=='"'){str=str.concat(Character.toString(c));inc();c=pass.charAt(i);
while (pass.length()!=i){
 c=pass.charAt(i);
if(c=='"'){str=str.concat(Character.toString(c));gettoken("string","sliteral",str);str="";inc(); break;}

else{ str=str.concat(Character.toString(c)); inc();}
}
    
}



else{str="";inc();}
  }else{str="";inc();}
 }}

*/
public void getUnsignedInteger()
 {
i=0;
String str="";
String regex="^[1-9][0-9]*|0$";
    Pattern p = Pattern.compile(regex); 
  while (pass.length()!=i){
 c=pass.charAt(i);
  
boolean h=Character.isWhitespace(c);
if(h==true ||c=='=' || c==';' ){
  Matcher m = p.matcher(str); 
  boolean h2=m.matches();
  
   if(h2==true)
   {
    
       
    
       
           gettoken(str,"uint","unsigned integer value");
         inc();
       str="";
       
     
   }

   else{
     
   str="";
   inc();
   }

}
    
    

 else{
         str=str.concat(Character.toString(c));
         inc();
         } 

}

 }

public void getKeywordsandIdentifer()
     {
  i=0;
String str="";
  String regex="^([a-zA-Z_$][a-zA-Z\\d_$]*)$";
    Pattern p = Pattern.compile(regex); 
  while (pass.length()!=i){
 c=pass.charAt(i);
  
boolean h=Character.isWhitespace(c);
if(h==true ||c=='=' || c==';'){
  Matcher m = p.matcher(str); 
  boolean h2=m.matches();
  
   if(h2==true)
   {
    
       if(str.equals("if"))
       {
     gettoken("if","Keyword",null);
           inc();
       str="";
     
       }
      else if(str.equals("begin"))
       {
     gettoken("begin","Keyword",null);
           inc();
       str="";
     
       }
       
        else if(str.equals("then"))
       {
     gettoken("then","Keyword",null);
           inc();
       str="";
     
       }
      else if(str.equals("int"))
       {
     gettoken("int","Keyword",null);
           inc();
       str="";
     
       }
     else if(str.equals("float"))
       {
     gettoken("float","Keyword",null);
           inc();
       str="";
     
       }
     else if(str.equals("char"))
       {
     gettoken("char","Keyword",null);
           inc();
       str="";
     
       }
     else if(str.equals("else"))
       {
     gettoken("else","Keyword",null);
           inc();
       str="";
     
       }
          else if(str.equals("string"))
       {
     gettoken("string","Keyword",null);
           inc();
       str="";
     
       }
          else if(str.equals("end"))
       {
     gettoken("end","Keyword",null);
           inc();
       str="";
     
       }
       else{
              numid++;
              gettoken(str,"Identifier",Integer.toString(numid));
         inc();
       str="";
       }
     
   }

   else{
   str="";
   inc();
   }

}
    
    

 else{
         str=str.concat(Character.toString(c));
         inc();
         } 

}

  
     
     }
public void getSymbolTable()
{
    System.out.println("===================== SYMBOL TABLE ==========================");
    System.out.println("       LEXEME:   "+"|    "+"TOKEN NAME:"+"   |   "+"ATTRIBUTE VALUE:");
  
    for(int kmf=0;kmf<list1.size();kmf++)
    {
        
        System.out.format("%16s | %16s | %16s\n", list1.get(kmf), list1.get(kmf+1), list1.get(kmf+2));
  /*  System.out.println(list1.get(kmf)+"  |  "+list1.get(kmf+2)+"  |  "+list1.get(kmf+2));*/
kmf=kmf+2;
    }

}

    
   
public void InputFile()
{
    

  for(int i=0;i<list.size();i++)
   {
   
       System.out.println("Line Number:"+i +" , Code: "+list.get(i));
         }
}
public void getErrorMessage()
{
String pass2="";


    String str="";


String regexStr="^([a-zA-Z_$][a-zA-Z\\d_$]*)$";
    Pattern pStr = Pattern.compile(regexStr);
    
    
   
  String regexSl="\"[^\"\\\\]*(\\\\.[^\"\\\\]*)*\"";
     Pattern pSl = Pattern.compile(regexSl); 
     
     
     String regexunint="^[1-9][0-9]*|0$";
    Pattern punint = Pattern.compile(regexunint); 
for(int maar=0; maar<list.size();maar++)
{
       i=0;
 pass2=list.get(maar);

  
 while (pass2.length()!=i){
  
   c=pass2.charAt(i);
  
boolean h=Character.isWhitespace(c);
if(h==true ||c=='=' || c==';'){
  Matcher mStr = pStr.matcher(str); 
  boolean hStr=mStr.matches();

  Matcher mSl  = pSl.matcher(str); 
    boolean hSl=mSl.matches();
    
  Matcher munint  = punint.matcher(str); 
  boolean hunint=munint.matches();
if( hStr==true||hSl==true||hunint==true)
{
   
    
  inc();
  str="";

}  

else if( str.equals("")||str.equals(" ")||str.equals("+")||str.equals("-")||str.equals("/")||str.equals("*")||str.equals("=")||str.equals("(") ||str.equals(")") ||str.equals("{")  ||str.equals("}") ||str.equals(";") ||str.equals("(") ||str.equals(")") ||str.equals("{")  ||str.equals("}") ||str.equals("<") ||str.equals(">") ||str.equals("<=") ||str.equals(">=")||str.equals("<>") ||str.equals("==") ||str.equals("/*")||str.contains("/*")|| str.equals("//")||str.contains("//")  ||str.equals("*/")||str.contains("*/")) 
        {
        inc();
  str="";
        }

else{
    System.out.printf("Error:" + "%5s "  +"  and Line: %20s",str,maar);
    System.out.println("");
    str="";
  inc();
} 
}
      
       else{
         str=str.concat(Character.toString(c));
         inc();
         } 
  
 }


}


}
}