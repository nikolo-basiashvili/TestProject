import java.util.*;


public class Main {
    public static void main(String[] args) {
        int[] fromIds = new int[]{1,7,3,4,6,2,9};
        int[] toIds = new int[]  {3,3,4,6,2,4,5};
        int startId = 7;
        System.out.println(findNetworkEndpoint(startId, fromIds, toIds));
    }

    public static int moduleThreeSum(int [] arr){
        return Arrays.stream(arr).filter(num -> num%3 == 0).sum();
    }

    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds){
        Set<Integer> visited = new HashSet<>();
        return wrapperFunc(startNodeId, fromIds, toIds, visited);
    }

    private static int wrapperFunc(int startNodeId, int[] fromIds, int[] toIds, Set<Integer> set) {
        if(set.contains(startNodeId)){
            int index = -1;
            for(int i = 0; i<toIds.length; i++){
                if(startNodeId == toIds[i]){
                    index = i;
                }
            }
            return fromIds[index];
        }else{
            set.add(startNodeId);
            int currNodeIndex = -1;
            for(int i = 0; i<fromIds.length; i++){
                if(fromIds[i] == startNodeId && !set.contains(toIds[i])){
                    currNodeIndex = i;
                }
            }
            if(currNodeIndex == -1){
                return startNodeId;
            }
            return wrapperFunc(toIds[currNodeIndex], fromIds, toIds, set);
        }
    }
}