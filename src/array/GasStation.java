package array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int gasSum = 0, costSum = 0, index;
        int unquie = -1;

        for(int i = 0; i < length; ++i) {
            if(gas[i] >= cost[i]) {

                for(int j = 0; j < length; ++j) {
                    index = (i+j) % length;
                    gasSum += gas[index];
                    costSum += cost[index];
                    if(gasSum < costSum) {
                        gasSum = 0;
                        costSum = 0;
                        break;
                    }
                    if(j == length-1) {
                        System.out.println("i="+i);
                        if(unquie == -1) {
                            unquie = i;
                            gasSum = 0;
                            costSum = 0;
                        } else {
                            return -1;
                        }
                    }
                }

            }
        }

        return unquie;
    }

    public static void main(String[] args) {
        int[] gas  = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};

        int result = new GasStation().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
