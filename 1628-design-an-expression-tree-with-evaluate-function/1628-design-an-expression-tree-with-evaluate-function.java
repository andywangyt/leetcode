/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */


/*
abstract class Node {
    public abstract int evaluate();
    // define your fields here
};
*/

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */


/*
class TreeBuilder {
    Node buildTree(String[] postfix) {
        
    }
};
*/


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */




class Node {
    static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = 
        Map.ofEntries(
            Map.entry("+", (op1, op2) -> op1 + op2),
            Map.entry("-", (op1, op2) -> op1 - op2),
            Map.entry("*", (op1, op2) -> op1 * op2),
            Map.entry("/", (op1, op2) -> op1 / op2)
        );
    
    Node(String val, Node left, Node right){
        this.val = val;   
        this.left = left;
        this.right = right;
    }
    
    final Node left;
    final Node right;
    final String val;

    public int evaluate(){
        if(OPERATIONS.containsKey(val)){
            return OPERATIONS.get(val).apply(left.evaluate(), right.evaluate());
        }
        return Integer.valueOf(val);
    }
};

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String token: postfix){
            if(Node.OPERATIONS.keySet().contains(token)){
                // operator
                Node o2 = stack.pop();
                Node o1 = stack.pop();
                stack.push(new Node(token, o1, o2));
            } else{
                // operand
                stack.push(new Node(token, null, null));
            }
        }
        return stack.pop();
    }
};
