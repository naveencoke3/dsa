package array;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SumOfAllSubMatrices {
    /*
    Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
    Input:
    A = [ [1, 1]
      [1, 1] ]

      Output: 16

      Explanation:
        Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
        Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
        Number of submatrices with 3 elements = 0
        Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
        Total Sum = 4+8+4 = 16
     */
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(List.of(1,1),List.of(1,1));
        //System.out.print(new SumOfAllSubMatrices().sumOfAllSubMatrices(matrix));
        System.out.print(new SumOfAllSubMatrices().sumOfAllSubMatricesUsingStream(matrix));
    }

    public Integer sumOfAllSubMatricesUsingStream(List<List<Integer>> matrix){
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(0,matrix.size()).forEach(i->{
            IntStream.range(0,matrix.get(0).size()).forEach(j->{
                sum.set(sum.get()+matrix.get(i).get(j) * (i+1) * (j+1) * (matrix.size()-i) * (matrix.get(0).size()-j));
            });
        });
        return sum.get();

        //Another way
        /* return IntStream.range(0, matrix.size())
                .mapToObj(i -> IntStream.range(0, matrix.get(0).size())
                        .map(j -> matrix.get(i).get(j) * (i + 1) * (j + 1) * (matrix.size() - i) * (matrix.get(0).size() - j))
                        .sum()
                )
                .reduce(0, Integer::sum);*/
    }

    public Integer sumOfAllSubMatrices(List<List<Integer>> matrix){
        int sum = 0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                sum += matrix.get(i).get(j) * (i+1) * (j+1) * (matrix.size()-i) * (matrix.get(0).size()-j);
            }
        }
        return sum;
    }
}
