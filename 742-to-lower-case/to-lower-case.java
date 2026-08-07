class Solution {
    public String toLowerCase(String s) {
        char ch;
        
        int n= s.length();
        char[]arr = new char[n];
        
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(Character.isUpperCase(c)){
                int x = c;
                x+= 32;
                c = (char)x;     
            }
                arr[i]= c;
                        }
                                  
                            
                      String str = new String(arr);
                      return str;
        }
            
        }

    