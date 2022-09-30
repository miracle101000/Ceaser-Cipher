import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
  public static final int TOT_ALPHABETS = 26;
  public static void main (String[]args)
  {
    Scanner sc = new Scanner(System.in);
    String arr = "abcdefghijklmnopqrstuvwxyz";
    String input = sc.nextLine();
    int key = sc.nextInt();
      HashMap < Character, Character > cypher =
      createCypher (key, toArrayOfCharacters (arr), true);
      getCypherResult (toArrayOfCharacters (input), cypher, true);

  }

  static char[] toArrayOfCharacters (String str)
  {
    char[] arr = new char[str.length ()];
    for (int i = 0; i < str.length (); i++)
      {
	arr[i] = str.toLowerCase ().charAt (i);
      }
    return arr;
  }

  // Key is position shift, list of alphabets, isEncoded: encrypt or decrypt
  static HashMap < Character, Character > createCypher (int key,
							char[]alphabets,
							boolean isEncode)
  {
    HashMap < Character, Character > map =
      new HashMap < Character, Character > ();
    int mkey = key;
    if (key > TOT_ALPHABETS)
      {
	mkey = key % TOT_ALPHABETS;
      }
    for (int i = 1; i < mkey + 1; i++)
      {
	if (isEncode == true)
	  {

	    map.put (alphabets[TOT_ALPHABETS - i], alphabets[mkey - i]);
	  }
	else
	  {
	    map.put (alphabets[mkey - i], alphabets[TOT_ALPHABETS - i]);	// z:a
	  }
      }

    for (int i = 0; i < alphabets.length - mkey; i++)
      {
	if (isEncode == true)
	  {
	    map.put (alphabets[i], alphabets[i + mkey]);
	  }
	else
	  {
	    map.put (alphabets[i + mkey], alphabets[i]);
	  }
      }
    return map;
  }

  static void getCypherResult (char[]input, HashMap < Character,
			       Character > cypher, boolean isEncode)
  {
    char[] result = new char[input.length];
    for (int i = 0; i < input.length; i++)
      {
	result[i] = cypher.get (input[i]);
      }

    if (isEncode == true)
      {
	System.out.println ("Encrypted message is:" +
			    new String (result).toUpperCase ());
      }
    else
      {
	System.out.println ("Decrypted message is:" +
			    new String (result).toLowerCase ());

      }
  }
}
