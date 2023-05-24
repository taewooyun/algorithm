class Solution {
    public int[] solution(String[] wallpaper) {
        int minX, minY, maxX, maxY;
        minX = minY = 50;
        maxX = maxY = 0;

        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j+1);
                    maxY = Math.max(maxY, i+1);
                }
            }
        }
        return new int[] {minY, minX, maxY, maxX};
    }
}