import java.text.DecimalFormat;

public class MultiplicationMatrixMatrix {

    private int[][] resultat;
    private MatrixClass matrix1;
    private int bandWidth;
    private MatrixClass matrix2;
    private int n;
    private String type1;
    private String type2;
    double[][] matriceInverse ,matriceInvResult;
    public MultiplicationMatrixMatrix(MatrixClass mat1,MatrixClass mat2){
        matrix1= mat1;
        matrix2=mat2;
        n=matrix1.getSize();
        type1= matrix1.getType();
        type2= matrix2.getType();
        resultat= new int[n][n];
        multiplication();
    }
    public MultiplicationMatrixMatrix(MatrixClass mat1,double[][] matInverse){
        matrix1= mat1;
        n=matrix1.getSize();
        type1=mat1.getType();
        bandWidth=MatrixClass.bandwidth;
        matriceInverse=matInverse;
        matriceInvResult=new double[n][n];
        multiplicationMatriceInverse();

    }
    //multiplication matrice bande matrice inverse
    private void multiplicationMatriceBandInverse() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=Math.max(0, i-bandWidth);k<=Math.min(n-1, i+bandWidth);k++){
                    matriceInvResult[i][j]+=matrix1.matrix[i][k]*matriceInverse[k][j];
                }
            }
        }
    }
    //multiplication matrice bande matrice inverse
    private void multiplicationMatriceDenseInverse() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    matriceInvResult[i][j]+=matrix1.matrix[i][k]*matriceInverse[k][j];
                }
            }
        }
    }
    public void multiplicationMatriceInverse(){
        switch (type1) {
            case "bande":
                multiplicationMatriceBandInverse();
                break;
            default:
                multiplicationMatriceDenseInverse();
                break;
        }
    }

    public void multipMatrixTriangSup_MatrixTriangSup(){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for(int k=i;k<=j;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixTriangInf_MatrixTrianginf(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                for(int k=j;k<=i;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixTriangSup_MatrixDense(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=0;k<n;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixTrianginf_MatrixDense(){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for(int k=0;k<=i;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixDense_MatrixDense(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=0;k<n;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixTriangSup_MatrixTrianginf(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=(i > j) ? i : j; k <n; k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixTriangInf_MatrixTriangSup(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=0; k <=((i > j) ? j : i); k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixDense_MatrixTriangSup(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=0;k<=j;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    public void multipMatrixDense_MatrixTriangInf(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k=j;k<n;k++){
                    resultat[i][j] +=matrix1.matrix[i][k]*matrix2.matrix[k][j];
                }
            }
        }
    }
    

    public void multiplication(){
        switch (type1) {
            case "triangsup":
                switch (type2) {
                    case "triangsup":
                        multipMatrixTriangSup_MatrixTriangSup();
                        break;
                    case "trianginf":
                        multipMatrixTriangSup_MatrixTrianginf();
                        break;
                    case "dense":
                        multipMatrixTriangSup_MatrixDense();
                        break;
                
                    default:
                        multipMatrixDense_MatrixDense();
                        break;
                }
                break;
            case "trianginf":
                switch (type2) {
                    case "triangsup":
                        multipMatrixTriangInf_MatrixTriangSup();
                        break;
                    case "trianginf":
                        multipMatrixTriangInf_MatrixTrianginf();
                        break;
                    case "dense":
                        multipMatrixTrianginf_MatrixDense();
                        break;
                    default:
                        multipMatrixDense_MatrixDense();
                        break;
                }
                break;
            case "dense":
                switch (type2) {
                    case "triangsup":
                        multipMatrixDense_MatrixTriangSup();
                        break;
                    case "trianginf":
                        multipMatrixDense_MatrixTriangInf();
                        break;
                    case "dense":
                        multipMatrixDense_MatrixDense();
                        break;
                    default:
                        multipMatrixDense_MatrixDense();
                        break;
                }
                break;
            case "bande":
                switch (type2) {
                    case "bandeInf":
                        //mult
                        break;
                }
                break;
            
            default:
                multipMatrixDense_MatrixDense();
                break;
        }
    }
    public String afficheMatrix() {
        StringBuilder matrixString = new StringBuilder("<html><table>");
        for (int i = 0; i < n; i++) {
            matrixString.append("<tr>");
            for (int j = 0; j < n; j++) {
                matrixString.append("<td>").append(resultat[i][j]).append("</td>");
            }
            matrixString.append("</tr>");
        }
        matrixString.append("</table></html>");
        return matrixString.toString();
    }
     public String affichemultipInverse() {
        StringBuilder matrixString = new StringBuilder("<html><table>");
        DecimalFormat format = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            matrixString.append("<tr>");
            for (int j = 0; j < n; j++) {
                matrixString.append("<td>").append(format.format(matriceInvResult[i][j])).append("</td>");
            }
            matrixString.append("</tr>");
        }
        matrixString.append("</table></html>");
        return matrixString.toString();
    }

}