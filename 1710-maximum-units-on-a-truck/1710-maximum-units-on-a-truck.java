class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int totalunits =0;
        for(int[] box :boxTypes){
            int boxes = box[0];
            int unitperbox = box[1];
            int take = Math.min(boxes,truckSize);
            totalunits += take*unitperbox ;
            truckSize -=take;
            if(truckSize ==0){
                break;
            }
        }
        return totalunits;
    }
}