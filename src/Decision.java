import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class Decision<T> {

    public static void main(String[] args) {
        ArrayList<String> weather = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"
                                                                    , "b", "b", "c", "e", "f", "g", "f", "a"
                                                                    , "c", "c", "d", "f", "f", "a", "e", "a"
                                                                    , "c", "d", "d", "f", "f", "h", "e", "a"
                                                                    , "c", "b", "a", "f", "f", "a", "e", "g"));
//        ArrayList<String> weather= new ArrayList<>(Arrays.asList("a", "b", "c"));

        final String[] TYPE={"a", "b", "c", "d", "e", "f", "g", "h"};

        final int numOfThreads = 5;
        ArrayList<ArrayList<String>> multiSubArrayList = getMultiSubArrayList(weather, numOfThreads);
        ArrayList<ArrayList<CallableTest>> callableTestArrayList = new ArrayList<>();
        ArrayList<ArrayList<Future<ArrayList<String>>>> futureArrayList = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> result = new ArrayList<>();

        // Add sub-array list
//        for (int i = 0; i < multiSubArrayList.size(); i++){
//            callableTestArrayList.add(new ArrayList<>());
//            futureArrayList.add(new ArrayList<>());
//            result.add(new ArrayList<>());
//        }

        // Add sub-array list
        for (int i = 0; i < TYPE.length; i++){
            callableTestArrayList.add(new ArrayList<>());
            futureArrayList.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }



        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        // Create Callable
        for(int i = 0; i < TYPE.length; i++) {
                for (int j = 0; j < multiSubArrayList.size(); j++) {
                callableTestArrayList.get(i).add(new CallableTest(multiSubArrayList.get(j),TYPE[i] ));
            }
        }

        // submit callable
        for(int i = 0; i < TYPE.length; i++) {
            for (int j = 0; j < multiSubArrayList.size(); j++) {
                futureArrayList.get(i).add(executorService.submit(callableTestArrayList.get(i).get(j)));
            }
        }

        // get result
        for(int i = 0; i < TYPE.length; i++) {
            for (int j = 0; j < multiSubArrayList.size(); j++) {
                try {
                    result.get(i).add(futureArrayList.get(i).get(j).get(100, TimeUnit.MINUTES));
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }

            }
        }

        executorService.shutdown();
        System.out.println(result);
    }

    public static <T> ArrayList<T> getValueByType(T type, ArrayList<T> arr){
        ArrayList<T> subArrayList=new ArrayList<>();
        if( arr.contains(type)){
            for(int i=0;i< arr.size();i++){
                T value=arr.get(i);
                if (value==type){
                    subArrayList.add(value);
                }

            }
        }
        return subArrayList;

    }

    public static <T> ArrayList<T> getSubArrayList(ArrayList<T> originalArrayList, int startIndex, int endIndex){
        ArrayList<T> subArrayList=new ArrayList<>();
        for(int i=startIndex;i<endIndex;i++){
            subArrayList.add(originalArrayList.get(i));
        }
        return subArrayList;
    }

    public static <T> ArrayList<ArrayList<T>>  getMultiSubArrayList(ArrayList<T> originalArrayList, int numberOfSubArray){
        ArrayList<ArrayList<T>> arrayOfSubArrayList=new ArrayList<>();
        int numberOfItemsOfEachSubArray=originalArrayList.size()/numberOfSubArray;
        int remainder=originalArrayList.size()%numberOfSubArray;
//        System.out.println("Number of items of each sub Array: "+numberOfItemsOfEachSubArray);

        // If the array is too small
        if(numberOfItemsOfEachSubArray<2){
//            System.out.println("Array size is too small to divide: "+originalArrayList.size());
            arrayOfSubArrayList.add(originalArrayList);

        }
        else{
            int startIndex=0;
            int stopIndex;
            for(int i=0;i<numberOfSubArray;i++){
                if(i==numberOfSubArray-1){
                    stopIndex= startIndex+numberOfItemsOfEachSubArray+remainder;
                }
                else {
                    stopIndex = startIndex + numberOfItemsOfEachSubArray;
                }
//                System.out.println("Step: "+(i+1));
//                System.out.println("Start Index = : "+startIndex);
//                System.out.println("Stop Index = : "+stopIndex);
                ArrayList<T> subArrayList = getSubArrayList(originalArrayList,startIndex,stopIndex);
                arrayOfSubArrayList.add(subArrayList);
                // Set new start index
                startIndex=stopIndex;
            }

        }

//        System.out.println(arrayOfSubArrayList);
        return arrayOfSubArrayList;
    }

    public static <T> void printArray(ArrayList<T> arr){
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).toString());;
        }
    }



}
