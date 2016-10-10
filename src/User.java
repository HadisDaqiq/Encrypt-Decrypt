import java.util.Scanner;
 
public class User {
     
    /** Creating new instance of User */
    public User (String key, String plain) {
        keyword=key;
        firstText=plain;
    }
     
    public void UserEntery() { 
         
        Encrypt();
        FillCharacMatrix();
        Decrypt();
        Subtit();
         
    }
   
     

	private void Subtit() {
		// TODO Auto-generated method stub
		
	}

	public String getEncrypt(){
        return encrypt;
    }
     
     
    public String getDecrypt(){
        return decrypt;
    }
     
     
    public void FillCharacMatrix(){
         
        for(int i=0; i<=25; i++){
            for(int j=0; j<=25; j++){
                CharMatrix[i][j]=characters[(j+i)%26];
            }
        }
         
        for(int i=0;i<=25;i++) {
             
            System.out.print(" | ");
            for(int j=0;j<=25;j++) {
                 
                 
                System.out.print(" "+CharMatrix[i][j]+" ");
            }
            System.out.println(" | ");
             
        }
    }
     //*Here we have 3 sub string, sub1 takes the orginal text and as it goes forward it adds 1 more*/
    //* sub 2 
    public void Encrypt() {
        int sub1=0,sub2=0,sub3=0;
        int sub=0;
        int start=0;
        for(int i=0; i<firstText.length(); i++) {
            sub1=firstText.substring(i,i+1).codePointAt(0);
            sub2=keyword.substring(start,start+1).codePointAt(0);
            start++;
            sub3=sub1+sub2;
            sub3=sub3%97;
            sub=sub3%26;
             
            if(encrypt==null)
                encrypt=""+characters[sub];
            else
                encrypt+=characters[sub];
             
            
             
            if(start==keyword.length()){
                start=0;
             
             
            }
       
        
    
             
        }
      //  System.out.println("The Encryption is: "+ encrypt);
        //String Upper = encrypt.toUpperCase();
    }
    
    
    
    public void Decrypt(){
        int sub1=0,sub2=0,sub3=0;
        int start=0;
        for(int i=0; i<firstText.length(); i++) {
            sub1=encrypt.substring(i,i+1).codePointAt(0);
            sub2=keyword.substring(start,start+1).codePointAt(0);
             
            start++;
             
            sub1=(sub1%97)%26;
            sub2=(sub2%97)%26;
             
             
            for(int k=0; k<26; k++) {
                sub3=(Integer.parseInt(""+(short)CharMatrix[sub2][k])%97)%26;
                 
                if(sub1==sub3){
                     
                    if(decrypt==null)
                        decrypt=Character.toString(CharMatrix[0][k]);
                    else
                        decrypt+=Character.toString(CharMatrix[0][k]);
                    System.out.println(decrypt);
                }
            }
             
             
            if(start==keyword.length()){
                start=0;
            }
        }
        System.out.println("The Decrypt code: "+ decrypt);
         
    }
     
    private String firstText;
    private String keyword;
    private String encrypt;
    private char [][] CharMatrix=new char[26][26];
    private char characters[]= {'a','b','c','d','e','f','g','h',
'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private String decrypt;
	
}
