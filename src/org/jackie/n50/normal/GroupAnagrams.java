package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jackie.common.Tools;
import org.junit.Test;
//49. ×ÖÄ¸ÒìÎ»´Ê·Ö×é
public class GroupAnagrams {
  @Test
  public void test1() {
      GroupAnagrams fun = new GroupAnagrams();
      List<List<String>> list = new ArrayList<List<String>>();
      list.add(Tools.generateList(new String[]{"ate","eat","tea"}));
      list.add(Tools.generateList(new String[]{"nat","tan"}));
      list.add(Tools.generateList(new String[]{"bat"}));
      assertEquals(Tools.compareArrayList(fun.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), 
              list), true);
  }    
  public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList<List<String>>();
      for ( int i = 0; i < strs.length; i++ )
      {
          boolean flag = false;
          for ( List<String> list : result )
          {
              String element = list.get( 0 );
              if(compareStr(element, strs[i])) {
                  list.add( strs[i] );
                  flag = true;
                  break;
              }                    
          }
          if(!flag) {
              List<String> list = new ArrayList<String>();
              list.add( strs[i] );
              result.add( list );
          }
      }
      return result;
  }

  private boolean compareStr( String left, String right )
  {
      if ( left.length() != right.length() )
          return false;
      char[] leftChars = left.toCharArray();
      char[] rightChars = right.toCharArray();
      Arrays.sort(leftChars);
      Arrays.sort(rightChars);
      String leftStr = new String(leftChars);
      String rightStr = new String(rightChars);
      if ( leftStr.equals( rightStr ) )
          return true;
      return false;
  }
}
