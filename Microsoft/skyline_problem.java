public class Solution {
    
    private class Point{
        int x;
        int y;
        boolean left_point;
        public Point(int x, int y, boolean left_point){
            this.x = x;
            this.y = y;
            this.left_point = left_point;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<int[]>();
        if (buildings.length == 0) return res;
        
        Point[] points = new Point[buildings.length*2];
        for (int i = 0; i < buildings.length; i++){
            points[2*i] = new Point(buildings[i][0], buildings[i][2], true);
            points[2*i+1] = new Point(buildings[i][1], buildings[i][2], false);
        }
        
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if (p1.x == p2.x){// there are 4 corner cases when two points have the same x value
                    if (p1.left_point != p2.left_point)
                        return (p1.left_point)? -1:1;
                    else{
                        if (p1.left_point)
                            return p2.y - p1.y;
                        else return p1.y - p2.y;
                    }
                }
                else return p1.x - p2.x;
            }
        });

        //for (Point point: points)
        //    System.out.println(point.x + " " + point.y + " " + point.left_point);
    
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 1);
        
        for (int i = 0; i < points.length; i++){
            Point point = points[i];
            int max = map.lastKey();
            
            if (point.left_point){
                if (!map.containsKey(point.y))
                    map.put(point.y, 0);
                map.put(point.y, map.get(point.y)+1);
                int newMax = map.lastKey();
                if (newMax != max)
                    res.add(new int[]{point.x, point.y});
            }
            else{
                map.put(point.y, map.get(point.y)-1);
                if (map.get(point.y) == 0)
                    map.remove(point.y);
                int newMax = map.lastKey();
                if (newMax != max)
                    res.add(new int[]{point.x, newMax});
            }
        }
        return res;
    }
}