package math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalsTriangle {
    /*
    Write a program to print the pascal triangle up to A rows.
    Input A = 5
    Output:
        1 0 0 0 0
        1 1 0 0 0
        1 2 1 0 0
        1 3 3 1 0
        1 4 6 4 1
      Solution:
        print 1 to all the diagonal borders
        and remaining values should be filled with a[i-1][j-1]+a[i-1][j]
     */
    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().fillPascalTriangleUsingStream(5));
    }

    public List<List<Integer>> fillPascalTriangleUsingStream(int n){
        List<List<Integer>> matrix =IntStream.range(0,n).mapToObj(i->IntStream.range(0,n)
                .mapToObj(j->0).collect(Collectors.toList())).toList();
        IntStream.range(0,n).forEach(i->IntStream.range(0,i+1)
                .forEach(j->{
                    if(j==0 || i==j){
                        matrix.get(i).set(j,1);
                    }else{
                        matrix.get(i).set(j,matrix.get(i-1).get(j-1)+matrix.get(i-1).get(j));
                    }
                }));
        return matrix;
    }

    public List<List<Integer>> fillPascalTriangle(int n){
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> r = new ArrayList<>();
            for(int j=0;j<n;j++){
                r.add(0);
            }
            matrix.add(r);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    matrix.get(i).set(j,1);
                }else{
                    matrix.get(i).set(j,matrix.get(i-1).get(j-1)+matrix.get(i-1).get(j));
                }
            }
        }
        return matrix;
    }
}
