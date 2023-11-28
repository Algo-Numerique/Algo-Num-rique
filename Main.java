public class Main {
    public static void main(String[] args) {
        MatrixClass mat= new MatrixClass("Dense", 9);
        System.out.println(mat.afficheMatrix());
        Vector vect=new Vector(9);
        System.out.println("µµµµµµµµµµµµµµµ");
        DecompositionLU res=new DecompositionLU(mat, vect);
        System.out.println("matrice L   :"+res.getL());
        System.out.println("******************************");
        System.out.println("matrice U   :"+res.getU());
        System.out.println("*****************************");
        System.out.println(res.afficheVector());



        
        
    }
}
