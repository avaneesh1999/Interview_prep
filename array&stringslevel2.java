public class Solution {

    //Linctcode 912
    //https://www.lintcode.com/problem/912/
    
    public int minTotalDistance(int[][] grid) {
        //make xcord
        ArrayList<Integer> xcord=new ArrayList<>();

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    xcord.add(r);
                }
            }
        }

        //make ycord
         ArrayList<Integer> ycord=new ArrayList<>();

         for(int c=0;c<grid[0].length;c++){
            for(int r=0;r<grid.length;r++){
                if(grid[r][c]==1){
                    ycord.add(c);
                }
            }
        }

        //meeting point

        int x=xcord.get(xcord.size()/2);
        int y=ycord.get(ycord.size()/2);

        // calculate distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

        int dist=0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    dist+=Math.abs((x-r)) +Math.abs((y-c));
                }
            }
        }

        return dist;



     }
}