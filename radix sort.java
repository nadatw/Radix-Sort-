import java.util.LinkedList;

public class RadixSort {

    public static void sort(LinkedList<Integer> numbers) {

        LinkedList<LinkedList<Integer>> groups = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            groups.add(new LinkedList<Integer>());
        }

        int largest = 0;

        for (int n : numbers) {
            largest = Math.max(largest, n);
        }

        long place = 1;

        while (largest / place > 0) {

            for (int n : numbers) {
                int index = (int) ((n / place) % 10);
                groups.get(index).addLast(n);
            }

            numbers.clear();

            for (int i = 0; i < groups.size(); i++) {
                while (!groups.get(i).isEmpty()) {
                    numbers.addLast(groups.get(i).removeFirst());
                }
            }

            place *= 10;
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(329);
        numbers.add(457);
        numbers.add(657);
        numbers.add(839);
        numbers.add(436);
        numbers.add(720);
        numbers.add(355);
        numbers.add(12);

        System.out.println("Original List: " + numbers);

        sort(numbers);

        System.out.println("Sorted List: " + numbers);
    }
}
