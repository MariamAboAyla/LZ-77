
import java.util.ArrayList;

public class LZ77 {


    public void compress(String data){
        // public function that calls the private compression fn; to encapsulate the implementation
        to_compress(data);
    }
    public void decompress(ArrayList<Tag> T){
        to_decompress(T);
    }


    private void to_compress (String input) // the compression fn
    {
        StringBuilder data = new StringBuilder ( );//var to carry what behinds me as a search window
        boolean flag = false;
        for (int i=0; i<input.length ();++i)//to loop on all chars in the string
        {
            String prefix = ""; //partition I form for each tag every time in inner loop
            for (int j=i; j<input.length ();++j)//loop to form partition for a tag and search in what behind me
            {
                prefix += input.charAt ( j );
                int len = prefix.length ( );//partition len to use at tag
                int pos = data.lastIndexOf ( prefix ); //pos of reptition of prefix in what behind me(data );
                if(pos==-1)//handles 2 cases -> 1-if it is 1st appearance of a letter or 2-new partition that means partition-1 appeared before
                {
                    flag = true;
                    int tmp  =  data.lastIndexOf ( prefix.substring ( 0,len-1 ) );// to handle the second case where to know where partition len -1 appeared
                    pos = j-len-tmp+1;
                    if (len==1 || tmp==-1) {
                        System.out.println ( 0 + " " + 0 + " " + prefix);
                    }
                    else{
                        System.out.println (pos+" "+(len-1)+" "+ prefix.charAt ( len-1 ));
                    }
                    i = j;
                    break;
                }
            }

            if ( (data + prefix).equals ( input ) && !flag){
                int len = prefix.length ( );
                int pos = data.lastIndexOf ( prefix );
                if(pos==-1) {

                    int tmp = data.lastIndexOf ( prefix.substring ( 0,len-1 ) );
                    pos = input.length () - len - tmp + 1;
                    if ( len == 1 )
                        System.out.println (0 + " " + 0 + " " + prefix );
                    else
                        System.out.println (pos + " " + (len - 1) + " " + prefix.charAt ( len - 1 ));
                }
                else{

                    System.out.println ( (i-pos)+" "+len+" -" );
                }
                break;
            }
            data.append ( prefix );
            flag = false;

        }

    }

   private void to_decompress(ArrayList<Tag> Tags){
        StringBuilder s = new StringBuilder();
       for (Tag tag : Tags)
           if (tag.getPos() == 0 && tag.getLen() == 0) s.append(tag.getNext());
           else {
               int start = s.length() - tag.getPos();
               s.append(s.substring(start, start + tag.getLen()));
               if (tag.getNext() != '-') s.append(tag.getNext());

           }
       System.out.println(s);
   }
}
