
/*Isomorphic strings are two strings where each character in one string can be mapped to a unique character in the other string, and the order of characters is maintained. This means:

        Each character from the first string maps to only one character in the second string.
        The mapping is consistent throughout the string.*/



import java.util.HashMap;

public class Isomorphic_String {

    public static boolean isIsomorphic(String s, String t){
        HashMap<Character,Character> mapST = new HashMap<>();
        HashMap<Character,Character> mapTS = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(!mapST.containsKey(charS))  {
                mapST.put(charS,charT);
            }
            if(!mapTS.containsKey(charT)){
                mapTS.put(charT,charS);
            }

            if(mapST.get(charS)!=charT||mapTS.get(charT)!=charS){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        String b = "foo";
        String r = "aug";

        // Print True beacuse string are isomorphic e->a, g->d
        boolean result = isIsomorphic(s,t);
        System.out.println(result);

        // print False because String are non-isomorphic  f->a, o->u,o->g this will violt condition beacuse not unique

        boolean result2 = isIsomorphic(b,r);
        System.out.println(result2);
    }
}
