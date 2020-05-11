#Check if straight Line

#You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
#Check if these points make a straight line in the XY plane.

#Example 1
#Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
#Output: true

#Example 2
#Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
#Output: false

#Constraints:

#2 <= coordinates.length <= 1000
#coordinates[i].length == 2
#-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
#coordinates contains no duplicate point.

#Hint 1
#If there're only 2 points, return true.

#Hint 2
#Check if all other points lie on the line defined by the first 2 points.

#Hint 3
#Use cross product to check collinearity.

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int nums[]=coordinates[0] ;
        int num1[]=coordinates[1];
        float slope= slope(nums,num1);
        
        for(int i=2;i<coordinates.length;i++)
        {
            int num3[]=coordinates[i];
            float new_slope = slope(nums,num3);
            
            if(new_slope != slope)
                return false;
        }
            
            return true;

        
    }
    
    float slope(int[]num,int []num1)
    {
        return (float)(num1[1]-num[1])/(num1[0]-num[0]);
    }
    
}
