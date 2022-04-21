import java.util.ArrayList;
import java.util.concurrent.Callable;

public class CallableTest<T> implements Callable<ArrayList<T>> {
    ArrayList<T> arr;
    T t;

    CallableTest(ArrayList<T> arr,T t){
        this.arr=  arr;
        this.t=t;
    }

    public static <T> ArrayList<T> getValueByType(T type, ArrayList<T> arr) {
        ArrayList<T> subArrayList = new ArrayList<>();
        if (arr.contains(type)) {
            for (int i = 0; i < arr.size(); i++) {
                T value = arr.get(i);
                if (value == type) {
                    subArrayList.add(value);
                }

            }
        }
        return subArrayList;
    }

    @Override
    public ArrayList<T>  call() throws Exception {
       return getValueByType(t,arr);
    }
}