import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }

        for(String player : callings){
            int rank = map.get(player);

            String temp = players[rank - 1];
            players[rank - 1] = player;
            players[rank] = temp;

            map.put(player, rank - 1);
            map.put(temp, rank);
        }

        return players;
    }
}