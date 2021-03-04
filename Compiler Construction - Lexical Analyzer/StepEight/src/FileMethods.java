import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FileMethods {
ArrayList<String> lexline = new ArrayList<String>();
   public void FileRead() throws FileNotFoundException
   {
   String var;   
   String mar = null;
   File file = new File("sourcecode.txt");
String temp;
int mdpk =0;
       System.out.println("Input from File:");
     StringBuffer sb = new StringBuffer();
        Scanner input = new Scanner(file);
        {            while (input.hasNextLine())
   
            {

temp=input.nextLine(); 

lexline.add(temp);
              
mdpk++;

           }
        
        input.close();
          
        }
  
   
   }

public void FileWrite(String tostore) throws FileNotFoundException{
        File write=new File("sourcecode.txt");
       PrintWriter output=new PrintWriter(write);
       output.println(tostore);
       output.close();
}


  

   public String FileReadWithoutCommets() throws FileNotFoundException
   {
   String var;   
   String mar = null;
   File file = new File("sourcecode.txt");
   String temp;
   FileRead();
     ArrayList<String> lexemeline = new ArrayList<String>(); 
   StringBuffer sb = new StringBuffer();
   Scanner input = new Scanner(file);
        {            while (input.hasNextLine())
   
            {

temp=input.nextLine();
/*
lexemeline.add(temp);
int mdt=lexemeline.size()+1;
                System.out.println("line number:" +lexemeline.size() +"Code:"+lexemeline.get(mdt));*/
if(temp.contains("//")){
for(int i=0;i<temp.length();i++){
   int j=i+1;        
   if((temp.charAt(i)!='/' || temp.charAt(j)!='/'))
{

 
sb.append(temp.charAt(i));

}
 
   else if(temp.charAt(i)=='/' && temp.charAt(j)=='/')
{

  
 break;
 
}

}
}
else{

    sb.append(temp);

    
}

            }   
           }
        
        input.close();
        
      var=sb.toString();
             String var2="";
       //System.out.println("Project Step 2 remove /* and */");
      for(int i=0;i<var.length();i++)              {
   int j=i+1;          
if( (var.charAt(i)=='/' && var.charAt(j)=='*' ))
{
for(int k=j+1;k<var.length();k++)
    { 
        int p=k+1;
  if((var.charAt(k)=='*' &&var.charAt(p)=='/'))
  {
  i=p;
  break;
  }
    }

             }
else{
 var2=var2.concat(Character.toString(var.charAt(i))); 
    } 
        
        }
  
      TOKEN hope=    new TOKEN();   
    hope.pass=var2;
    
hope.list=lexline;

/*hope.InputFile();*/
hope.getErrorMessage();
/*
   hope.getKeywordsandIdentifer();
   hope.getStringLiteral();
   hope.getUnsignedInteger();
   var2=var2.replaceAll("[\\n\\t ]", "");

    hope.getAROPandOTOP();
   hope.getRELOPToken();

   hope.getSymbolTable();

  
   /*
   
      System.out.println(var2);*/
      
  /* 
   hope.getKeywordsandIdentifer();
       System.out.println(var2);
       var2=var2.replaceAll("[\\n\\t ]", "");/* removes whitespace*/
     
      /*System.out.println("Project 2: String after removing comments like // and /* and whitespaces");
        System.out.println(var2);*/
    
        
     /*System.out.println("Project Step 3: Identify Relational operators");
    hope.getRELOPToken();
  System.out.println("Project Step 4 : Identify Arithmetic and Other operators");
hope.getAROPandOTOP();
       
        */
return var2;  
   }





}

  

