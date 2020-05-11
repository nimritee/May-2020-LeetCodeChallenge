#Cousions in Binary Tree

#In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
#Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
#We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
#Return true if and only if the nodes corresponding to the values x and y are cousins.

#Example 1:
#Input: root = [1,2,3,4], x = 4, y = 3
#Output: false

#Example 2:
#Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
#Output: true

#Example 3:
#Input: root = [1,2,3,null,4], x = 2, y = 3
#Output: false
 
#Note:
#The number of nodes in the tree will be between 2 and 100.
#Each node has a unique integer value from 1 to 100.

class Solution {
    int[] getLevel(TreeNode root, int x, int level, int parent)
    {
        if(root==null)
        {
            int[] result = {-1,-1};
            return result;    
        }
        if(x==root.val)
        {
            int[] result= {level,parent};
            return result;
        }
        else
        {
            int[] i = getLevel(root.left,x,level+1, root.val);
            int[] j = getLevel(root.right,x,level+1, root.val);
            if(i[0]!=-1)
                return i;
            else
                return j;
        }               
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] levelX = getLevel(root,x,0,root.val);
        int[] levelY = getLevel(root,y,0,root.val);
        if(levelX[0]==levelY[0] && levelX[1]!=levelY[1])
        {
            return true;
        }
        else
            return false;
    }
}
