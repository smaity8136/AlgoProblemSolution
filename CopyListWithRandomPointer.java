public class CopyListWithRandomPointer{


 class RandomListNode {
     int val;
     RandomListNode next, random;
     RandomListNode(int x) { this.val = x; }
 }
 
 
 public static copyRandomNode (RandomListNode node){
 // create list map
 
   RandomListNode curr = node;
   
   Map<RandomListNode,RandomListNode>map = new HashMap<RandomListNode,RandomListNode>();
   
   while (curr!=null){
     map.put(curr, new RandomListNode(curr.val) )
	 curr = curr.next;
   
   }
   
   
  //copy next pointer

  curr = node;

while (curr!=null){
  map.get(curr).next = map.get(curr.next);

  curr = curr.next;  
 }
 
 
 curr = node;
 
 while (curr!=null){
  map.get(curr).random = map.get(curr.random);

  curr = curr.next;  
 }
 
 return map.get(node);
 
 
 }
 
 
 
 

}
