public class MultiplicationMatrixVector {
    private int[] resultat;
    private MatrixClass matrix;
    private Vector vector;
    private int n;
    private String type;
    public MultiplicationMatrixVector(MatrixClass mat,Vector vect){
        matrix= mat;
        vector=vect;
        n=matrix.getSize();
        type= matrix.getType();
        resultat= new int[n];
        multiplication();
    }
    public void multipMatrixTriangSup(){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                resultat[i] +=matrix.matrix[i][j]*vector.vector[j];
            }
        }
    }
    public void multipMatrixTriangInf(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                resultat[i] +=matrix.matrix[i][j]*vector.vector[j];
            }
        }
    }
    public void multipMatrixBande(){
        for (int i = 0; i < n; i++) {
            for (int j = ((i-2) > 0) ? (i-2) : 0; j <( (n > (i+3)) ? (i+3) : n); j++) {
                resultat[i] +=matrix.matrix[i][j]*vector.vector[j];
            }
        }
    }
    public void multipMatrixDense(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultat[i] +=matrix.matrix[i][j]*vector.vector[j];
            }
        }
    }
    public void multiplication(){
        switch (type) {
            case "triangsup":
                multipMatrixTriangSup();
                break;
            case "trianginf":
                multipMatrixTriangInf();
                break;
            case "dense":
                multipMatrixDense();
                break;
            case "bande":
                multipMatrixBande();
                break;
            default:
                break;
        }
    }
    public String afficheResult(){
        String str="";
        for (int i = 0; i < n; i++) {
               str+=resultat[i]+"\n";
        }
        return str;
    }

}
