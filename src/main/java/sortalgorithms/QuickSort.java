package sortalgorithms;

public class QuickSort extends SortAlgorithm<Integer> {

    private Integer[] quickSort(Integer[] inputArray) {
        doQuickSort(inputArray, 0, inputArray.length - 1);
        return inputArray;
    }


    private int partition(Integer[] a, int p, int r) {

        int x = a[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            while (++i < r && a[i] < x) ;
            while (--j > p && a[j] > x) ;

            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                return j;
            }
        }
    }

    public void doQuickSort(Integer[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            doQuickSort(a, p, q);
            doQuickSort(a, q + 1, r);
        }
    }

    @Override
    public Integer[] sort(Integer[] inputArray) {
        return quickSort(inputArray);
    }
}
