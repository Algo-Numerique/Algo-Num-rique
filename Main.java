public class Main {
    public static void main(String[] args) {
        MatrixClass mat= new MatrixClass("dense", 3);
        System.out.println(mat.afficheMatrix());
         MatrixClass mat1= new MatrixClass("dense", 3);
        System.out.println(mat1.afficheMatrix());
        MultiplicationMatrixMatrix mult=new MultiplicationMatrixMatrix(mat, mat1);
        System.out.println(mult.afficheMatrix());
        
    }
}
